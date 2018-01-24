package listeners;

import model.PdfObject;
import view.project_view.pdfobject_view.PdfObjectView;
import view.project_view.pdfobject_view.partials.PdfArea;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PdfAreaMouseClick extends MouseAdapter {

    private PdfObjectView pdfObjectView;
    private PdfObject pdfObject;

    private PdfArea pdfArea;

    public PdfAreaMouseClick()
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
     * #                    Overrides                                          #
     * #########################################################################
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        int x = (int) ((double) mouseEvent.getX() / this.pdfArea.getZoomLevel());
        int y = (int) ((double) mouseEvent.getY() / this.pdfArea.getZoomLevel());

        System.out.println("x: " + Integer.toString(x));
        System.out.println("y: " + Integer.toString(y));
        System.out.println("--------------------------");

        this.pdfObject.addNotationAtXY(x, y);
        this.pdfArea.repaint();
    }


    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {
        System.out.println("Mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        System.out.println("Mouse released");
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {
        System.out.println("Mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {
        System.out.println("Mouse exited");
    }
}
