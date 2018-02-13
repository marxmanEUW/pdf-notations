package factories;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class PdfZoomFactory {

    //@todo own class for zoom constants
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
     * #########################################################################
     * #                    Public Methods                                     #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Converts the scroll count of a MouseWheelMoved-Event into a
     *          equivalent zoom percentage.
     */
    public static double getPercentageZoomChangeForMouseScroll(
        int mouseScrollCount
    )
    {
        double zoomPercentage;

        int realScrollCount = getInvertedMouseScrollCount(mouseScrollCount);

        if (realScrollCount > MINIMAL_POSITIVE_SCROLL_COUNT)
        {
            zoomPercentage = getAbsoluteZoomValue(realScrollCount)
                / TOTAL_PERCENTAGE;
        }
        else if (realScrollCount < MAXIMAL_NEGATIVE_SCROLL_COUNT)
        {
            zoomPercentage = (getAbsoluteZoomValue(realScrollCount) * (-1))
                / TOTAL_PERCENTAGE;
        }
        else
        {
            // no relevant scroll happened, so there will be no zoom
            zoomPercentage = 0.0;
        }

        return zoomPercentage;
    }

    /*
     * @author  yxyxD
     * @todo    besser: die pdfArea direkt übergeben
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Scales the current pdfImage of the PdfArea according to the
     *          zoom change.
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



    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Converts to MouseScrollCount into the actual scroll count, since
     *          the MouseScrollCount of the MouseScrollEvent is inverted.
     */
    private static int getInvertedMouseScrollCount(int mouseScrollCount)
    {
        return (mouseScrollCount * (-1));
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Calculates and returns the zoom change as absolute value.
     */
    private static double getAbsoluteZoomValue(int mouseScrollCount)
    {
        double zoomLevel;

        int residualValue = mouseScrollCount % ZOOM_STEP_PERCENTAGE;
        if (Math.abs(residualValue) <= RESIDUAL_VALUE_ROUNDING_BORDER)
        {
            // round down
            zoomLevel =
                Math.abs((double) mouseScrollCount)
                - Math.abs((double) residualValue);
        }
        else
        {
            // round up
            zoomLevel =
                Math.abs((double) mouseScrollCount)
                - Math.abs((double) residualValue)
                + (double) ZOOM_STEP_PERCENTAGE;
        }

        return zoomLevel;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Creates and returns the scaled image for the current pdfImage.
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Creates and returns an AffineTransformOperation-Object which
     *          scales the pdfImage.
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
