package view.partials.partials;

import model.NotationEntityTableModel;
import model.ProjectCon;

import javax.swing.*;
import java.awt.*;

public class NotationEntityScrollPane extends JScrollPane {

    // @todo make editable

    private ProjectCon projectCon;
    private NotationEntityTableModel notationEntityTableModel;

    private JTable notationEntityTable;


    /*
     * #########################################################################
     * #                    Konstruktor                                        #
     * #########################################################################
     */

    public NotationEntityScrollPane(ProjectCon projectCon) {

        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.projectCon = projectCon;
        this.notationEntityTableModel = new NotationEntityTableModel(this.projectCon);

        this.notationEntityTable = new JTable(this.notationEntityTableModel);

        this.notationEntityTable.setAutoCreateRowSorter(true);

        this.getViewport().add(notationEntityTable);
    }


    /*
     * #########################################################################
     * #                    öffentliche Methoden                               #
     * #########################################################################
     */

    public void updateTable(){

        this.notationEntityTableModel.fireTableDataChanged();
    }

    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
