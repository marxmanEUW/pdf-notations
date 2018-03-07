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
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   initializes the Bar Action Listener.
     */
    public void initialize(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfObjectView.
     */
    private PdfObjectView getPdfObjectView()
    {
        return this.mainFrame.getPdfObjectView();
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfObject of the PdfObjectView.
     */
    private PdfObject getPdfObject()
    {
        return this.getPdfObjectView().getPdfObject();
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfArea of the PdfObjectView.
     */
    private PdfArea getPdfArea()
    {
        return this.getPdfObjectView().getPdfArea();
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the MenuBar of the MainFrame.
     */
    private MainFrameMenuBar getMainFrameMenuBar()
    {
        return this.mainFrame.getJMenuBar();
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the ToolBar of the MainFrame.
     */
    private MainFrameToolBar getMainFrameToolBar()
    {
        return this.mainFrame.getToolBar();
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Distinguishes which button was pressed.
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
                this.saveAsProject();
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
                showAbout();
                break;
        }

        this.updateBars();
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Gets selected PDF-file from an OpenFileDialog and sends it to
     *          the PdfObjectView to create a new project.
     */
    private void newProject()
    {
        File newProjectFile = DialogFactory.getFileFromOpenDialog(
            Environment.FILE_TYPE_PDF
        );

        if (newProjectFile != null)
        {
            this.getPdfObjectView().openProject(newProjectFile);
        }
    }


    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Gets selected pdfnot-file from an OpenFileDialog and sends it to
     *          the PdfObjectView to open a project.
     */
    private void openProject()
    {
        File openProjectFile = DialogFactory.getFileFromOpenDialog(
            Environment.FILE_TYPE_PDFNOT
        );

        if (openProjectFile != null)
        {
            this.getPdfObjectView().openProject(openProjectFile);
        }
    }


    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Saves the project. If JsonAbsolutePath is not set, it prompts
     *          the user to set it.
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
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Gets new pdfnot-FileLocation and saves Poject to this file.
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
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Closes the project.
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
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Closes the program.
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
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets some variables. The next click into the PdfArea creates a
     *          new Notation.
     */
    private void addNotation()
    {
        this.getPdfArea().setAddingNotation(true);
        this.getPdfArea().setCursorTypeToCrossHair();
    }


    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Asks the user if he wants to delete the selected notation.
     *          Deletes the selected Notation if answer was "yes".
     */
    private void deleteNotation()
    {
        int selectedNotationId = this.getPdfObject().getSelectedNotationId();
        if (selectedNotationId == Environment.SELECTED_NOTATION_NULL_VALUE)
        {
            return;
        }

        int userChoice = DialogFactory.showWarningDeleteNotation(
            selectedNotationId
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
        if (this.getPdfObjectView().getPdfArea().isZoomDisabled()) { return; }

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
        if (this.getPdfObjectView().getPdfArea().isZoomDisabled()) { return; }

        this.getPdfObjectView().getPdfArea().zoomPdf(
            Environment.ZOOM_OUT
        );
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Shw AboutDialog.
     */
    private void showAbout()
    {
        DialogFactory.showAboutDialog();
    }


    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Updates the menu bar and tool bar by disabling the buttons that
     *          can not be pressed anymore or enabling the buttons that could
     *          not be pressed before.
     */
    public void updateBars()
    {
        // disable all project related buttons in menu bar if no project is
        // loaded
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

        // disable all project related buttons in tool bar if no project is
        // loaded
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
