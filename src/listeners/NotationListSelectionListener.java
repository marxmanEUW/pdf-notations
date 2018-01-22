package listeners;

import model.ProjectCon;
import view.partials.partials.NotationSplitPane;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NotationListSelectionListener implements ListSelectionListener {

    // @todo was soll angezeigt / gemacht werden, wenn mehrer Reihen ausgewählt werden

    private ProjectCon projectCon;
    private NotationSplitPane notationSplitPane;


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(NotationSplitPane notationSplitPane, ProjectCon projectCon)
    {
        this.projectCon = projectCon;
        this.notationSplitPane = notationSplitPane;
    }


    /*
     * #########################################################################
     * #                    Overrides                                         #
     * #########################################################################
     */

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        this.projectCon.setSelectedNotationIndex(lsm.getLeadSelectionIndex());
        this.notationSplitPane.updateNotationEntityTable();
    }
}
