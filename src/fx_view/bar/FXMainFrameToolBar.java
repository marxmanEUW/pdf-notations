package fx_view.bar;

import constants.Labels;
import fx_handler.FXBarActionHandler;

import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class FXMainFrameToolBar extends ToolBar {

    private Button buttonNewProject;
    private Button buttonOpenProject;
    private Button buttonSaveProject;
    private Button buttonSaveAsProject;
    private Button buttonCloseProject;

    private Button buttonZoomIn;
    private Button buttonZoomOut;

    private Button buttonAddNotation;

    private FXBarActionHandler barActionHandler;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public FXMainFrameToolBar()
    {
        this.buttonNewProject = new Button();
        this.buttonOpenProject = new Button();
        this.buttonSaveProject = new Button();
        this.buttonSaveAsProject = new Button();
        this.buttonCloseProject = new Button();

        this.buttonZoomIn = new Button();
        this.buttonZoomOut = new Button();

        this.buttonAddNotation = new Button();
    }


    /*
     * #########################################################################
     * #                    Initialising                                       #
     * #########################################################################
     */
    public void initialize(FXBarActionHandler barActionHandler)
    {
        this.barActionHandler = barActionHandler;


        // ActionCommand

        this.buttonNewProject.setId(Labels.BAR_ITEM_NEW_PROJECT_NAME);
        this.buttonOpenProject.setId(Labels.BAR_ITEM_OPEN_PROJECT_NAME);
        this.buttonSaveProject.setId(Labels.BAR_ITEM_SAVE_PROJECT_NAME);
        this.buttonSaveAsProject.setId(Labels.BAR_ITEM_SAVE_AS_PROJECT_NAME);
        this.buttonCloseProject.setId(Labels.BAR_ITEM_CLOSE_PROJECT_NAME);

        this.buttonZoomOut.setId(Labels.BAR_ITEM_ZOOM_OUT_NAME);
        this.buttonZoomIn.setId(Labels.BAR_ITEM_ZOOM_IN_NAME);

        this.buttonAddNotation.setId(Labels.BAR_ITEM_ADD_NOTATION_NAME);


        // Image
        this.buttonNewProject.setGraphic(new ImageView(
            new Image(Labels.TOOLBAR_BUTTON_NEW_PROJECT_ICON_PATH))
        );
        this.buttonOpenProject.setGraphic(new ImageView(
            new Image(Labels.TOOLBAR_BUTTON_OPEN_PROJECT_ICON_PATH)
        ));
        this.buttonSaveProject.setGraphic(new ImageView(
            new Image(Labels.TOOLBAR_BUTTON_SAVE_PROJECT_ICON_PATH)
        ));
        this.buttonSaveAsProject.setGraphic(new ImageView(
            new Image(Labels.TOOLBAR_BUTTON_SAVE_AS_PROJECT_ICON_PATH)
        ));
        this.buttonCloseProject.setGraphic(new ImageView(
            new Image(Labels.TOOLBAR_BUTTON_CLOSE_PROJECT_ICON_PATH)
        ));

        this.buttonZoomOut.setGraphic(new ImageView(
            new Image(Labels.TOOLBAR_BUTTON_ZOOM_OUT_ICON_PATH)
        ));
        this.buttonZoomIn.setGraphic(new ImageView(
            new Image(Labels.TOOLBAR_BUTTON_ZOOM_IN_ICON_PATH)
        ));

        this.buttonAddNotation.setGraphic(new ImageView(
            new Image(Labels.TOOLBAR_BUTTON_ADD_NOTATION_ICON_PATH)
        ));

        // Action Listener
        this.buttonNewProject.setOnAction(this.barActionHandler);
        this.buttonOpenProject.setOnAction(this.barActionHandler);
        this.buttonSaveProject.setOnAction(this.barActionHandler);
        this.buttonSaveAsProject.setOnAction(this.barActionHandler);
        this.buttonCloseProject.setOnAction(this.barActionHandler);

        this.buttonZoomOut.setOnAction(this.barActionHandler);
        this.buttonZoomIn.setOnAction(this.barActionHandler);

        this.buttonAddNotation.setOnAction(this.barActionHandler);

        // add
        this.getItems().add(this.buttonNewProject);
        this.getItems().add(this.buttonOpenProject);
        this.getItems().add(this.buttonSaveProject);
        this.getItems().add(this.buttonSaveAsProject);
        this.getItems().add(this.buttonCloseProject);

        this.getItems().add(new Separator());

        this.getItems().add(this.buttonZoomOut);
        this.getItems().add(this.buttonZoomIn);

        this.getItems().add(new Separator());

        this.getItems().add(this.buttonAddNotation);
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void setButtonSaveProjectEnabled(boolean enabled)
    {
        this.buttonSaveProject.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setButtonSaveAsProjectEnabled(boolean enabled)
    {
        this.buttonSaveAsProject.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setButtonCloseProjectEnabled(boolean enabled)
    {
        this.buttonCloseProject.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setButtonZoomInEnabled(boolean enabled)
    {
        this.buttonZoomIn.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setButtonZoomOutEnabled(boolean enabled)
    {
        this.buttonZoomOut.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setButtonAddNotationEnabled(boolean enabled)
    {
        this.buttonAddNotation.setDisable(!enabled);
    }
}
