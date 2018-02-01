package factories;

import model.PdfObject;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;

public abstract class PdfRenderFactory {


    public static BufferedImage renderPdfFromPdfObject(PdfObject pdfObject)
    {
        return renderPdf(pdfObject, (float) 1.0);
    }

    public static BufferedImage renderPdfFromPdfObject(PdfObject pdfObject, float zoomLevel)
    {
        return renderPdf(pdfObject, zoomLevel);
    }









    private static BufferedImage renderPdf(
        PdfObject pdfObject,
        float zoomLevel
    )
    {
        BufferedImage pdfImage = null;

        try {
            File pdfFile = new File(pdfObject.getPdfAbsolutePath());
            PDDocument pdfDocument = PDDocument.load(
                pdfFile,
                MemoryUsageSetting.setupMainMemoryOnly());
            PDFRenderer renderer = new PDFRenderer(pdfDocument);
            pdfImage = renderer.renderImage(0, zoomLevel);
            pdfDocument.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pdfImage;
    }
}
