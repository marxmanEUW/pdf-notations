package listeners;

import model.PdfObject;
import view.project_view.pdfobject_view.PdfObjectView;
import view.project_view.pdfobject_view.partials.PdfArea;

import javax.swing.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class PdfAreaMouseWheel implements MouseWheelListener {

    private final int TIMER_DELAY = 100;

    private PdfObjectView pdfObjectView;
    private PdfObject pdfObject;
    private PdfArea pdfArea;

    private Timer mouseWheelMovementTimer;
    private int mouseScrollCount;


    public PdfAreaMouseWheel()
    {

    }


    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.pdfArea = this.pdfObjectView.getPdfArea();
        this.pdfObject = this.pdfObjectView.getPdfObject();
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public int getMouseScrollCount()
    {
        return mouseScrollCount;
    }

    public PdfArea getPdfArea()
    {
        return pdfArea;
    }


    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent)
    {
                /*
        if (!this.isZoomEnabled())
        {
            return;
        }
        */

        System.out.println("rolled");

        // stopt bisherigen Timer, wenn er noch laeuft
        // => dazu muss Mausrad innerhalb von 100ms nochmals gedreht werden
        if (this.mouseWheelMovementTimer != null
            && this.mouseWheelMovementTimer.isRunning())
        {
            this.increaseMouseRollCount(mouseWheelEvent.getWheelRotation());
            this.mouseWheelMovementTimer.stop();
        }


        // neuen Timer fuer 100ms erstellen
        //
        this.mouseWheelMovementTimer = new Timer(
            this.TIMER_DELAY,
            new MouseWheelMovementTimerActionListener(this)
        );
        this.mouseWheelMovementTimer.setRepeats(false);
        this.mouseWheelMovementTimer.start();

        // ersten Mouse-Roll nicht verpassen
        if (this.mouseScrollCount == 0)
        {
            this.increaseMouseRollCount(mouseWheelEvent.getWheelRotation());
        }
    }


    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */
    public void resetMouseRollCount()
    {
        this.mouseScrollCount = 0;
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    private void increaseMouseRollCount(int wheelRotation)
    {
        this.mouseScrollCount += (wheelRotation * (-1));
    }
}
