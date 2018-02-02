package timer;

import factories.PdfZoomFactory;
import listeners.PdfAreaMouseWheel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseWheelMovementTimer implements ActionListener {

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
