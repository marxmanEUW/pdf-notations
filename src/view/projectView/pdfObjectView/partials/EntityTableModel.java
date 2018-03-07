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
            return Environment.INFORMATION_COUNT + 2;
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

        if (
            this.getPdfObject().getSelectedNotationId() ==
                Environment.SELECTED_NOTATION_NULL_VALUE
            )
        {
            return null;
        }

        if (columnIndex == 1)
        {
            switch (rowIndex)
            {
                case 0:
                    return this.getPdfObject().getSelectedNotation().getId();
                case 1:
                    return this.getPdfObject().getSelectedNotation().getName();
                case 2:
                    return this.getPdfObject().getSelectedNotation().getX();
                case 3:
                    return this.getPdfObject().getSelectedNotation().getY();
                case 4:
                    return this.getPdfObject().getSelectedNotation().
                        getDescription();
                default: return null;
            }
        }
        else
        {
            switch (rowIndex)
            {
                case 0: return "Id";
                case 1: return "Name";
                case 2: return "X";
                case 3: return "Y";
                case 4: return "Beschreibung";
                default: return null;
            }
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
     */
    public void setValueAt(Object editedValue, int rowIndex, int columnIndex)
    {
        Notation selectedNotation = this.getPdfObject().getSelectedNotation();

        if (selectedNotation == null) { return; }

        switch (rowIndex)
        {
            case 1:
                selectedNotation.setName((String) editedValue);
                this.pdfObjectView.getNotationListScrollPane().repaint();
                break;
            case 2:
                setOneCoordinate(
                    Environment.X_IDENTIFIER,
                    (String) editedValue
                );
                break;
            case 3:
                setOneCoordinate(
                    Environment.Y_IDENTIFIER,
                    (String) editedValue
                );
                break;
            case 4:
                selectedNotation.setDescription((String) editedValue);
                break;
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
