package fx_handler;

import constants.Labels;
import fx_threads.FXPdfRenderTask;
import fx_view.*;
import fx_view.bar.*;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

import java.io.File;


public class FXBarActionHandler implements EventHandler<ActionEvent> {

    private FXMainFrame mainFrame;


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
                System.out.println("Neues Projekt");
                //this.newProject();
                break;
            case Labels.BAR_ITEM_OPEN_PROJECT_NAME:
                System.out.println("Öffnen Projekt");
                this.mainFrame.getPdfObjectView().openProject(new File("files/file1.pdf"));
                //this.openProject();
                break;
            case Labels.BAR_ITEM_SAVE_PROJECT_NAME:
                System.out.println("Speichern Projekt");
                //this.saveProject();
                break;
            case Labels.BAR_ITEM_SAVE_AS_PROJECT_NAME:
                System.out.println("Speichern unter Projekt");
                //this.saveAsProject();;
                break;
            case Labels.BAR_ITEM_CLOSE_PROJECT_NAME:
                System.out.println("Schließen Projekt");
                //this.closeProject();
                break;
            case Labels.BAR_ITEM_CLOSE_NAME:
                System.out.println("Schließen Programm");
                //this.closeProgram();
                break;
            case Labels.BAR_ITEM_ADD_NOTATION_NAME:
                System.out.println("Hinzufügen Notation");
                //this.addNotation();
                break;
            case Labels.BAR_ITEM_DELETE_NOTATION_NAME:
                System.out.println("Löschen Notation");
                //this.deleteNotation();
                break;
            case Labels.BAR_ITEM_ZOOM_IN_NAME:
                System.out.println("Zoom In");
                //this.zoomIn();
                break;
            case Labels.BAR_ITEM_ZOOM_OUT_NAME:
                System.out.println("Zoom Out");
                //this.zoomOut();
                break;
            case Labels.BAR_ITEM_ABOUT_NAME:
                System.out.println("About");
                //showAbout();
                break;
        }

        //this.updateBars();

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
     * @todo implement
     */
    private void getPdfObject()
    {
        //return this.getPdfObjectView().getPdfObject();
    }

    /*
     * @author  marxmanEUW
     * @todo implement
     */
    private void getPdfArea()
    {
        //return this.getPdfObjectView().getPdfArea();
    }

    private FXMainFrameMenuBar getMainFrameMenuBar()
    {
        return this.mainFrame.getJMenuBar();
    }

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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
    private void addNotation()
    {
        this.getPdfArea().setAddingNotation(true);
        this.getPdfArea().setCursorTypeToCrosshair();
    }


    /*
     * @author  marxmanEUW
     *
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
     *
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
     *
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
     *
    private void showAbout()
    {
        DialogFactory.showAboutDialog();
    }


    /*
     * @author  yxyxD
     *
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
    */
}
