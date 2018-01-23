package view.partials;

import model.PdfObject;
import view.partials.partials.NotationSplitPane;
import view.partials.partials.PdfScrollPane;

import javax.swing.*;
import java.awt.*;

public class CenterSplitPane extends JSplitPane {

    public PdfScrollPane pdfScrollPane;
    private NotationSplitPane notationSplitPane;

    private PdfObject pdfObject;

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


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */

    public CenterSplitPane()
    {
        this.pdfScrollPane = new PdfScrollPane();
        this.notationSplitPane = new NotationSplitPane();

        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        this.setDividerLocation(this.DEVIDER_LOCATION);
        this.setOneTouchExpandable(true);
        this.setContinuousLayout(true);
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(PdfObject pdfObject)
    {
        this.pdfObject = pdfObject;

        this.pdfScrollPane.initialize(this.pdfObject);
        this.notationSplitPane.initialize(this.pdfObject);

        this.setLeftComponent(this.pdfScrollPane);
        this.setRightComponent(this.notationSplitPane);
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
