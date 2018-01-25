package view.projectView.pdfObjectView.partials;

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
        return Notation.INFORMATION_COUNT + 2;
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if (this.getPdfObject().getSelectedNotationIndex() == -1){
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
            case 0: return "Name";
            case 1: return "Wert";
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
