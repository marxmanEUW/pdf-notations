package view.partials.partials.partials.partials;

import model.Notation;
import model.PdfObject;
import view.test.PdfObjectView;

import javax.swing.table.AbstractTableModel;

public class NotationListTableModel extends AbstractTableModel {

    private PdfObjectView pdfObjectView;
    private PdfObject pdfObject;


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.pdfObject = this.pdfObjectView.getPdfObject();
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */

    @Override
    public int getRowCount()
    {
        return this.pdfObject.getListOfNotationConsSize();
    }

    @Override
    public int getColumnCount()
    {
        return Notation.INFORMATION_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch (columnIndex){
            case 0: return this.pdfObject.getListOfNotations().get(rowIndex).getId();
            case 1: return this.pdfObject.getListOfNotations().get(rowIndex).getName();
            default: return null;
        }
    }

    public String getColumnName(int column)
    {
        // @todo Rückgabe dynamisch machen
        // @todo Strings in Konstanten auslagern
        switch (column){
            case 0: return "Id";
            case 1: return "Name";
            default: return null;
        }
    }

    public Class getColumnClass(int columnIndex)
    {
        // @todo Rückgabe dynamisch machen
        return String.class;
    }
}
