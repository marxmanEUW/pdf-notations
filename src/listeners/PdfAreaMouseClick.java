package listeners;

import factories.NotationFactory;
import model.Notation;
import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;
import view.projectView.pdfObjectView.partials.PdfArea;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PdfAreaMouseClick extends MouseAdapter {

    private PdfObjectView pdfObjectView;

    public PdfAreaMouseClick()
    {

    }

    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        Point coordinates = this.getPdfArea().getActualCoordinatesOfPoint(
            mouseEvent.getPoint()
        );


        if(this.getPdfArea().getAddingNotation()
            && !this.getPdfArea().isNotationInRange(mouseEvent.getPoint()))
        {
            // @ todo move to external dialog
            Notation emptyNotation = NotationFactory.getEmptyNotation(this.getPdfObject().getListOfEntityNamesAndTypes());
            emptyNotation.setValue(0, this.getPdfObject().getIdForNextNotation());
            emptyNotation.setValue(1, Notation.STANDARD_NAME);
            emptyNotation.setValue(2, coordinates.x);
            emptyNotation.setValue(3, coordinates.y);
            emptyNotation.setValue(4, Notation.STANDARD_DESCRIPTION);
            this.getPdfObject().addNotation(emptyNotation);

            this.getPdfArea().setCursorTypeToDefault();
            this.getPdfArea().setAddingNotation(false);
            this.getPdfArea().repaint();
            this.pdfObjectView.getNotationListScrollPane().updateTable();
        }


        Notation notation = this.getPdfArea().getClickedNotation(mouseEvent.getPoint());
        if (notation != null) {
            int selectedNotationId = (int) notation.getValue(0);
            //System.out.println(selectedNotationId);
            this.pdfObjectView.getNotationListScrollPane().setSelectedRow(selectedNotationId);
            this.getPdfObject().setSelectedNotationIndex(selectedNotationId);
            this.getPdfArea().repaint();
        }
        else
        {
            this.pdfObjectView.getNotationListScrollPane().unselectRow();
        }
    }


    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {
        //System.out.println("Mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        //System.out.println("Mouse released");
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {
        //System.out.println("Mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {
        //System.out.println("Mouse exited");
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethode                               #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    private PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }

    /*
     * @author  marxmanEUW
     */
    private PdfArea getPdfArea()
    {
        return this.pdfObjectView.getPdfArea();
    }
}
