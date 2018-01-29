package view.projectView.pdfObjectView.partials;

import gui.Constants;
import model.Notation;
import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.table.AbstractTableModel;

public class EntityTableModel extends AbstractTableModel {

    private PdfObjectView pdfObjectView;


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
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

    @Override
    public int getRowCount()
    {
        if (this.getPdfObject() == null)
        {
            return 0;
        } else
        {
            return Notation.INFORMATION_COUNT + 2;
        }
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if (this.getPdfObject() == null)
        {
            return null;
        }

        if (this.getPdfObject().getSelectedNotationIndex() == PdfObject.SELECTED_NOTATION_NULL_VALUE){
            return null;
        }

        if (columnIndex == 1){
            switch (rowIndex){
                case 0: return this.getPdfObject().getSelectedNotation().getId();
                case 1: return this.getPdfObject().getSelectedNotation().getName();
                case 2: return this.getPdfObject().getSelectedNotation().getX();
                case 3: return this.getPdfObject().getSelectedNotation().getY();
                default: return null;
            }
        } else {
            switch (rowIndex){
                case 0: return "Id";
                case 1: return "Name";
                case 2: return "X";
                case 3: return "Y";
                default: return null;
            }
        }
    }

    public String getColumnName(int column)
    {
        // @todo Rückgabe dynamisch machen
        // @todo Strings in Konstanten auslagern
        switch (column){
            case 0: return Constants.ENTITY_TABLE_MODEL_COLUMN_1_NAME;
            case 1: return Constants.ENTITY_TABLE_MODEL_COLUMN_2_NAME;
            default: return null;
        }
    }

    public Class getColumnClass(int columnIndex)
    {
        // @todo Rückgabe dynamisch machen
        return String.class;
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
}
