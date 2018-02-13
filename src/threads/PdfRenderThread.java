package threads;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import view.projectView.pdfObjectView.partials.PdfArea;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfRenderThread implements Runnable {

    public static final ThreadGroup PDF_RENDER_GROUP
        = new ThreadGroup("pdfRenderGroup");

    private PdfArea pdfArea;
    private float requiredZoom;

    private BufferedImage reRenderedPdfImage;

    private boolean isImportInitial;

    /*
     * #########################################################################
     * #                    Constructors                                       #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Constructs a new PdfRender-Thread. Considers initial imports.
     */
    public PdfRenderThread(PdfArea pdfArea, boolean isImportInitial)
    {
        this.pdfArea = pdfArea;
        this.requiredZoom = (float) pdfArea.getZoomLevel();
        this.isImportInitial = isImportInitial;

        Thread thread = new Thread(
            PdfRenderThread.PDF_RENDER_GROUP,
            this
        );
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Constructs a new PdfRender-Thread.
     */
    public PdfRenderThread(PdfArea pdfArea)
    {
        this.pdfArea = pdfArea;
        this.requiredZoom = (float) pdfArea.getZoomLevel();
        this.isImportInitial = false;

        Thread thread = new Thread(
            PdfRenderThread.PDF_RENDER_GROUP,
            this
        );
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the re-rendered pdfImage.
     */
    public BufferedImage getRenderedPdfImage()
    {
        return this.reRenderedPdfImage;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns whether the pdfImage of this thread has been imported
     *          initially or not.
     */
    public boolean isImportInitial()
    {
        return this.isImportInitial;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Method called every time a thread gets started.
     */
    @Override
    public void run()
    {
        //@todo remove sysout
        System.out.println(PDF_RENDER_GROUP.activeCount());

        this.renderPdfImage();

        if (this.requiredZoom == (float) this.pdfArea.getZoomLevel())
        {
            this.pdfArea.appointReRenderedPdf();
        }
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Renders the reRenderedPdfImage on the zoom level, that was required when
     *          the thread has been started.
     */
    private void renderPdfImage()
    {
        try
        {
            File pdfFile = new File(
                this.pdfArea.getPdfObject().getPdfAbsolutePath()
            );
            PDDocument pdfDocument = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(pdfDocument);
            this.reRenderedPdfImage = renderer.renderImage(
                0,
                requiredZoom);
            pdfDocument.close();
        }
        catch (IOException ioException)
        {
            this.reRenderedPdfImage = null;
            ioException.printStackTrace();
        }
    }
}
