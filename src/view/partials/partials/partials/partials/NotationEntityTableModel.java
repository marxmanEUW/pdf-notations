package view.partials.partials.partials.partials;

import model.NotationCon;
import model.ProjectCon;

import javax.swing.table.AbstractTableModel;

public class NotationEntityTableModel extends AbstractTableModel {

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
        return NotationCon.INFORMATION_COUNT + 2;
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if (this.projectCon.getSelectedNotationIndex() == -1){
            return null;
        }

        if (columnIndex == 1){
            switch (rowIndex){
                case 0: return this.projectCon.getSelectedNotation().getId();
                case 1: return this.projectCon.getSelectedNotation().getName();
                case 2: return this.projectCon.getSelectedNotation().getX();
                case 3: return this.projectCon.getSelectedNotation().getY();
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
}
