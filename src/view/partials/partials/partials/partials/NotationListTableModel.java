package view.partials.partials.partials.partials;

import model.NotationCon;
import model.ProjectCon;

import javax.swing.table.AbstractTableModel;

public class NotationListTableModel extends AbstractTableModel {

    private ProjectCon projectCon;


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(ProjectCon projectCon)
    {
        this.projectCon = projectCon;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */

    @Override
    public int getRowCount()
    {
        return this.projectCon.getListOfNotationConsSize();
    }

    @Override
    public int getColumnCount()
    {
        return NotationCon.INFORMATION_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch (columnIndex){
            case 0: return this.projectCon.getListOfNotationCons().get(rowIndex).getId();
            case 1: return this.projectCon.getListOfNotationCons().get(rowIndex).getName();
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
