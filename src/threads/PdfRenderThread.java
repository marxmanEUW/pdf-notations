package threads;

import constants.Environment;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import view.projectView.pdfObjectView.partials.PdfArea;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfRenderThread implements Runnable {

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
            Environment.PDF_RENDER_GROUP,
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
            Environment.PDF_RENDER_GROUP,
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
     *      2018-03-06 (yxyxD)  removed the error output when the rendering
     *                          fails
     * @brief   Method called every time a thread gets started. Renders the
     *          reRenderedPdfImage on the zoom level, that was required when
     *          the thread has been started.
     */
    @Override
    public void run()
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

            if (this.requiredZoom == (float) this.pdfArea.getZoomLevel())
            {
                this.pdfArea.appointReRenderedPdf();
            }
        }
        catch (IOException ioException)
        {
            // if the re-rendering fails => do nothing
        }
    }

}
