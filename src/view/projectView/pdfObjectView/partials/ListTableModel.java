package view.projectView.pdfObjectView.partials;

import constants.Labels;
import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.table.AbstractTableModel;

public class ListTableModel extends AbstractTableModel {

    private PdfObjectView pdfObjectView;


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Initializes the ListTableModel.
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
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the number of rows.
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
            return this.getPdfObject().getListOfNotations().size();
        }
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the number of columns.
     */
    @Override
    public int getColumnCount()
    {
        return 2;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the value for a specific cell.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if (this.getPdfObject() == null)
        {
            return null;
        }

        if (columnIndex == 1)
        {
            return this.getPdfObject().getListOfNotationsAsList().
                get(rowIndex).getValue(3);
        }
        else
        {
            return this.getPdfObject().getListOfNotationsAsList().
                get(rowIndex).getValue(columnIndex);
        }
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the name of a column (for the table header).
     */
    public String getColumnName(int column)
    {
        switch (column)
        {
            case 0: return Labels.LIST_TABLE_MODEL_COLUMN_1_NAME;
            case 1: return Labels.LIST_TABLE_MODEL_COLUMN_2_NAME;
            default: return null;
        }
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the class of a column.
     */
    public Class getColumnClass(int columnIndex)
    {
        return String.class;
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
}
