package view.partials.partials.partials;

import listeners.NotationListSelectionListener;
import model.NotationListTableModel;
import model.ProjectCon;

import javax.swing.*;
import java.awt.*;

public class NotationListScrollPane extends JScrollPane {

    private ProjectCon projectCon;
    private NotationListTableModel notationListTableModel;
    private ListSelectionModel listSelectionModel;
    private NotationListSelectionListener notationListSelectionListener;

    private JTable notationListTable;


    /*
     * #########################################################################
     * #                    Konstruktor                                        #
     * #########################################################################
     */

    public NotationListScrollPane(ProjectCon projectCon) {

        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.projectCon = projectCon;
        this.notationListTableModel = new NotationListTableModel(this.projectCon);

        this.notationListTable = new JTable(this.notationListTableModel);

        this.notationListTable.setAutoCreateRowSorter(true);

        this.notationListSelectionListener = new NotationListSelectionListener(this.projectCon);
        this.listSelectionModel = this.notationListTable.getSelectionModel();
        this.listSelectionModel.addListSelectionListener(this.notationListSelectionListener);
        this.notationListTable.setSelectionModel(this.listSelectionModel);

        this.getViewport().add(notationListTable);
    }


    /*
     * #########################################################################
     * #                    öffentliche Methoden                               #
     * #########################################################################
     */

    public void updateTable(){

        this.notationListTableModel.fireTableDataChanged();
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
