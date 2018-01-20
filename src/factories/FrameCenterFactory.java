package factories;

import view.MainFrame;

import javax.swing.*;

public abstract class FrameCenterFactory {

    /*
     * @note "final" could be removed to impelement a feature which can memorize
     *       the position of the dividers even after a restart
     */
    private static final int MAIN_SPLITPANE_DEVIDER_POSITION = 1200;
    private static final int RIGHT_SPLITPANE_DEVIDER_POSITION = 300;

    private static MainFrame mainFrame;

    // @todo testing
    private static JButton testButtonCenterLeft
        = new JButton("Test Button Center Left");
    private static JButton testButtonCenterRightUpper
        = new JButton("Test Button Center Right Upper");
    private static JButton testButtonCenterRightLower
        = new JButton("Test Button Center Right Lower");

    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */
    public static JSplitPane createAndReturnFrameCenterComponent(
        MainFrame mainFrame)
    {
        FrameCenterFactory.mainFrame = mainFrame;


        return createAndReturnMainSplitPane();
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    private static JSplitPane createAndReturnMainSplitPane()
    {
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        JScrollPane pdfAreaScrollPane = new JScrollPane(
            FrameCenterFactory.mainFrame.getPdfArea(),
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        mainSplitPane.setLeftComponent(pdfAreaScrollPane);

        JSplitPane rightSplitPane = createAndReturnRightSplitPane();
        mainSplitPane.setRightComponent(rightSplitPane);

        mainSplitPane.setDividerLocation(MAIN_SPLITPANE_DEVIDER_POSITION);
        mainSplitPane.setOneTouchExpandable(true);
        mainSplitPane.setContinuousLayout(true);

        return mainSplitPane;
    }

    private static JSplitPane createAndReturnRightSplitPane()
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
