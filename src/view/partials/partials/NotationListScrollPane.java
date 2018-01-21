package view.partials.partials;

import model.NotationListTableModel;
import model.ProjectCon;

import javax.swing.*;
import java.awt.*;

public class NotationListScrollPane extends JScrollPane {

    /* @todo TableModel??
     *       RowSorter
     *       tablemodel
     */

    private ProjectCon projectCon;
    private NotationListTableModel notationListTableModel;

    private JTable table;

    public NotationListScrollPane(ProjectCon projectCon) {

        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.projectCon = projectCon;
        this.notationListTableModel = new NotationListTableModel(this.projectCon);

        this.table = new JTable(this.notationListTableModel);

        this.table.setAutoCreateRowSorter(true);

        this.getViewport().add(table);
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
