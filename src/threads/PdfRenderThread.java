package threads;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import view.projectView.pdfObjectView.partials.PdfArea;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfRenderThread implements Runnable {

    private static final ThreadGroup PDF_RENDER_GROUP
        = new ThreadGroup("pdfRenderGroup");

    private PdfArea pdfArea;
    private float requiredZoom;

    private BufferedImage pdfImage;

    private boolean isImportInitial;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public PdfRenderThread(PdfArea pdfArea, boolean isImportInitial)
    {
        this.pdfArea = pdfArea;
        this.requiredZoom = (float) pdfArea.getZoomLevel();
        this.isImportInitial = isImportInitial;

        setupThread();
    }

    /*
     * @author  yxyxD
     */
    public PdfRenderThread(PdfArea pdfArea)
    {
        this.pdfArea = pdfArea;
        this.requiredZoom = (float) pdfArea.getZoomLevel();
        this.isImportInitial = false;

        setupThread();
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public BufferedImage getRenderedPdfImage()
    {
        return this.pdfImage;
    }

    /*
     * @author  yxyxD
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
     */
    @Override
    public void run()
    {
        System.out.println(PDF_RENDER_GROUP.activeCount());

        this.pdfImage = this.renderPdfImage();

        if (this.requiredZoom == (float) this.pdfArea.getZoomLevel())
        {
            this.pdfArea.reRenderPdf();
        }
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    private void setupThread()
    {
        // avoid having more thant 5 threads by disabling the zoom
        if (PdfRenderThread.PDF_RENDER_GROUP.activeCount() >= 4)
        {
            this.pdfArea.disableZoom();
        }

        Thread thread = new Thread(PdfRenderThread.PDF_RENDER_GROUP,this);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    /*
     * @author  yxyxD
     */
    private BufferedImage renderPdfImage()
    {
        BufferedImage pdfImage = null;

        try
        {
            File pdfFile = new File(
                this.pdfArea.getPdfObject().getPdfAbsolutePath()
            );
            PDDocument pdfDocument = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(pdfDocument);
            pdfImage = renderer.renderImage(
                0,
                requiredZoom);
            pdfDocument.close();
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }

        return pdfImage;
    }
}
