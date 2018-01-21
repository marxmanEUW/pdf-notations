package view;

import listeners.MenuBarActionListener;
import gui.Constants;
import model.ProjectCon;
import view.partials.CenterSplitPane;
import view.partials.MainFrameMenuBar;
import view.partials.partials.PdfArea;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JMenuBar menuBar;
    private MenuBarActionListener mbActionListener;

    public CenterSplitPane centerSplitPane;

    private ProjectCon projectCon;
    /*
     * Arbeitsflaechen des CENTERs
     */
    private PdfArea pdfArea;


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public PdfArea getPdfArea()
    {
        return this.pdfArea;
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    public void initialize(ProjectCon projectCon)
    {
        this.projectCon = projectCon;
        // commented out for better performance
        //this.setLookAndFell();

        this.mbActionListener = new MenuBarActionListener();

        this.setLayout(new BorderLayout());
        this.pdfArea = new PdfArea(this.projectCon);

        this.mbActionListener.initialize(this.projectCon,pdfArea);

        this.createMainFrame();
        this.setFrameProperties();
    }

    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */

    public void updateNotationList(){
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
    private void createMainFrame()
    {
        this.menuBar = new MainFrameMenuBar(this.mbActionListener);
        this.setJMenuBar(this.menuBar);

        this.centerSplitPane = new CenterSplitPane(this.projectCon);
        this.getContentPane().add(this.centerSplitPane, BorderLayout.CENTER);

        /*
        this.getContentPane().add(
            FrameCenterFactory.createAndReturnFrameCenterComponent(this),
            BorderLayout.CENTER
        );
        */

    }

    private void setFrameProperties()
    {
        this.setTitle(Constants.FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // @todo beide zeilen zu testzwecken -> loeschen und unter zeile auskommentieren
        this.setPreferredSize(new Dimension(1200, 600));
        this.pack();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);


        this.setVisible(true);
    }

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