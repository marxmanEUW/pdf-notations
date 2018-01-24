package view.project_view.pdfobject_view.partials;

import model.PdfObject;
import view.project_view.pdfobject_view.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class NotationSplitPane extends JSplitPane {

    private final int DEVIDER_LOCATION
        = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.4);

    private PdfObjectView pdfObjectView;
    private PdfObject pdfObject;

    private ListScrollPane notationListScrollPane;
    private EntityScrollPane entityScrollPane;

    //private NotationListSelectionListener notationListSelectionListener;

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
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.pdfObject = this.pdfObjectView.getPdfObject();
        this.notationListScrollPane = this.pdfObjectView.getNotationListScrollPane();
        this.entityScrollPane = this.pdfObjectView.getEntityScrollPane();
        //this.notationListSelectionListener = this.pdfObjectView.getNotationListSelectionListener();

        this.setTopComponent(this.notationListScrollPane);
        this.setBottomComponent(this.entityScrollPane);
    }


    /*
     * #########################################################################
     * #                    öffentliche Methoden                               #
     * #########################################################################
     */

    public void updateNotationListTable()
    {
        this.notationListScrollPane.updateTable();
    }

    public void updateNotationEntityTable()
    {
        this.entityScrollPane.updateTable();
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
