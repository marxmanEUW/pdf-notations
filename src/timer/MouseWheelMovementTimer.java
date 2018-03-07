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
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Constructs a new MouseWheelMovement-Timer
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
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Method called every time the time limit of the timer has been
     *          reached.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        double zoomPercentage =
            PdfZoomFactory.getPercentageZoomChangeForMouseScroll(
                this.mouseScrollCount
            );

        this.pdfAreaMouseWheel.getPdfArea().zoomPdf(zoomPercentage);

        this.pdfAreaMouseWheel.resetMouseRollCount();
    }

}
