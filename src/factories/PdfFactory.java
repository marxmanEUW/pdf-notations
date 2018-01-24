package factories;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;

/*
 * @todo diese Klasse zur PdfObjectFactory machen
 * @todo Rendering-Vorgang in einem eigenen Thread (parallel)
 */
public abstract class PdfFactory {

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

    public static BufferedImage renderPdfWithZoom(String sourcePath, float zoomLevel)
    {
        BufferedImage pdfImage = null;

        try {
            File pdfFile = new File(sourcePath);
            PDDocument pdfDocument = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(pdfDocument);
            pdfImage = renderer.renderImage(0, zoomLevel);
            pdfDocument.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pdfImage;
    }
}
