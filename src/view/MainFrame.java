package view;

import listeners.MainFrameKeyListener;
import listeners.BarActionListener;
import gui.Constants;
import listeners.MainFrameWindowAdapter;
import view.bar.MainFrameMenuBar;
import view.bar.MainFrameToolBar;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainFrameMenuBar menuBar;
    private BarActionListener barActionListener;

    private MainFrameToolBar toolBar;

    private PdfObjectView pdfObjectView;

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
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // @todo beide zeilen zu testzwecken -> loeschen und unter zeile auskommentieren
        this.setPreferredSize(new Dimension(1200, 600));
        this.pack();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.mainFrameKeyListener = new MainFrameKeyListener();

        this.menuBar = new MainFrameMenuBar();
        this.barActionListener = new BarActionListener();

        this.toolBar = new MainFrameToolBar();

        this.pdfObjectView = new PdfObjectView();
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    public void initialize()
    {
        this.addWindowListener(new MainFrameWindowAdapter());

        this.mainFrameKeyListener.initialize(this);
        this.addKeyListener(this.mainFrameKeyListener);
        this.setFocusable(true);

        this.barActionListener.initialize(this);

        this.menuBar.initialize(this.barActionListener);
        this.toolBar.initialize(this.barActionListener);


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