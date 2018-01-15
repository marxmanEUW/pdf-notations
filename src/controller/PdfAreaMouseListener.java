package controller;

import gui.partials.PdfArea;

import javax.swing.*;
import java.awt.event.*;


public class PdfAreaMouseListener extends MouseAdapter {

    private final int TIMER_DELAY = 100;
    private Timer mouseWheelMovementTimer;
    private PdfArea pdfArea;
    private int mouseRollCount;


    public PdfAreaMouseListener(PdfArea pdfArea)
    {
        this.pdfArea = pdfArea;
        this.resetMouseRollCount();
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        //super.mouseClicked(mouseEvent);

        int x = mouseEvent.getX();
        int y = mouseEvent.getY();

        System.out.println("x: " + Integer.toString(x));
        System.out.println("y: " + Integer.toString(y));
        System.out.println("--------------------------");
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent)
    {
        //super.mouseWheelMoved(mouseWheelEvent);

        //double zoomChange = ((double) mouseWheelEvent.getWheelRotation()) / (-10.0);
        //System.out.println(zoomChange);
        //this.pdfArea.resizePdf(zoomChange);


        // stopt bisherigen Timer, wenn er noch laeuft
        // => dazu muss Mausrad innerhalb von 100ms nochmals gedreht werden
        if (mouseWheelMovementTimer != null && mouseWheelMovementTimer.isRunning()) {

            this.increaseMouseRollCount(mouseWheelEvent.getWheelRotation());
            mouseWheelMovementTimer.stop();
        }


        // neuen Timer fuer 100ms erstellen
        //
        mouseWheelMovementTimer = new Timer(
            this.TIMER_DELAY,
            new MouseWheelMovementTimerActionListener(this)
        );
        mouseWheelMovementTimer.setRepeats(false);
        mouseWheelMovementTimer.start();

        // ersten Mouse-Roll nicht verpassen
        if (this.mouseRollCount == 0) {
            this.increaseMouseRollCount(mouseWheelEvent.getWheelRotation());
        }
    }


    public int getMouseRollCount()
    {
        return mouseRollCount;
    }

    public PdfArea getPdfArea()
    {
        return pdfArea;
    }

    public void resetMouseRollCount()
    {
        this.mouseRollCount = 0;
    }

    private void increaseMouseRollCount(int wheelRotation)
    {
        this.mouseRollCount += (wheelRotation * (-1));
    }



    private class MouseWheelMovementTimerActionListener implements ActionListener {

        private PdfAreaMouseListener pdfAreaMouseListener;

        public MouseWheelMovementTimerActionListener(PdfAreaMouseListener pdfAreaMouseListener)
        {
            this.pdfAreaMouseListener = pdfAreaMouseListener;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            System.out.println(Integer.toString(this.pdfAreaMouseListener.getMouseRollCount()));
            System.out.println("----------------------------");

            this.pdfAreaMouseListener.resetMouseRollCount();
        }
    }
}


