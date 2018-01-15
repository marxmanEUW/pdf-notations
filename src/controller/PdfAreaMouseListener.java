package controller;

import gui.MainFrame;
import gui.partials.PdfArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class PdfAreaMouseListener extends MouseAdapter {

    private PdfArea pdfArea;


    public PdfAreaMouseListener(PdfArea pdfArea)
    {
        this.pdfArea = pdfArea;
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

        //System.out.println("Scroll Amount:   " + Integer.toString(mouseWheelEvent.getScrollAmount()));
        //System.out.println("Scroll Type:     " + Integer.toString(mouseWheelEvent.getScrollType()));
        //System.out.println("Units to Scroll: " + Integer.toString(mouseWheelEvent.getUnitsToScroll()));
        //System.out.println("Wheel Rotation:  " + Integer.toString(mouseWheelEvent.getWheelRotation()));
        //System.out.println("-------------------------------------");

        double zoomChange = ((double) mouseWheelEvent.getWheelRotation()) / (-10.0);

        this.pdfArea.resizePdf(zoomChange);
    }
}
