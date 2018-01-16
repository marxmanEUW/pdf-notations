package controller;

import gui.partials.PdfArea;

import javax.swing.*;
import java.awt.event.*;


public class PdfAreaMouseListener extends MouseAdapter {

    private final int TIMER_DELAY = 100;
    private Timer mouseWheelMovementTimer;
    private PdfArea pdfArea;
    private int mouseScrollCount;


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
        if (this.mouseScrollCount == 0) {
            this.increaseMouseRollCount(mouseWheelEvent.getWheelRotation());
        }
    }


    public int getMouseScrollCount()
    {
        return mouseScrollCount;
    }

    public PdfArea getPdfArea()
    {
        return pdfArea;
    }

    public void resetMouseRollCount()
    {
        this.mouseScrollCount = 0;
    }

    private void increaseMouseRollCount(int wheelRotation)
    {
        this.mouseScrollCount += (wheelRotation * (-1));
    }



    private class MouseWheelMovementTimerActionListener implements ActionListener {

        private PdfAreaMouseListener pdfAreaMouseListener;
        private int mouseScrollCount;

        public MouseWheelMovementTimerActionListener(PdfAreaMouseListener pdfAreaMouseListener)
        {
            this.pdfAreaMouseListener = pdfAreaMouseListener;
            this.mouseScrollCount = this.pdfAreaMouseListener.getMouseScrollCount();
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            double zoomPercentage = this.getZoomLevelAsPercentage();
            this.pdfAreaMouseListener.getPdfArea().resizePdf(zoomPercentage);

            this.pdfAreaMouseListener.resetMouseRollCount();
        }

        private double getZoomLevelAsPercentage()
        {
            double zoomLevel;

            if (this.mouseScrollCount > 5) {
                // ScrollCount groeszer 5 => positiven Zoom berechnen
                zoomLevel = this.getPositiveZoom();
            }
            else if (this.mouseScrollCount < -5) {
                // ScrollCount kleiner -5 => negativen Zoom berechnen
                zoomLevel = this.getNegativeZoom();
            }
            else {
                // ScrollCount zwischen -5 und 5  => wird ignoriert
                zoomLevel = 0.0;
            }

            return zoomLevel;
        }

        private double getPositiveZoom()
        {
            double zoomLevel;

            int lowestDigit = this.mouseScrollCount % 10;
            if (lowestDigit < 5) {
                // ist Einterstelle kleiner 5 => auf  vollen 10er abrunden
                zoomLevel = ((double) mouseScrollCount - (double) lowestDigit) / 100.0;
            }
            else {
                // ist Einterstelle groeszer 5 => auf vollen 10er aufrunden
                zoomLevel = ((double) mouseScrollCount + 10.0 - (double) lowestDigit) / 100.0;
            }

            return zoomLevel;
        }

        private double getNegativeZoom()
        {
            double zoomLevel;

            int lowestDigit = this.mouseScrollCount % 10;
            if (lowestDigit > -5) {
                // ist Einterstelle kleiner 5 => auf  vollen 10er abrunden
                zoomLevel = ((double) mouseScrollCount - (double) lowestDigit) / 100.0;
            }
            else {
                // ist Einterstelle groeszer 5 => auf vollen 10er aufrunden
                zoomLevel = ((double) mouseScrollCount - 10.0 - (double) lowestDigit) / 100.0;
            }

            return zoomLevel;
        }
    }
}


