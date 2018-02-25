package view.projectView.pdfObjectView.partials;

import gui.Constants;
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
    /*
     * @author  marxmanEUW
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
     * @author  marxmanEUW
     */
    @Override
    public int getRowCount()
    {
        if (this.getPdfObject() == null)
        {
            return 0;
        }
        else
        {
            return this.getPdfObject().getEntityCount();
        }
    }


    /*
     * @author  marxmanEUW
     */
    @Override
    public int getColumnCount()
    {
        return 2;
    }


    /*
     * @author  marxmanEUW
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if (this.getPdfObject() == null)
        {
            return null;
        }

        if (this.getPdfObject().getSelectedNotationIndex() ==
                PdfObject.SELECTED_NOTATION_NULL_VALUE)
        {
            return null;
        }

        if (columnIndex == 1)
        {
            return this.getPdfObject().getSelectedNotation().getValue(rowIndex);
        }
        else
        {
            return this.getPdfObject().getSelectedNotation().getValueName(rowIndex);
        }
    }


    /*
     * @author  marxmanEUW
     */
    public String getColumnName(int column)
    {
        switch (column)
        {
            case 0: return Constants.ENTITY_TABLE_MODEL_COLUMN_1_NAME;
            case 1: return Constants.ENTITY_TABLE_MODEL_COLUMN_2_NAME;
            default: return null;
        }
    }


    /*
     * @author  marxmanEUW
     */
    public Class getColumnClass(int columnIndex)
    {
        // @todo Rückgabe dynamisch machen
        return String.class;
    }


    /*
     * @author  marxmanEUW
     */
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        // make full first column and ID cell not editable
        if(rowIndex == 0 || columnIndex == 0)
        {
            return false;
        }
        else
        {
            return true;
        }

    }


    /*
     * @author  marxmanEUW
     */
    public void setValueAt(Object editedValue, int rowIndex, int columnIndex)
    {
        this.getPdfObject().getSelectedNotation().setValue(rowIndex, editedValue);

        this.pdfObjectView.getPdfArea().repaint();
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
