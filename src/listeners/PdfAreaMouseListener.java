package listeners;

import gui.partials.PdfArea;
import model.Project;

import javax.swing.*;
import java.awt.event.*;


public class PdfAreaMouseListener extends MouseAdapter {

    private final int TIMER_DELAY = 100;

    private boolean isZoomEnabled;

    private PdfArea pdfArea;
    private Timer mouseWheelMovementTimer;
    private int mouseScrollCount;

    private Project project;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public PdfAreaMouseListener(PdfArea pdfArea, Project project)
    {
        this.pdfArea = pdfArea;
        this.resetMouseRollCount();
        this.enableZoom();

        this.project = project; //oder lieber this.pdfArea.project ??????
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

    public boolean isZoomEnabled()
    {
        return this.isZoomEnabled;
    }


    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */
    public void enableZoom()
    {
        this.isZoomEnabled = true;
    }

    public void disableZoom()
    {
        this.isZoomEnabled = false;
    }

    public void resetMouseRollCount()
    {
        this.mouseScrollCount = 0;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        //super.mouseClicked(mouseEvent);

        int x = mouseEvent.getX();
        int y = mouseEvent.getY();

        System.out.println("x: " + Integer.toString(x));
        System.out.println("y: " + Integer.toString(y));
        System.out.println("--------------------------");

        this.project.addNotationAtXY(x, y);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent)
    {
        if (!this.isZoomEnabled())
        {
            return;
        }

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
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    private void increaseMouseRollCount(int wheelRotation)
    {
        this.mouseScrollCount += (wheelRotation * (-1));
    }
}


