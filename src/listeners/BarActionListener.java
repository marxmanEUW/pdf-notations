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

                newProject();
                break;
            case Constants.BAR_ITEM_OPEN_PROJECT_NAME:

                openProject();
                break;
            case Constants.BAR_ITEM_SAVE_PROJECT_NAME:

                saveProject();
                break;
            case Constants.BAR_ITEM_SAVE_AS_PROJECT_NAME:

                saveAsProject();
                break;
            case Constants.BAR_ITEM_CLOSE_PROJECT_NAME:

                // not implemented jet
                //closeProject();
                break;
            case Constants.BAR_ITEM_CLOSE_NAME:

                closeProgramm();
                break;
            case Constants.BAR_ITEM_ADD_NOTATION_NAME:

                addNotation();
                break;
            case Constants.BAR_ITEM_DELETE_NOTATION_NAME:

                deleteNotation();
                break;
            case Constants.BAR_ITEM_ZOOM_IN_NAME:

                // not implemented jet
                //zoomIn();
                break;
            case Constants.BAR_ITEM_ZOOM_OUT_NAME:

                // not implemented jet
                //zoomOut();
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
            this.getPdfObjectView().importNewProject(newProjectFile);
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
            this.getPdfObjectView().importNewProject(openProjectFile);
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
     * @todo close Projeect
     */
    private void closeProject()
    {

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
        System.exit(0);
    }


    /*
     * @todo implement zoom out button action
     */
    private void zoomOut()
    {

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
