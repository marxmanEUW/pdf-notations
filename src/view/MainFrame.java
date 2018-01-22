package view;

import listeners.MenuBarActionListener;
import gui.Constants;
import model.ProjectCon;
import view.partials.CenterSplitPane;
import view.partials.MainFrameMenuBar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainFrameMenuBar menuBar;
    private MenuBarActionListener mbActionListener;
    public CenterSplitPane centerSplitPane;

    private ProjectCon projectCon;


    public MainFrame()
    {
        this.menuBar = new MainFrameMenuBar();
        this.mbActionListener = new MenuBarActionListener();
        this.centerSplitPane = new CenterSplitPane();
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
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    public void initialize(ProjectCon projectCon)
    {
        this.projectCon = projectCon;

        this.setLayout(new BorderLayout());

        this.menuBar.initialize(this.mbActionListener);
        this.centerSplitPane.initialize(this.projectCon);
        //this.mbActionListener.initialize(this.projectCon,pdfArea);

        this.setJMenuBar(this.menuBar);
        this.getContentPane().add(
            this.centerSplitPane,
            BorderLayout.CENTER
        );


        this.setLookAndFell();


        this.setTitle(Constants.FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // @todo beide zeilen zu testzwecken -> loeschen und unter zeile auskommentieren
        this.setPreferredSize(new Dimension(1200, 600));
        this.pack();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);


        this.setVisible(true);
    }

    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */
    public void updateNotationList()
    {
        this.centerSplitPane.updateNotationList();
    }

    public void updateNotationEntityTable()
    {
        this.centerSplitPane.updateNotationEntityTable();
    }

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