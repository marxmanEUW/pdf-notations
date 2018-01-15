package handlers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;

public abstract class PdfHandler {

    /*
     * @todo try-catch entfernen und stattdessen Exception werfen
     */
    public static BufferedImage renderPdfAsImage(String sourcePath)
    {
        BufferedImage pdfImage = null;

        try {
            File pdfFile = new File(sourcePath);
            PDDocument pdfDocument = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(pdfDocument);
            pdfImage = renderer.renderImage(0);
            pdfDocument.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pdfImage;
    }


    public static void getPdfDocument(String sourcePath)
    {
        try {
            File pdfFile = new File(sourcePath);
            PDDocument pdfDocument = PDDocument.load(pdfFile);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
