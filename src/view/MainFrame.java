package view;

import listeners.MenuBarActionListener;
import gui.Constants;
import model.PdfObject;
import model.Project;
import view.partials.CenterSplitPane;
import view.partials.MainFrameMenuBar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainFrameMenuBar menuBar;
    private MenuBarActionListener mbActionListener;
    public CenterSplitPane centerSplitPane;

    private Project project;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */

    public MainFrame()
    {
        this.menuBar = new MainFrameMenuBar();
        this.mbActionListener = new MenuBarActionListener();
        this.centerSplitPane = new CenterSplitPane();

        this.setLayout(new BorderLayout());
        this.setTitle(Constants.FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(Project project)
    {
        this.project = project;

        this.menuBar.initialize(this.mbActionListener);
        this.centerSplitPane.initialize(this.project.getPdfObject());
        this.mbActionListener.initialize(this.project);

        this.setJMenuBar(this.menuBar);
        this.getContentPane().add(
            this.centerSplitPane,
            BorderLayout.CENTER
        );


        this.setLookAndFell();


        // @todo beide zeilen zu testzwecken -> loeschen und unter zeile auskommentieren
        this.setPreferredSize(new Dimension(1200, 600));
        this.pack();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);


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

    public CenterSplitPane getCenterSplitPane()
    {
        return this.centerSplitPane;
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