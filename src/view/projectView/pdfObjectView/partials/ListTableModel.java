package view.projectView.pdfObjectView.partials;

import gui.Constants;
import model.Notation;
import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.table.AbstractTableModel;

public class ListTableModel extends AbstractTableModel {

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
            return this.getPdfObject().getListOfNotationsSize();
        }
    }

    @Override
    public int getColumnCount()
    {
        return Notation.INFORMATION_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if (this.getPdfObject() == null)
        {
            return null;
        }

        switch (columnIndex){
            case 0: return this.getPdfObject().getListOfNotations().get(rowIndex).getId();
            case 1: return this.getPdfObject().getListOfNotations().get(rowIndex).getName();
            default: return null;
        }
    }

    public String getColumnName(int column)
    {
        switch (column){
            case 0: return Constants.LIST_TABLE_MODEL_COLUMN_1_NAME;
            case 1: return Constants.LIST_TABLE_MODEL_COLUMN_2_NAME;
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
