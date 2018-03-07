package listeners;

import constants.Environment;
import timer.MouseWheelMovementTimer;
import view.projectView.pdfObjectView.PdfObjectView;
import view.projectView.pdfObjectView.partials.PdfArea;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

public class PdfAreaMouseWheel extends MouseAdapter {

    private PdfArea pdfArea;

    private Timer mouseWheelMovementTimer;

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
     * @brief   Constructs the MouseWheel-Adapter for the PdfArea.
     */
    public PdfAreaMouseWheel()
    {
    }


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Initializes the MouseWheel-Adapter.
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfArea = pdfObjectView.getPdfArea();
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the scroll count selected by the MouseWheelMoved-Event.
     */
    public int getMouseScrollCount()
    {
        return this.mouseScrollCount;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the PdfArea the MouseWheel-Adapter is listening to.
     */
    public PdfArea getPdfArea()
    {
        return this.pdfArea;
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
     * @brief   Method called every time the mouse wheel has been moved.
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent)
    {
        if (this.pdfArea.isZoomDisabled()) { return; }
        if (Environment.PDF_RENDER_GROUP.activeCount() >=
            Environment.MAX_RENDER_THREADS) { return; }
        if (this.pdfArea.getPdfObject() == null) { return; }

        if (mouseWheelEvent.isControlDown())
        {
            int wheelRotation = mouseWheelEvent.getWheelRotation();

            this.stopExistingTimerAndIncreaseCounter(wheelRotation);
            this.createNewTimer();
        }
        else
        {
            this.pdfArea
                .getPdfObjectView()
                    .getPdfScrollPane()
                        .dispatchEvent(mouseWheelEvent);
        }
    }


    /*
     * #########################################################################
     * #                    Public Methods                                     #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Resets the count of selected mouse scrolls.
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Stops the MouseWheelMovementTimer (if there is one up and
     *          running) an adds the new wheel rotation to the count of selected
     *          mouse scrolls.
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Creates a new MouseWheelMovementTimer, that waits for future
     *          mouse scrolls until a certain time limit has been reached.
     */
    private void createNewTimer()
    {
        this.mouseWheelMovementTimer = new Timer(
            Environment.TIMER_DELAY,
            new MouseWheelMovementTimer(this)
        );
        this.mouseWheelMovementTimer.setRepeats(false);
        this.mouseWheelMovementTimer.start();
    }

}
