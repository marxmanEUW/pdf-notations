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
        if (this.getPdfObject() == null) { return; }

        Point coordinates = this.getPdfArea().getActualCoordinatesOfPoint(
            mouseEvent.getPoint()
        );

        if(this.getPdfArea().getAddingNotation()
            && !this.getPdfArea().isNotationInRangeOfOtherNotation(
                mouseEvent.getPoint())
            )
        {
            // @ todo move to external dialog
            Notation emptyNotation = NotationFactory.getEmptyNotation(this.getPdfObject().getListOfEntityNamesAndTypes());
            emptyNotation.setValue(0, this.getPdfObject().getIdForNextNotation());
            emptyNotation.setValue(1, coordinates.x);
            emptyNotation.setValue(2, coordinates.y);
            emptyNotation.setValue(3, Notation.STANDARD_NAME);
            emptyNotation.setValue(4, Notation.STANDARD_DESCRIPTION);
            this.getPdfObject().addNotation(emptyNotation);

            this.getPdfArea().setCursorTypeToDefault();
            this.getPdfArea().setAddingNotation(false);
            this.getPdfArea().repaint();
            this.pdfObjectView.getNotationListScrollPane().updateTable();
        }

        Notation notation = this.getPdfArea().getClickedNotation(
            mouseEvent.getPoint()
        );
        if (notation != null) {
            int selectedNotationId = notation.getId();
            this.pdfObjectView.getNotationListScrollPane()
                .setSelectedRow(selectedNotationId);
            this.getPdfObject().setSelectedNotationId(selectedNotationId);
            this.getPdfArea().repaint();
        }
        else
        {
            this.pdfObjectView.getNotationListScrollPane().deselectRow();
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
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfObject of the PdfObjectView.
     */
    private PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfArea.
     */
    private PdfArea getPdfArea()
    {
        return this.pdfObjectView.getPdfArea();
    }
}
