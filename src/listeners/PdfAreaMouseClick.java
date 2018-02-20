package listeners;

import model.Notation;
import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;
import view.projectView.pdfObjectView.partials.PdfArea;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PdfAreaMouseClick extends MouseAdapter {

    private PdfObjectView pdfObjectView;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Constructs the MouseClick-Adapter for the PdfArea.
     */
    public PdfAreaMouseClick()
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
     * @brief   Initializes the MouseClick-Adapter.
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;
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
     * @brief   Method called every time a mouse button has been clicked.
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        Point coordinates = this.getPdfArea().getActualCoordinatesOfPoint(
            mouseEvent.getPoint()
        );


        if(this.getPdfArea().getAddingNotation()
            && !this.getPdfArea().isNotationInRangeOfOtherNotation(mouseEvent.getPoint()))
        {
            this.getPdfObject().addNewNotation(coordinates);
            this.getPdfArea().setCursorTypeToDefault();
            this.getPdfArea().setAddingNotation(false);
            this.getPdfArea().repaint();
            this.pdfObjectView.getNotationListScrollPane().updateTable();
        }


        Notation notation = this.getPdfArea().getClickedNotation(mouseEvent.getPoint());
        if (notation != null) {
            int selectedNotationId = notation.getId();
            this.pdfObjectView.getNotationListScrollPane().setSelectedRow(selectedNotationId);
            this.getPdfObject().setSelectedNotationIndex(selectedNotationId);
            this.getPdfArea().repaint();
        }
        else
        {
            this.pdfObjectView.getNotationListScrollPane().unselectRow();
        }
    }


    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Method called every time a mouse button has been pressed.
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {
        //System.out.println("Mouse pressed");
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Method called every time a mouse button has been released.
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        //System.out.println("Mouse released");
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Method called every time the mouse has entered the PdfArea.
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {
        //System.out.println("Mouse entered");
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Method called every time the mouse has left the PdfArea.
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {
        //System.out.println("Mouse exited");
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
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
