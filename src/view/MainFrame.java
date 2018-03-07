package view;

import constants.Labels;
import factories.DialogFactory;
import listeners.MainFrameKeyListener;
import listeners.BarActionListener;
import listeners.MainFrameWindowAdapter;
import view.bar.MainFrameMenuBar;
import view.bar.MainFrameToolBar;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Bars
    private MainFrameMenuBar menuBar;
    private MainFrameToolBar toolBar;

    // PDF-Object
    private PdfObjectView pdfObjectView;

    // Listeners
    private BarActionListener barActionListener;
    private MainFrameKeyListener mainFrameKeyListener;
    private MainFrameWindowAdapter mainFrameWindowAdapter;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  AbellaMort
     * @changes
     *      2018-02-12 (AbellaMort) created
     * @brief   Constructor of the MainFrame.
     */
    public MainFrame()
    {
        this.setLookAndFeel();

        this.setLayout(new BorderLayout());
        this.setTitle(Labels.FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.setPreferredSize(new Dimension(
            (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
            (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


        this.mainFrameWindowAdapter = new MainFrameWindowAdapter();
        this.mainFrameKeyListener = new MainFrameKeyListener();

        this.menuBar = new MainFrameMenuBar();
        this.barActionListener = new BarActionListener();

        this.toolBar = new MainFrameToolBar();

        this.pdfObjectView = new PdfObjectView();
    }


    /*
     * #########################################################################
     * #                    Initialising                                       #
     * #########################################################################
     */
    /*
     * @author  AbellaMort
     * @changes
     *      2018-02-12 (AbellaMort) created
     * @brief   Initialises the MainFrame.
     */
    public void initialize()
    {
        this.addWindowListener(this.mainFrameWindowAdapter);

        this.mainFrameKeyListener.initialize(this);
        this.addKeyListener(this.mainFrameKeyListener);
        this.setFocusable(true);

        this.barActionListener.initialize(this);

        this.menuBar.initialize(this);
        this.toolBar.initialize(this);

        this.pdfObjectView.initialize(this);


        this.setJMenuBar(this.menuBar);
        this.getContentPane().add(
            this.toolBar,
            BorderLayout.NORTH
        );
        this.getContentPane().add(
            this.pdfObjectView,
            BorderLayout.CENTER
        );


        this.setLookAndFeel();

        this.setVisible(true);
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the MenuBar of the MainFrame.
     */
    public MainFrameMenuBar getJMenuBar()
    {
        return this.menuBar;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the Toolbar of the MainFrame.
     */
    public MainFrameToolBar getToolBar()
    {
        return this.toolBar;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the PdfObjectView of the MainFrame.
     */
    public PdfObjectView getPdfObjectView()
    {
        return this.pdfObjectView;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-07 (marxmanEUW)  created
     * @brief   Returns the BarActionListener of the MainFrame.
     */
    public BarActionListener getBarActionListener()
    {
        return barActionListener;
    }

    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW) created
     *      2018-03-02 (AbellaMort) Changed error-handling to display errors in
     *                              error-dialog
     *      2018-03-07  (yxyxD)     handling all exception on one catch-statement
     * @brief   Sets the look and feel of the program.
     */
    private void setLookAndFeel()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception exception)
        {
            DialogFactory.showErrorDialog(exception.getMessage());
        }
    }

}