package view.projectView.pdfObjectView.partials;

import constants.Environment;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class NotationSplitPane extends JSplitPane {

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Constructs the NotationSplitPane which contains ListScrollPane
     *          and EntityScrollPane.
     */
    public NotationSplitPane()
    {
        this.setOrientation(JSplitPane.VERTICAL_SPLIT);
        this.setOneTouchExpandable(true);
        this.setContinuousLayout(true);
    }


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Initialises the NotationSplitPane.
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.setDividerLocation(
            (int) (pdfObjectView.getMainFrame().getHeight()
                * Environment.NOTATION_SPLIT_PANE_DIVIDER_LOCATION)
        );

        this.setTopComponent(pdfObjectView.getNotationListScrollPane());
        this.setBottomComponent(pdfObjectView.getEntityScrollPane());
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Repaints the NotationSplitPane.
     */
    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
    }
}
