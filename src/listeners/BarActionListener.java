package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

import constants.Environment;
import factories.DialogFactory;
import factories.PdfObjectFactory;
import constants.Labels;
import model.PdfObject;
import threads.PdfRenderThread;
import view.MainFrame;
import view.bar.MainFrameMenuBar;
import view.bar.MainFrameToolBar;
import view.projectView.pdfObjectView.PdfObjectView;
import view.projectView.pdfObjectView.partials.PdfArea;

import javax.swing.*;


public class BarActionListener implements ActionListener {

    private MainFrame mainFrame;


    /*
     * #########################################################################
     * #                    Initialising                                       #
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
            case Labels.BAR_ITEM_NEW_PROJECT_NAME:
                this.newProject();
                break;
            case Labels.BAR_ITEM_OPEN_PROJECT_NAME:
                this.openProject();
                break;
            case Labels.BAR_ITEM_SAVE_PROJECT_NAME:
                this.saveProject();
                break;
            case Labels.BAR_ITEM_SAVE_AS_PROJECT_NAME:
                this.saveAsProject();;
                break;
            case Labels.BAR_ITEM_CLOSE_PROJECT_NAME:
                this.closeProject();
                break;
            case Labels.BAR_ITEM_CLOSE_NAME:
                this.closeProgram();
                break;
            case Labels.BAR_ITEM_ADD_NOTATION_NAME:
                this.addNotation();
                break;
            case Labels.BAR_ITEM_DELETE_NOTATION_NAME:
                this.deleteNotation();
                break;
            case Labels.BAR_ITEM_ZOOM_IN_NAME:
                this.zoomIn();
                break;
            case Labels.BAR_ITEM_ZOOM_OUT_NAME:
                this.zoomOut();
                break;
            case Labels.BAR_ITEM_ABOUT_NAME:
                // not implemented yet
                showAbout();
                break;
        }

        this.updateBars();
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

    private MainFrameMenuBar getMainFrameMenuBar()
    {
        return this.mainFrame.getJMenuBar();
    }

    private MainFrameToolBar getMainFrameToolBar()
    {
        return this.mainFrame.getToolBar();
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    private void newProject()
    {
        File newProjectFile = DialogFactory.getFileFromOpenDialog(
            Environment.FILE_TYPE_PDF
        );

        if (newProjectFile != null)
        {
            this.getPdfObjectView().openProject(newProjectFile);
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
            Environment.FILE_TYPE_PDFNOT
        );

        if (openProjectFile != null)
        {
            this.getPdfObjectView().openProject(openProjectFile);
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
                Environment.FILE_TYPE_PDFNOT
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
            Environment.FILE_TYPE_PDFNOT
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
     */
    private void closeProject()
    {
        int userChoice = DialogFactory.showWarningAtCloseDialog();
        if (userChoice == JOptionPane.YES_OPTION)
        {
            this.getPdfObjectView().closeProject();
        }
    }


    /*
     * @author  marxmanEUW
     */
    private void closeProgram()
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
     */
    private void deleteNotation()
    {
        int userChoice = DialogFactory.showWarningDeleteNotation(
            this.getPdfObject().getSelectedNotationIndex()
        );
        if (userChoice == JOptionPane.YES_OPTION)
        {
            this.getPdfObject().deleteSelectedNotation();
            this.getPdfArea().repaint();
            this.getPdfObjectView().getNotationListScrollPane().updateTable();
        }
    }


    /*
     * @author  yxyxD
     * @changes
     *      2018-02-19 (yxyxD)  created
     * @brief   Increases the zoom of the pdfImage.
     */
    private void zoomIn()
    {
        if (Environment.PDF_RENDER_GROUP.activeCount() >=
            Environment.MAX_RENDER_THREADS) { return; }
        if (!this.getPdfObjectView().getPdfArea().isZoomEnabled()) { return; }

        this.getPdfObjectView().getPdfArea().zoomPdf(
            Environment.ZOOM_IN
        );
    }


    /*
     * @author  yxyxD
     * @changes
     *      2018-02-19 (yxyxD)  created
     * @brief   Decreases the zoom of the pdfImage.
     */
    private void zoomOut()
    {
        if (Environment.PDF_RENDER_GROUP.activeCount() >=
            Environment.MAX_RENDER_THREADS) { return; }
        if (!this.getPdfObjectView().getPdfArea().isZoomEnabled()) { return; }

        this.getPdfObjectView().getPdfArea().zoomPdf(
            Environment.ZOOM_OUT
        );
    }

    /*
     * @author  marxmanEUW
     */
    private void showAbout()
    {
        DialogFactory.showAboutDialog();
    }


    /*
     * @author  yxyxD
     */
    public void updateBars()
    {
        // disable all project depended buttons if no project is loaded
        if (this.getPdfObject() == null)
        {
            this.getMainFrameMenuBar().setMenuItemSaveProjectEnabled(false);
            this.getMainFrameMenuBar().setMenuItemSaveAsProjectEnabled(false);
            this.getMainFrameMenuBar().setMenuItemCloseProjectEnabled(false);

            this.getMainFrameMenuBar().setMenuItemAddNotationEnabled(false);
            this.getMainFrameMenuBar().setMenuItemDeleteNotationEnabled(false);

            this.getMainFrameMenuBar().setMenuItemZoomInEnabled(false);
            this.getMainFrameMenuBar().setMenuItemZoomOutEnabled(false);
        }
        else
        {
            this.getMainFrameMenuBar().setMenuItemSaveProjectEnabled(true);
            this.getMainFrameMenuBar().setMenuItemSaveAsProjectEnabled(true);
            this.getMainFrameMenuBar().setMenuItemCloseProjectEnabled(true);

            this.getMainFrameMenuBar().setMenuItemAddNotationEnabled(true);
            this.getMainFrameMenuBar().setMenuItemDeleteNotationEnabled(true);

            this.getMainFrameMenuBar().setMenuItemZoomInEnabled(true);
            this.getMainFrameMenuBar().setMenuItemZoomOutEnabled(true);
        }

        if (this.getPdfObject() == null)
        {
            this.getMainFrameToolBar().setButtonSaveProjectEnabled(false);
            this.getMainFrameToolBar().setButtonSaveAsProjectEnabled(false);
            this.getMainFrameToolBar().setButtonCloseProjectEnabled(false);

            this.getMainFrameToolBar().setButtonZoomOutEnabled(false);
            this.getMainFrameToolBar().setButtonZoomInEnabled(false);

            this.getMainFrameToolBar().setButtonAddNotationEnabled(false);
        }
        else
        {
            this.getMainFrameToolBar().setButtonSaveProjectEnabled(true);
            this.getMainFrameToolBar().setButtonSaveAsProjectEnabled(true);
            this.getMainFrameToolBar().setButtonCloseProjectEnabled(true);

            this.getMainFrameToolBar().setButtonZoomOutEnabled(true);
            this.getMainFrameToolBar().setButtonZoomInEnabled(true);

            this.getMainFrameToolBar().setButtonAddNotationEnabled(true);
        }
    }
}
