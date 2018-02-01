package factories;

import java.awt.image.BufferedImage;

public class PdfZoomFactory {

    public static final double MINIMUM_ZOOM = 0.5;
    public static final double MAXIMUM_ZOOM = 1.5;
    public static final double ZOOM_STEP_IN = 0.1;
    public static final double ZOOM_STEP_OUT = -0.1;

    public final double TOTAL_PERCENTAGE = 100.0;
    public final int MINIMAL_POSITIVE_SCROLL_COUNT = 5;
    public final int MAXIMAL_NEGATIVE_SCROLL_COUNT = -5;
    public final int ZOOM_STEP_PERCENTAGE = 10;
    public final int RESIDUAL_VALUE_ROUNDING_BORDER
        = (int) Math.ceil((double) this.ZOOM_STEP_PERCENTAGE / 2.0);


    /*
     * @author  yxyxD
     * @todo   Logik aus MouseWheelMovementTimer auslagern
     */
    public static double getZoomChangeForMouseScroll(int mouseScrollCount)
    {
        return 0.0;
    }

    /*
     * @author  yxyxD
     * @todo   Logik aus PdfArea auslagern
     */
    public static BufferedImage getZoomedImage(double zoomCange)
    {
        return null;
    }
}
