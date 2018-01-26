package factories;

import model.PdfObject;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;

public abstract class PdfObjectFactory {

    public static PdfObject createAndReturnPdfObject(String pathToPdf)
    {
        return new PdfObject(pathToPdf);
    }


    public static BufferedImage renderPdfFromPdfObject(
        PdfObject pdfObject
    )
    {
        return renderPdf(pdfObject, (float) 1.0);
    }

    public static BufferedImage renderPdfFromPdfObject(
        PdfObject pdfObject,
        float zoomLevel
    )
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
            File pdfFile = new File(pdfObject.getSourcePath());
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
