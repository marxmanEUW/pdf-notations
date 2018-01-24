package timer;

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
        double zoomPercentage = this.getZoomLevelAsPercentage();
        this.pdfAreaMouseWheel.getPdfArea().resizePdf(zoomPercentage);

        this.pdfAreaMouseWheel.resetMouseRollCount();
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    private double getZoomLevelAsPercentage()
    {
        double zoomLevel;

        if (this.mouseScrollCount > this.MINIMAL_POSITIVE_SCROLL_COUNT)
        {
            zoomLevel = this.getAbsoluteZoomValue()
                / this.TOTAL_PERCENTAGE;
        }
        else if (this.mouseScrollCount < this.MAXIMAL_NEGATIVE_SCROLL_COUNT)
        {
            zoomLevel = (this.getAbsoluteZoomValue() * (-1))
                / this.TOTAL_PERCENTAGE;
        }
        else
        {
            // ScrollCount unterschreitet Mindestwertgrenzen
            // => keinen Zoom ausfuehren
            zoomLevel = 0.0;
        }

        return zoomLevel;
    }


    private double getAbsoluteZoomValue()
    {
        double zoomLevel;

        int residualValue = this.getResidualValueOfScrollCount();
        if (Math.abs(residualValue) < this.RESIDUAL_VALUE_ROUNDING_BORDER)
        {
            zoomLevel = this.getAbsoluteZoomValueRoundedDown(residualValue);
        }
        else
        {
            zoomLevel = this.getAbsoluteZoomValueRoundedUp(residualValue);
        }

        return zoomLevel;
    }

    private int getResidualValueOfScrollCount()
    {
        return this.mouseScrollCount % this.ZOOM_STEP_PERCENTAGE;
    }

    private double getAbsoluteZoomValueRoundedUp(int residualValue)
    {
        return
            Math.abs((double) this.mouseScrollCount)
            - Math.abs((double) residualValue)
            + (double) this.ZOOM_STEP_PERCENTAGE;
    }

    private double getAbsoluteZoomValueRoundedDown(int residualValue)
    {
        return
            Math.abs((double) this.mouseScrollCount)
            - Math.abs((double) residualValue);
    }
}
