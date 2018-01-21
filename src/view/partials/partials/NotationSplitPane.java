package view.partials.partials;

import model.ProjectCon;

import javax.swing.*;
import java.awt.*;

public class NotationSplitPane extends JSplitPane {

    private final int DEVIDER_LOCATION
        = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.4);

    private ProjectCon projectCon;

    private NotationListScrollPane notationListScrollPane;


    /*
     * @todo testing
     */
    private JButton testButtonCenterRightUpper
        = new JButton("Test Button Center Right Upper");
    private JButton testButtonCenterRightLower
        = new JButton("Test Button Center Right Lower");


    public NotationSplitPane(ProjectCon projectCon)
    {
        this.projectCon = projectCon;

        this.setOrientation(JSplitPane.VERTICAL_SPLIT);

        //this.setTopComponent(this.testButtonCenterRightUpper);
        //this.setBottomComponent(this.testButtonCenterRightLower);
        this.notationListScrollPane = new NotationListScrollPane(this.projectCon);
        this.setTopComponent(this.notationListScrollPane);


        this.setDividerLocation(this.DEVIDER_LOCATION);
        this.setOneTouchExpandable(true);
        this.setContinuousLayout(true);

        this.repaint();
    }


    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
    }
}
