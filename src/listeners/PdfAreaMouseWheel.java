package listeners;

import model.PdfObject;
import timer.MouseWheelMovementTimer;
import view.projectView.pdfObjectView.PdfObjectView;
import view.projectView.pdfObjectView.partials.PdfArea;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

public class PdfAreaMouseWheel extends MouseAdapter {

    private final int TIMER_DELAY = 100;

    private PdfObjectView pdfObjectView;
    private PdfArea pdfArea;

    private Timer mouseWheelMovementTimer;

    private int mouseScrollCount;


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;
        this.pdfArea = this.pdfObjectView.getPdfArea();
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public int getMouseScrollCount()
    {
        return mouseScrollCount;
    }

    /*
     * @author  yxyxD
     */
    public PdfArea getPdfArea()
    {
        return pdfArea;
    }

    /*
     * @author  marxmanEUW
     */
    private PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent)
    {
        if (!this.pdfArea.isZoomEnabled())
        {
            return;
        }

        int wheelRotation = mouseWheelEvent.getWheelRotation();

        this.stopExistingTimerAndIncreaseCounter(wheelRotation);
        this.createNewTimer();
    }


    /*
     * #########################################################################
     * #                    Public Methods                                     #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void resetMouseRollCount()
    {
        this.mouseScrollCount = 0;
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    private void increaseMouseRollCount(int wheelRotation)
    {
        this.mouseScrollCount += (wheelRotation * (-1));
    }

    /*
     * @author  yxyxD
     */
    private void stopExistingTimerAndIncreaseCounter(int wheelRotation)
    {
        // stops the timer if one exists that is still running
        // and increases the wheel movement counter
        if (this.mouseWheelMovementTimer != null
            && this.mouseWheelMovementTimer.isRunning())
        {
            this.mouseScrollCount += wheelRotation;
            this.mouseWheelMovementTimer.stop();
        }
    }

    /*
     * @author  yxyxD
     */
    private void createNewTimer()
    {
        this.mouseWheelMovementTimer = new Timer(
            this.TIMER_DELAY,
            new MouseWheelMovementTimer(this)
        );
        this.mouseWheelMovementTimer.setRepeats(false);
        this.mouseWheelMovementTimer.start();
    }

}
