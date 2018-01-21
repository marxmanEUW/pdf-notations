package view.partials;

import model.ProjectCon;
import view.partials.partials.NotationSplitPane;
import view.partials.partials.PdfScrollPane;

import javax.swing.*;
import java.awt.*;

public class CenterSplitPane extends JSplitPane {

    public PdfScrollPane pdfScrollPane;
    private NotationSplitPane notationSplitPane;

    private ProjectCon projectCon;

    /*
     * @note "final" could be removed to impelement a feature which can memorize
     *       the position of the dividers even after a restart
     */
    // @todo Dividerposition an Größe des MainFrames festmachen
    private final int DEVIDER_LOCATION
        = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.8);

    // @todo testing
    private JButton testButtonCenterLeft
        = new JButton("Test Button Center Left");



    public CenterSplitPane(ProjectCon projectCon)
    {
        this.projectCon = projectCon;

        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

        this.pdfScrollPane = new PdfScrollPane(this.projectCon);
        this.notationSplitPane = new NotationSplitPane(this.projectCon);

        this.setLeftComponent(this.pdfScrollPane);
        this.setRightComponent(this.notationSplitPane);

        this.setDividerLocation(this.DEVIDER_LOCATION);
        this.setOneTouchExpandable(true);
        this.setContinuousLayout(true);
    }


    public void updateNotationList()
    {
        this.notationSplitPane.updateNotationList();
    }

    public void updateNotationEntityTable()
    {
        this.notationSplitPane.updateNotationEntityTable();
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
