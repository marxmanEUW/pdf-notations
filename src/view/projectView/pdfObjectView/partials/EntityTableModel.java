package view.projectView.pdfObjectView.partials;

import constants.Environment;
import constants.Labels;
import factories.DialogFactory;
import model.Notation;
import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.table.AbstractTableModel;

public class EntityTableModel extends AbstractTableModel {

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
     * @brief   Initializes the EntityTableModel.
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
            return this.getPdfObject().getEntityCount();
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

        if (this.getPdfObject().getSelectedNotationId() ==
                Environment.SELECTED_NOTATION_NULL_VALUE)
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
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the name of a column (for the table header).
     */
    public String getColumnName(int column)
    {
        switch (column)
        {
            case 0: return Labels.ENTITY_TABLE_MODEL_COLUMN_1_NAME;
            case 1: return Labels.ENTITY_TABLE_MODEL_COLUMN_2_NAME;
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
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns if a specific cell should be editable.
     *          Make full first column and ID cell not editable.
     */
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        boolean returnValue = true;

        if (rowIndex == 0 || columnIndex == 0)
        {
            returnValue = false;
        }

        return returnValue;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the value for a specific cell.
     * @todo check if editedValue has the right value type
     */
    public void setValueAt(Object editedValue, int rowIndex, int columnIndex)
    {
        this.getPdfObject().getSelectedNotation().setValue(rowIndex, editedValue);

        this.pdfObjectView.getPdfArea().repaint();
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
     * @brief   Returns true if the value is an integer.
     */
    private boolean isInteger(String value)
    {
        boolean status = true;
        if(value.length() < 1)
        {
            return false;
        }

        for(char c : value.toCharArray())
        {
            if(!Character.isDigit(c))
            {
                status = false;
                break;
            }
        }

        return status;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets one coordinate of the selected notation.
     */
    private void setOneCoordinate(char coordinateIdentifier, String value)
    {
        Notation selectedNotation = this.getPdfObject().getSelectedNotation();

        if (isInteger(value))
        {
            switch (coordinateIdentifier)
            {
                case Environment.X_IDENTIFIER:
                    selectedNotation.setX(Integer.parseInt(value));
                    break;
                case Environment.Y_IDENTIFIER:
                    selectedNotation.setY(Integer.parseInt(value));
                    break;
            }
            this.pdfObjectView.getPdfArea().repaint();
        }
        else
        {
            DialogFactory.showWarningThatValueIsNoInt(value);
        }
    }
}
