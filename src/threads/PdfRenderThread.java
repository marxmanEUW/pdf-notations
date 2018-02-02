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


    public PdfRenderThread(PdfArea pdfArea)
    {
        this.pdfArea = pdfArea;
        this.requiredZoom = (float) pdfArea.getZoomLevel();

        PdfRenderThread.PDF_RENDER_GROUP.interrupt();

        Thread thread = new Thread(PdfRenderThread.PDF_RENDER_GROUP,this);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    @Override
    public void run()
    {
        if (PdfRenderThread.PDF_RENDER_GROUP.activeCount() >= 5)
        {
            this.pdfArea.disableZoom();
        }


        this.pdfImage = this.renderPdfImage();

        if (this.requiredZoom == (float) this.pdfArea.getZoomLevel())
        {
            this.pdfArea.reRenderPdf();
        }


        this.pdfArea.enableZoom();
    }

    public BufferedImage getRenderedPdfImage()
    {
        return this.pdfImage;
    }


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
