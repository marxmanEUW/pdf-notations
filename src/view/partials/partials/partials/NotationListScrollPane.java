package view.partials.partials.partials;

import listeners.NotationListSelectionListener;
import view.partials.partials.partials.partials.NotationListTableModel;
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
     * #                    Constructor                                        #
     * #########################################################################
     */

    public NotationListScrollPane()
    {
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.notationListTableModel = new NotationListTableModel();

        this.notationListTable = new JTable();

        this.notationListSelectionListener = new NotationListSelectionListener();
        this.listSelectionModel = this.notationListTable.getSelectionModel();
        this.listSelectionModel.addListSelectionListener(this.notationListSelectionListener);
        this.notationListTable.setSelectionModel(this.listSelectionModel);
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(ProjectCon projectCon)
    {
        this.projectCon = projectCon;
        this.notationListTableModel.initialize(this.projectCon);

        this.notationListTable.setModel(this.notationListTableModel);
        this.notationListTable.setAutoCreateRowSorter(true);

        this.notationListSelectionListener.initialize(this.projectCon);

        this.getViewport().add(notationListTable);
    }


    /*
     * #########################################################################
     * #                    öffentliche Methoden                               #
     * #########################################################################
     */

    public void updateTable()
    {
        this.notationListTableModel.fireTableDataChanged();
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}
