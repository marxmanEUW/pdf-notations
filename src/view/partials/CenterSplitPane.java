package view.partials;

import view.partials.partials.NotationSplitPane;
import view.partials.partials.PdfScrollPane;

import javax.swing.*;
import java.awt.*;

public class CenterSplitPane extends JSplitPane {

    public PdfScrollPane pdfScrollPane;

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



    public CenterSplitPane()
    {
        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

        this.pdfScrollPane = new PdfScrollPane();
        NotationSplitPane notationSplitPane = new NotationSplitPane();

        this.setLeftComponent(this.pdfScrollPane);
        this.setRightComponent(notationSplitPane);

        this.setDividerLocation(this.DEVIDER_LOCATION);
        this.setOneTouchExpandable(true);
        this.setContinuousLayout(true);
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
