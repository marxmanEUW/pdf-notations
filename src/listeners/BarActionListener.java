package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;

import factories.DialogFactory;
import factories.PdfObjectFactory;
import gui.Constants;
import model.PdfObject;
import view.MainFrame;
import view.projectView.pdfObjectView.PdfObjectView;
import view.projectView.pdfObjectView.partials.PdfArea;

import javax.swing.*;


public class BarActionListener implements ActionListener {

    /*
     * @todo zoomsteps in eingene klasse auslagern
     */
    private static final double ZOOM_IN = 0.1;
    private static final double ZOOM_OUT = -0.1;

    private PdfObjectView pdfObjectView;
    private static String ABOUT_TITLE = "PDF Notations";
    private static String ABOUT_TEXT =
        "https://github.com/marxmanEUW/pdf-notations\n" +
            "Lizenz: GPL v3\n" +
            "Icons von [Keyamoon] (https://icomoon.io/#icons-icomoon) - GPL v3"
        ;

    private MainFrame mainFrame;


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void initialize(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()) {
            case Constants.BAR_ITEM_NEW_PROJECT_NAME:

                this.newProject();
                break;
            case Constants.BAR_ITEM_OPEN_PROJECT_NAME:

                this.openProject();
                break;
            case Constants.BAR_ITEM_SAVE_PROJECT_NAME:

                this.saveProject();
                break;
            case Constants.BAR_ITEM_SAVE_AS_PROJECT_NAME:

                this.saveAsProject();
                break;
            case Constants.BAR_ITEM_CLOSE_PROJECT_NAME:

                // not implemented yet
                this.closeProject();
                break;
            case Constants.BAR_ITEM_CLOSE_NAME:

                this.closeProgramm();
                break;
            case Constants.BAR_ITEM_ADD_NOTATION_NAME:

                this.addNotation();
                break;
            case Constants.BAR_ITEM_DELETE_NOTATION_NAME:

                this.deleteNotation();
                break;
            case Constants.BAR_ITEM_ZOOM_IN_NAME:

                // not implemented jet
                this.zoomIn();
                break;
            case Constants.BAR_ITEM_ZOOM_OUT_NAME:

                // not implemented jet
                this.zoomOut();
                break;
            case Constants.BAR_ITEM_ABOUT_NAME:

                // not implemented jet
                showAbout();
                break;
        }
    }

    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    private PdfObjectView getPdfObjectView()
    {
        return this.mainFrame.getPdfObjectView();
    }

    /*
     * @author  marxmanEUW
     */
    private PdfObject getPdfObject()
    {
        return this.getPdfObjectView().getPdfObject();
    }

    /*
     * @author  marxmanEUW
     */
    private PdfArea getPdfArea()
    {
        return this.getPdfObjectView().getPdfArea();
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    private void newProject()
    {
        File newProjectFile = DialogFactory.getFileFromOpenDialog(
            DialogFactory.FILE_TYPE_PDF
        );

        if (newProjectFile != null)
        {
            this.pdfObjectView.openProject(newProjectFile);
            System.out.println(
                "Neues Projekt mit gegebener PDF: "
                    + newProjectFile.getAbsolutePath()
                    + " erstellt"
            );

        }
    }


    /*
     * @author  marxmanEUW
     */
    private void openProject()
    {
        File openProjectFile = DialogFactory.getFileFromOpenDialog(
            DialogFactory.FILE_TYPE_PDFNOT
        );

        if (openProjectFile != null)
        {
            this.pdfObjectView.openProject(openProjectFile);
            System.out.println(
                "Vorhandenes Projekt mit gegebener PDF "
                    + openProjectFile.getAbsolutePath()
                    + " erstellt"
            );
            this.getPdfObjectView().openProject(openProjectFile);
        }
    }


    /*
     * @author  marxmanEUW
     */
    private void saveProject()
    {
        if (this.getPdfObject().getJsonAbsolutePath() != null)
        {
            PdfObjectFactory.savePdfObjectForPdfFile(this.getPdfObject());
        }
        else
        {
            File saveFile = DialogFactory.getFileFromSaveDialog(
                DialogFactory.FILE_TYPE_PDFNOT
            );

            if (saveFile != null)
            {
                this.getPdfObject().setJsonAbsolutePath(
                    saveFile.getAbsolutePath()
                );

                PdfObjectFactory.savePdfObjectForPdfFile(this.getPdfObject());
            }
        }
    }


    /*
     * @author  marxmanEUW
     */
    private void saveAsProject()
    {
        File saveAsFile = DialogFactory.getFileFromSaveDialog(
            DialogFactory.FILE_TYPE_PDFNOT
        );
        if (saveAsFile != null)
        {
            this.getPdfObject().setJsonAbsolutePath(
                saveAsFile.getAbsolutePath()
            );
            PdfObjectFactory.savePdfObjectForPdfFile(this.getPdfObject());
        }
    }


    /*
     * @author  marxmanEUW
     * @todo close Project
     * @note    yxyxD => implemented code to close project
     */
    private void closeProject()
    {
        this.getPdfObjectView().closeProject();
    }


    /*
     * @author  marxmanEUW
     * @todo Warnung anzeigen, dass alle nicht gespeicherten Änderungen verloren gehen
     */
    private void closeProgramm()
    {
        this.mainFrame.dispatchEvent(
            new WindowEvent(
                this.mainFrame,
                WindowEvent.WINDOW_CLOSING
            )
        );
    }


    /*
     * @author  marxmanEUW
     */
    private void addNotation()
    {
        this.getPdfArea().setAddingNotation(true);
        this.getPdfArea().setCursorTypeToCrosshair();
    }


    /*
     * @author  marxmanEUW
     * @todo delete multiple Notations
     */
    private void deleteNotation()
    {
        this.getPdfObject().deleteSelectedNotation();
        this.getPdfArea().repaint();
        this.getPdfObjectView().getNotationListScrollPane().updateTable();
    }


    /*
     * @todo implement zoom in button action
     */
    private void zoomIn()
    {
        this.getPdfObjectView().getPdfArea().resizePdf(BarActionListener.ZOOM_IN);
    }


    /*
     * @todo implement zoom out button action
     */
    private void zoomOut()
    {
        this.getPdfObjectView().getPdfArea().resizePdf(BarActionListener.ZOOM_OUT);
    }

    /*
     * @author  marxmanEUW
     * @todo show About
     */
    private void showAbout()
    {
        JOptionPane.showMessageDialog(
            this.mainFrame,
            ABOUT_TEXT,
            ABOUT_TITLE,
            JOptionPane.PLAIN_MESSAGE
        );
    }
}
