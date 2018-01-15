package gui;

import factories.FrameCenterFactory;
import gui.partials.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JMenuBar menuBar;

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
    public void initialize()
    {
        this.setLayout(new BorderLayout());
        this.pdfArea = new PdfArea();


        this.createMainFrame();
        this.setFrameProperties();
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
    private void createMainFrame()
    {
        this.menuBar = new MainFrameMenuBar();
        this.setJMenuBar(this.menuBar);
        //this.setJMenuBar(
        //    MenuBarFactory.createAndReturnMenuBarForMainFrame()
        //);



        this.getContentPane().add(
            FrameCenterFactory.createAndReturnFrameCenterComponent(this),
            BorderLayout.CENTER
        );

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
}