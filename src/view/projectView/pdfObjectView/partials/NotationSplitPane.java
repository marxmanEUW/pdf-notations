package view.projectView.pdfObjectView.partials;

import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class NotationSplitPane extends JSplitPane {

    private final int DEVIDER_LOCATION
        = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.4);

    private PdfObjectView pdfObjectView;

    private ListScrollPane notationListScrollPane;
    private EntityScrollPane entityScrollPane;


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
        this.setDividerLocation(this.DEVIDER_LOCATION);
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
        this.pdfObjectView = pdfObjectView;

        this.notationListScrollPane =
            this.pdfObjectView.getNotationListScrollPane();
        this.entityScrollPane = this.pdfObjectView.getEntityScrollPane();

        this.setTopComponent(this.notationListScrollPane);
        this.setBottomComponent(this.entityScrollPane);
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

    /*
     * #########################################################################
     * #                    Public Methods                                     #
     * #########################################################################
     */


    /*
     * #########################################################################
     * #                    private Hilfsmethode                               #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfObject of the PdfObjectView.
     */
    private PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }
}
