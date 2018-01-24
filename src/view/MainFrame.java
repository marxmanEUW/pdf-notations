package view;

import listeners.MenuBarActionListener;
import gui.Constants;
import model.PdfObject;
import view.bar.MainFrameMenuBar;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainFrameMenuBar menuBar;
    private MenuBarActionListener mbActionListener;

    private PdfObjectView pdfObjectView;
    private PdfObject pdfObject;

    //private Project project;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public MainFrame()
    {
        this.setLayout(new BorderLayout());
        this.setTitle(Constants.FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // @todo beide zeilen zu testzwecken -> loeschen und unter zeile auskommentieren
        this.setPreferredSize(new Dimension(1200, 600));
        this.pack();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);



        this.menuBar = new MainFrameMenuBar();
        this.mbActionListener = new MenuBarActionListener();

        this.pdfObjectView = new PdfObjectView();
        this.pdfObject = new PdfObject();

        //this.project = new Project();
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    public void initialize(/*Project project*/)
    {
        //this.project = project;

        this.menuBar.initialize(this.mbActionListener);
        /*
         * @todo -> marxmanEUW: we decided not to use the Project-model at all
         */
        //this.mbActionListener.initialize(this.project);
        //this.pdfObject.setSourePath(Launcher.PATH_TO_PDF1);
        this.pdfObjectView.initialize(this.pdfObject);


        this.setJMenuBar(this.menuBar);
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
     * @author  yxyxD
     */
    public void importNewPdf(String sourcePath)
    {
        this.pdfObject = new PdfObject();


        //this.pdfObjectView.initialize(this.project.getPdfObject());
        //this.pdfObjectView.updateView();

        this.getContentPane().remove(this.pdfObjectView);
        this.pdfObjectView = new PdfObjectView();
        this.pdfObject.setSourePath(sourcePath);

        this.initialize();
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