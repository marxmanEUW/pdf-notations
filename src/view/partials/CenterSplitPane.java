package view.partials;

import view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class CenterSplitPane extends JSplitPane {


    /*
     * @note "final" could be removed to impelement a feature which can memorize
     *       the position of the dividers even after a restart
     */
    private final int MAIN_SPLITPANE_DEVIDER_POSITION = 1200;
    private final int RIGHT_SPLITPANE_DEVIDER_POSITION = 300;

    private static MainFrame mainFrame;

    // @todo testing
    private JButton testButtonCenterLeft
        = new JButton("Test Button Center Left");
    private JButton testButtonCenterRightUpper
        = new JButton("Test Button Center Right Upper");
    private JButton testButtonCenterRightLower
        = new JButton("Test Button Center Right Lower");


    public CenterSplitPane()
    {
        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

        this.setLeftComponent(this.testButtonCenterLeft);
        this.setRightComponent(this.testButtonCenterRightLower);

        this.setDividerLocation(0.3);
        this.setOneTouchExpandable(true);
        this.setContinuousLayout(true);

        this.repaint();
    }



    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
    }



    /*
     * #########################################################################
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    private JSplitPane createMainSplitPane()
    {
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        mainSplitPane.setLeftComponent(this.testButtonCenterLeft);

        JSplitPane rightSplitPane = this.createRightSplitPane();
        mainSplitPane.setRightComponent(rightSplitPane);

        return mainSplitPane;
    }

    private JSplitPane createRightSplitPane()
    {
        JSplitPane rightSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        rightSplitPane.setTopComponent(testButtonCenterRightUpper);
        rightSplitPane.setBottomComponent(testButtonCenterRightLower);

        rightSplitPane.setDividerLocation(RIGHT_SPLITPANE_DEVIDER_POSITION);
        rightSplitPane.setOneTouchExpandable(true);
        rightSplitPane.setContinuousLayout(true);

        return rightSplitPane;
    }
}
