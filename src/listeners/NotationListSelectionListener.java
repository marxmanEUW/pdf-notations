package listeners;

import model.ProjectCon;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NotationListSelectionListener implements ListSelectionListener {

    // @todo was soll angezeigt / gemacht werden, wenn mehrer Reihen ausgewählt werden

    private ProjectCon projectCon;

    public NotationListSelectionListener(ProjectCon projectCon)
    {
        this.projectCon = projectCon;
    }


    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        this.projectCon.setSelectedNotationIndex(e.getFirstIndex());
        this.projectCon.updateNotationEntityTable();
    }
}
