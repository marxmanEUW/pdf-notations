package fx_handler;

import constants.Environment;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import model.Notation;
import model.PdfObject;

public class FXNotationListTableChangeListener implements ChangeListener<Notation> {

    private FXPdfObjectView pdfObjectView;


    /*
     * #########################################################################
     * #                    Initialising                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Initializes the NotationListTableChangeListener.
     */
    public void initialize(FXPdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;
    }


    /*
     * #########################################################################
     * #                    Overrides                                         #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Gets called if the selected row of a table was changed.
     *          Updates SelectedNotationIndex and NotationEntityTable.
     */
    @Override
    public void changed(ObservableValue<? extends Notation> observable, Notation oldValue, Notation newValue)
    {
        if(this.getPdfObject() != null)
        {
            // @todo cancel cell editing of NotationEntityTabel

            if(newValue == null)
            {
                this.getPdfObject().setSelectedNotationId(
                    Environment.SELECTED_NOTATION_NULL_VALUE
                );
            }
            else
            {
                this.getPdfObject().setSelectedNotationId(
                    this.pdfObjectView.getNotationListTableView()
                        .getSelectionModel().getSelectedItem().getId()
                );
            }

            this.pdfObjectView.getNotationEntityTableView().updateTable();
            this.pdfObjectView.getPdfArea().repaintNotations();
        }
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
}
