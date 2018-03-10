package fx_handler;

import constants.Environment;
import factories.NotationFactory;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import fx_view.projectView.pdfObjectView.partials.FXPdfArea;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import model.Notation;
import model.PdfObject;

public class FXPdfAreaMouseHandler implements EventHandler<MouseEvent> {

    private FXPdfObjectView pdfObjectView;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Constructs the MouseEvent-Handler for the PdfArea.
     */
    public FXPdfAreaMouseHandler()
    {
    }

    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Initializes the MouseEvent-Handler.
     */
    public void initialize(FXPdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;
    }

    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Method called every time a mouse button has been clicked.
     */
    @Override
    public void handle(MouseEvent event)
    {
        if (this.getPdfObject() == null) { return; }

        Point2D actualPoint = this.getPdfArea().getActualCoordinatesOfPoint(
            new Point2D(event.getX(), event.getY())
        );

        if(this.getPdfArea().isAddingNotation()
            && !this.getPdfArea().isNotationInRangeOfOtherNotation(
            actualPoint)
            )
        {
            // @ todo move to external dialog
            Notation emptyNotation = NotationFactory.getEmptyNotation(
                this.getPdfObject().getListOfEntityNamesAndTypes()
            );
            emptyNotation.setValue(
                0, this.getPdfObject().getIdForNextNotation()
            );
            emptyNotation.setValue(1, (int) actualPoint.getX());
            emptyNotation.setValue(2, (int) actualPoint.getY());
            emptyNotation.setValue(3, Notation.STANDARD_NAME);
            emptyNotation.setValue(4, Notation.STANDARD_DESCRIPTION);
            this.getPdfObject().addNotation(emptyNotation);

            this.getPdfArea().setCursorTypeToDefault();
            this.getPdfArea().setAddingNotation(false);

            // update table so the last row can be selected
            this.pdfObjectView.getNotationListScrollPane().updateTable();

            this.getPdfObject().setSelectedNotationId(emptyNotation.getId());
            this.pdfObjectView.getNotationListScrollPane()
                .setSelectedRow(emptyNotation.getId());
        }
        // no need to get clicked notation, because a notation was added,
        // which is the clicked Notation
        else
        {
            Notation notation = this.getPdfArea().getClickedNotation(
                actualPoint
            );
            if (notation != null) {
                int selectedNotationId = notation.getId();
                this.getPdfObject().setSelectedNotationId(selectedNotationId);
                this.pdfObjectView.getNotationListScrollPane()
                    .setSelectedRow(selectedNotationId);
            }
            else
            {
                this.getPdfObject().setSelectedNotationId(
                    Environment.SELECTED_NOTATION_NULL_VALUE
                );
                this.pdfObjectView.getNotationListScrollPane().deselectRow();
            }
        }

        this.getPdfArea().repaintNotations();
        this.pdfObjectView.getNotationListScrollPane().updateTable();
        this.pdfObjectView.getNotationEntityScrollPane().updateTable();
    }

    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Returns the PdfObject of the PdfObjectView.
     */
    private PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Returns the PdfArea.
     */
    private FXPdfArea getPdfArea()
    {
        return this.pdfObjectView.getPdfArea();
    }
}
