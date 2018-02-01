package threads;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import view.projectView.pdfObjectView.partials.PdfArea;

import java.awt.image.BufferedImage;
import java.io.File;

public class PdfRenderThread implements Runnable {

    private Thread thread;

    private PdfArea pdfArea;
    private float requiredZoom;

    private BufferedImage pdfImage;


    public PdfRenderThread(PdfArea pdfArea)
    {
        this.pdfArea = pdfArea;
        this.requiredZoom = (float) pdfArea.getZoomLevel();

        this.thread = new Thread(this);
        this.thread.setPriority(Thread.MAX_PRIORITY);
        this.thread.start();
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println("Thread start");

            File pdfFile = new File(
                this.pdfArea.getPdfObject().getPdfAbsolutePath()
            );
            PDDocument pdfDocument = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(pdfDocument);
            this.pdfImage = renderer.renderImage(
                0,
                requiredZoom);
            pdfDocument.close();

            if (this.requiredZoom == (float) this.pdfArea.getZoomLevel())
            {
                this.pdfArea.reRenderPdf();
            }

            System.out.println("Thread done");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public BufferedImage getPdfImage()
    {
        return this.pdfImage;
    }
}
