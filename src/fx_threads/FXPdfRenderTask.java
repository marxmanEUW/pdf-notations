package fx_threads;

import constants.Environment;
import fx_view.projectView.pdfObjectView.partials.FXPdfArea;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FXPdfRenderTask extends Task<String> {

    private FXPdfArea pdfArea;
    private Image renderedPdfImage;


    /*
     * #########################################################################
     * #                    Constructors                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public FXPdfRenderTask(FXPdfArea pdfArea)
    {
        this.pdfArea = pdfArea;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */

    public Image getRenderedPdfImage()
    {
        return this.renderedPdfImage;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    @Override
    protected String call()
    {
        this.renderPdfImage();
        return null;
    }

    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    private void renderPdfImage()
    {
        BufferedImage tempImage;
        PDDocument pdfDocument = null;
        try
        {
            File pdfFile = new File(
                this.pdfArea.getPdfObject().getPdfAbsolutePath()
            );
            pdfDocument = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(pdfDocument);
            tempImage = renderer.renderImageWithDPI(
                0,
                Environment.PDF_IMAGE_DPI);
            pdfDocument.close();
        }
        catch (Exception exception)
        {
            tempImage = null;
            exception.printStackTrace();
            // @todo mabe to much output
            System.out.println(exception);
        }
        finally {
            if (pdfDocument != null)
            {
                try {
                    pdfDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        this.renderedPdfImage = SwingFXUtils.toFXImage(tempImage, null);
    }
}
