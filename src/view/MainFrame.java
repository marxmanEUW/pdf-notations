package view;

import listeners.MenuBarActionListener;
import gui.Constants;
import model.PdfObject;
import model.Project;
import view.bar.MainFrameMenuBar;
import view.project_view.pdfobject_view.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainFrameMenuBar menuBar;
    private MenuBarActionListener mbActionListener;

    private PdfObjectView pdfObjectView;

    private Project project;


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

        this.project = new Project();
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
        this.mbActionListener.initialize(this.project);
        this.pdfObjectView.initialize(this.project.getPdfObject());


        this.setJMenuBar(this.menuBar);

        this.getContentPane().removeAll();
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
        PdfObject pdfObject = new PdfObject();
        pdfObject.setSourePath(sourcePath);
        this.project.setPdfObject(pdfObject);


        //this.pdfObjectView.initialize(this.project.getPdfObject());
        //this.pdfObjectView.updateView();

        this.initialize(this.project);
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