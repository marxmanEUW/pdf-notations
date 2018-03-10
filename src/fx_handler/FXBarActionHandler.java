package fx_handler;

import constants.Environment;
import constants.Labels;
import factories.FXDialogFactory;
import factories.PdfObjectFactory;
import fx_view.*;
import fx_view.bar.*;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import fx_view.projectView.pdfObjectView.partials.FXPdfArea;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import model.PdfObject;

import java.io.File;
import java.util.Optional;


public class FXBarActionHandler implements EventHandler<ActionEvent> {

    private FXMainFrame mainFrame;
    private FXHyperlinkChangeListener hyperlinkChangeListener;

    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void initialize(FXMainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        this.hyperlinkChangeListener = this.mainFrame.getHyperlinkChangeListener();
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
    public void handle(ActionEvent e)
    {
        String identifier = "";

        if (e.getSource().getClass() == MenuItem.class)
        {
            MenuItem menuItem = (MenuItem) e.getSource();
            identifier = menuItem.getText();
        }
        else if (e.getSource().getClass() == Button.class)
        {
            Button button = (Button) e.getSource();
            identifier = button.getId();
        }

        switch (identifier) {
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
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    private FXPdfObjectView getPdfObjectView()
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
    private FXPdfArea getPdfArea()
    {
        return this.getPdfObjectView().getPdfArea();
    }

    /*
     * @author  yxyxD
     */
    private FXMainFrameMenuBar getMainFrameMenuBar()
    {
        return this.mainFrame.getJMenuBar();
    }

    /*
     * @author  yxyxD
     */
    private FXMainFrameToolBar getMainFrameToolBar()
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
        File newProjectFile = FXDialogFactory.getFileFromOpenDialog(
            Environment.FILE_TYPE_PDF,
            this.mainFrame
        );

        if (newProjectFile != null)
        {
            this.getPdfObjectView().openProject(newProjectFile);
        }
    }


    /*
     * @author  marxmanEUW
     */
    private void openProject()
    {
        File openProjectFile = FXDialogFactory.getFileFromOpenDialog(
            Environment.FILE_TYPE_PDFNOT,
            this.mainFrame
        );

        if (openProjectFile != null)
        {
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
            File saveFile = FXDialogFactory.getFileFromSaveDialog(
                Environment.FILE_TYPE_PDFNOT,
                this.mainFrame
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
        File saveAsFile = FXDialogFactory.getFileFromSaveDialog(
            Environment.FILE_TYPE_PDFNOT,
            this.mainFrame
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
        Optional<ButtonType> userChoice = FXDialogFactory.showWarningAtCloseDialog();
        if ((userChoice.isPresent()) && (userChoice.get() == ButtonType.OK))
        {
            this.getPdfObjectView().closeProject();
        }
    }


    /*
     * @author  marxmanEUW
     */
    private void closeProgram()
    {
        Optional<ButtonType> userChoice = FXDialogFactory.showWarningAtCloseDialog();
        if ((userChoice.isPresent()) && (userChoice.get() == ButtonType.OK))
        {
            this.mainFrame.getWindow().close();
        }
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
        int selectedNotationId = this.getPdfObject().getSelectedNotationId();
        if (selectedNotationId == Environment.SELECTED_NOTATION_NULL_VALUE)
        {
            return;
        }

        Optional<ButtonType> userChoice = FXDialogFactory.showWarningDeleteNotation(
            selectedNotationId
        );
        if ((userChoice.isPresent()) && (userChoice.get() == ButtonType.OK))
        {
            this.getPdfObject().deleteSelectedNotation();
            this.getPdfArea().repaintNotations();
            //this.getPdfObjectView().getNotationListTableView().updateTable();
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
        this.getPdfObjectView().getPdfArea().zoomPdf(
            Environment.ZOOM_OUT
        );
    }

    /*
     * @author  marxmanEUW
     */
    private void showAbout()
    {
        FXDialogFactory.showAboutDialog(this.hyperlinkChangeListener);
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
