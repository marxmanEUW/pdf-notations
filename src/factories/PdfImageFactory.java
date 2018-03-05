package factories;

import constants.Environment;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.PdfObject;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class PdfImageFactory {

    public static Image getPdfImageForPdfObject(PdfObject pdfObject)
    {

        BufferedImage tempImage;
        try
        {
            File pdfFile = new File(
                pdfObject.getPdfAbsolutePath()
            );
            PDDocument pdfDocument = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(pdfDocument);
            tempImage = renderer.renderImageWithDPI(
                0,
                Environment.PDF_IMAGE_DPI);
            pdfDocument.close();
        }
        catch (IOException ioException)
        {
            tempImage = null;
            ioException.printStackTrace();
        }
        Image pdfImage = SwingFXUtils.toFXImage(tempImage, null);

        return pdfImage;
    }
}
