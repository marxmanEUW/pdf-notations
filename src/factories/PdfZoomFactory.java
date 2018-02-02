package factories;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class PdfZoomFactory {

    public static final double MINIMUM_ZOOM = 0.5;
    public static final double MAXIMUM_ZOOM = 1.5;
    public static final double ZOOM_STEP_IN = 0.1;
    public static final double ZOOM_STEP_OUT = -0.1;

    public static final double TOTAL_PERCENTAGE = 100.0;
    public static final int MINIMAL_POSITIVE_SCROLL_COUNT = 5;
    public static final int MAXIMAL_NEGATIVE_SCROLL_COUNT = -5;
    public static final int ZOOM_STEP_PERCENTAGE = 10;
    public static final int RESIDUAL_VALUE_ROUNDING_BORDER
        = (int) Math.ceil((double) ZOOM_STEP_PERCENTAGE / 2.0);


    /*
     * @author  yxyxD
     */
    public static double getPercentageZoomChangeForMouseScroll(
        int mouseScrollCount
    )
    {
        double zoomLevel;

        if (mouseScrollCount > MINIMAL_POSITIVE_SCROLL_COUNT)
        {
            zoomLevel = getAbsoluteZoomValue(mouseScrollCount)
                / TOTAL_PERCENTAGE;
        }
        else if (mouseScrollCount < MAXIMAL_NEGATIVE_SCROLL_COUNT)
        {
            zoomLevel = (getAbsoluteZoomValue(mouseScrollCount) * (-1))
                / TOTAL_PERCENTAGE;
        }
        else
        {
            // ScrollCount unterschreitet Mindestwertgrenzen
            // => keinen Zoom ausfuehren
            zoomLevel = 0.0;
        }

        return zoomLevel;
    }

    /*
     * @author  yxyxD
     * @todo    besser: die pdfArea direkt übergeben
     */
    public static BufferedImage getZoomedImage(
        int initialImageWidth,
        int initialImageHeight,
        BufferedImage oldPdfImage,
        double zoomChange
    )
    {
        BufferedImage scaledPdfImage = getScaledPdfImage(
            initialImageWidth,
            initialImageHeight,
            oldPdfImage,
            zoomChange
        );

        AffineTransformOp transformOp = getAffineTransformOp(
            oldPdfImage,
            scaledPdfImage
        );

        return transformOp.filter(oldPdfImage, scaledPdfImage);
    }



    //------------------------------------------------

    /*
     * @author  yxyxD
     */
    private static double getAbsoluteZoomValue(int mouseScrollCount)
    {
        double zoomLevel;

        int residualValue = getResidualValueOfScrollCount(mouseScrollCount);
        if (Math.abs(residualValue) < RESIDUAL_VALUE_ROUNDING_BORDER)
        {
            zoomLevel = getAbsoluteZoomValueRoundedDown(
                mouseScrollCount,
                residualValue
            );
        }
        else
        {
            zoomLevel = getAbsoluteZoomValueRoundedUp(
                mouseScrollCount,
                residualValue);
        }

        return zoomLevel;
    }

    /*
     * @author  yxyxD
     */
    private static int getResidualValueOfScrollCount(int mouseScrollCount)
    {
        return mouseScrollCount % ZOOM_STEP_PERCENTAGE;
    }

    /*
     * @author  yxyxD
     */
    private static double getAbsoluteZoomValueRoundedUp(
        int mouseScrollCount,
        int residualValue
    )
    {
        return
            Math.abs((double) mouseScrollCount)
                - Math.abs((double) residualValue)
                + (double) ZOOM_STEP_PERCENTAGE;
    }

    /*
     * @author  yxyxD
     */
    private static double getAbsoluteZoomValueRoundedDown(
        int mouseScrollCount,
        int residualValue
    )
    {
        return
            Math.abs((double) mouseScrollCount)
                - Math.abs((double) residualValue);
    }


    //--------------------------------------------------------------

    /*
     * @author  yxyxD
     */
    private static BufferedImage getScaledPdfImage(
        int initialImageWidth,
        int initialImageHeight,
        BufferedImage oldPdfImage,
        double zoomChange
    )
    {
        double scaledImageWidth = (double) oldPdfImage.getWidth()
            + ((double) initialImageWidth * zoomChange);
        double scaledImageHeight = (double) oldPdfImage.getHeight()
            + ((double) initialImageHeight * zoomChange);

        return new BufferedImage(
            (int) scaledImageWidth,
            (int) scaledImageHeight,
            BufferedImage.TYPE_INT_ARGB
        );
    }

    /*
     * @author  yxyxD
     */
    private static AffineTransformOp getAffineTransformOp(
        BufferedImage oldPdfImage,
        BufferedImage scaledPdfImage
    )
    {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.scale(
            ((double) scaledPdfImage.getWidth()
                / (double) oldPdfImage.getWidth()),
            ((double) scaledPdfImage.getHeight()
                / (double) oldPdfImage.getHeight())
        );

        return new AffineTransformOp(
            affineTransform,
            AffineTransformOp.TYPE_BILINEAR //@todo noch gucken
        );
    }
}
