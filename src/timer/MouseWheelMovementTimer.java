package timer;

import factories.PdfZoomFactory;
import listeners.PdfAreaMouseWheel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseWheelMovementTimer implements ActionListener {

    private final double TOTAL_PERCENTAGE = 100.0;

    private final int MINIMAL_POSITIVE_SCROLL_COUNT = 5;
    private final int MAXIMAL_NEGATIVE_SCROLL_COUNT = -5;
    private final int ZOOM_STEP_PERCENTAGE = 10;
    private final int RESIDUAL_VALUE_ROUNDING_BORDER
        = (int) Math.ceil((double) this.ZOOM_STEP_PERCENTAGE / 2.0);

    private PdfAreaMouseWheel pdfAreaMouseWheel;

    private int mouseScrollCount;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public MouseWheelMovementTimer(PdfAreaMouseWheel pdfAreaMouseWheel)
    {
        this.pdfAreaMouseWheel = pdfAreaMouseWheel;
        this.mouseScrollCount = this.pdfAreaMouseWheel.getMouseScrollCount();
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        double zoomPercentage =
            PdfZoomFactory.getPercentageZoomChangeForMouseScroll(
                this.mouseScrollCount
            );

        this.pdfAreaMouseWheel.getPdfArea().resizePdf(zoomPercentage);

        this.pdfAreaMouseWheel.resetMouseRollCount();
    }
}
