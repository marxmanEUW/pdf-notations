package view.partials.partials;

import model.ProjectCon;
import view.partials.partials.partials.NotationEntityScrollPane;
import view.partials.partials.partials.NotationListScrollPane;

import javax.swing.*;
import java.awt.*;

public class NotationSplitPane extends JSplitPane {

    private final int DEVIDER_LOCATION
        = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.4);

    private ProjectCon projectCon;

    private NotationListScrollPane notationListScrollPane;
    private NotationEntityScrollPane notationEntityScrollPane;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */

    public NotationSplitPane()
    {
        this.setOrientation(JSplitPane.VERTICAL_SPLIT);
        this.setDividerLocation(this.DEVIDER_LOCATION);
        this.setOneTouchExpandable(true);
        this.setContinuousLayout(true);

        this.notationEntityScrollPane = new NotationEntityScrollPane();
        this.notationListScrollPane = new NotationListScrollPane();
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(ProjectCon projectCon)
    {
        this.projectCon = projectCon;

        this.notationListScrollPane.initialize(this.projectCon);
        this.notationEntityScrollPane.initialize(this.projectCon);

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


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
    }


}
