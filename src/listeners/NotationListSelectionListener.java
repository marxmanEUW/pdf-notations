package listeners;

import model.PdfObject;
import view.projectView.pdfObjectView.partials.NotationSplitPane;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NotationListSelectionListener implements ListSelectionListener {

    private PdfObjectView pdfObjectView;


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Initializes the NotationSelectionListener.
     */
    public void initialize(PdfObjectView pdfObjectView)
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
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Gets called if the selected row of a table was changed.
     *          Updates SelectedNotationIndex and NotationEntityTable.
     */
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if(this.getPdfObject() != null)
        {
            JTable entityTable = this.pdfObjectView.getEntityScrollPane().getNotationEntityTable();

            if (entityTable.isEditing())
            {
                entityTable.getCellEditor().stopCellEditing();
            }

            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if(lsm.isSelectionEmpty())
            {
                this.getPdfObject().setSelectedNotationIndex(
                    PdfObject.SELECTED_NOTATION_NULL_VALUE
                );
            }
            else
            {
                if(!lsm.getValueIsAdjusting())
                {
                    JTable notationList = this.pdfObjectView.getNotationListScrollPane().
                        getNotationListTable();


                    int selectedRow = notationList.getSelectedRow();
                    this.getPdfObject().setSelectedNotationIndex(
                        (int) notationList.getValueAt(selectedRow, 0)
                    );
                }
            }

            this.pdfObjectView.getEntityScrollPane().updateTable();
            this.pdfObjectView.getPdfArea().repaint();
        }
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethode                               #
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
}
