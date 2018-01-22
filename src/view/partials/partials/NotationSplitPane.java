package view.partials.partials;

import model.ProjectCon;

import javax.swing.*;
import java.awt.*;

public class NotationSplitPane extends JSplitPane {

    private final int DEVIDER_LOCATION
        = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.4);

    private ProjectCon projectCon;

    private NotationListScrollPane notationListScrollPane;
    private NotationEntityScrollPane notationEntityScrollPane;


    public NotationSplitPane()
    {
        this.setOrientation(JSplitPane.VERTICAL_SPLIT);
        this.setDividerLocation(this.DEVIDER_LOCATION);
        this.setOneTouchExpandable(true);
        this.setContinuousLayout(true);
    }

    public void initialize(ProjectCon projectCon)
    {
        this.projectCon = projectCon;

        this.notationListScrollPane = new NotationListScrollPane(this.projectCon);
        this.notationEntityScrollPane = new NotationEntityScrollPane(this.projectCon);

        this.setTopComponent(this.notationListScrollPane);
        this.setBottomComponent(this.notationEntityScrollPane);
    }

    public void updateNotationList()
    {
        this.notationListScrollPane.updateTable();
    }

    public void updateNotationEntityTable()
    {
        this.notationEntityScrollPane.updateTable();
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
    }


}
