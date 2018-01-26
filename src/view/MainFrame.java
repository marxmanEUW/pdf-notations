package view;

import factories.PdfObjectFactory;
import listeners.MainFrameKeyListener;
import listeners.MenuBarActionListener;
import gui.Constants;
import listeners.ToolBarActionListener;
import view.bar.MainFrameMenuBar;
import view.bar.MainFrameToolBar;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainFrameMenuBar menuBar;
    private MenuBarActionListener mbActionListener;

    private MainFrameToolBar toolBar;
    private ToolBarActionListener tbActionListener;

    private PdfObjectView pdfObjectView;
    //private PdfObject pdfObject;

    private MainFrameKeyListener mainFrameKeyListener;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public MainFrame()
    {
        this.setLookAndFell();

        this.setLayout(new BorderLayout());
        this.setTitle(Constants.FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // @todo beide zeilen zu testzwecken -> loeschen und unter zeile auskommentieren
        this.setPreferredSize(new Dimension(1200, 600));
        this.pack();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.mainFrameKeyListener = new MainFrameKeyListener();

        this.menuBar = new MainFrameMenuBar();
        this.mbActionListener = new MenuBarActionListener();

        this.toolBar = new MainFrameToolBar();
        this.tbActionListener = new ToolBarActionListener();

        this.pdfObjectView = new PdfObjectView();
        //this.pdfObject = new PdfObject();

        //this.project = new Project();
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    public void initialize()
    {
        this.mainFrameKeyListener.initialize(this);
        this.addKeyListener(this.mainFrameKeyListener);
        this.setFocusable(true);

        this.mbActionListener.initialize(this.pdfObjectView);

        this.menuBar.initialize(this.mbActionListener);
        this.toolBar.initialize(this.tbActionListener);


        //this.pdfObject.setSourePath(Launcher.PATH_TO_PDF1);
        this.pdfObjectView.initialize();


        this.setJMenuBar(this.menuBar);
        this.getContentPane().add(
            this.toolBar,
            BorderLayout.NORTH
        );
        this.getContentPane().add(
            this.pdfObjectView,
            BorderLayout.CENTER
        );


        this.setLookAndFell();

        this.setVisible(true);
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public MainFrameMenuBar getJMenuBar()
    {
        return this.menuBar;
    }

    public PdfObjectView getPdfObjectView()
    {
        return this.pdfObjectView;
    }

    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */



    /*
     * #########################################################################
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    private void setLookAndFell()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}