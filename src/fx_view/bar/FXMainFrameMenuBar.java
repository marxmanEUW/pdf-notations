package fx_view.bar;

import constants.FXKeyStrokes;
import constants.Labels;
import fx_listener.FXBarActionListener;
import javafx.scene.control.*;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class FXMainFrameMenuBar extends MenuBar {

    // "File"-menu
    private Menu menuFile;
    private MenuItem menuItemNewProject;
    private MenuItem menuItemOpenProject;
    private MenuItem menuItemSaveProject;
    private MenuItem menuItemSaveAsProject;
    private MenuItem menuItemCloseProject;
    private MenuItem menuItemClose;

    // "Notation"-menu
    private Menu menuNotation;
    private MenuItem menuItemAddNotation;
    private MenuItem menuItemDeleteNotation;

    // "View"-menu
    private Menu menuView;
    private MenuItem menuItemZoomIn;
    private MenuItem menuItemZoomOut;

    // "Help"-menu
    private Menu menuHelp;
    private MenuItem menuItemAbout;

    // Listener
    private FXBarActionListener barActionListener;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public FXMainFrameMenuBar()
    {
        this.menuFile = new Menu();
        this.menuItemNewProject = new MenuItem();
        this.menuItemOpenProject = new MenuItem();
        this.menuItemSaveProject = new MenuItem();
        this.menuItemSaveAsProject = new MenuItem();
        this.menuItemCloseProject = new MenuItem();
        this.menuItemClose = new MenuItem();

        this.menuNotation = new Menu();
        this.menuItemAddNotation = new MenuItem();
        this.menuItemDeleteNotation = new MenuItem();

        this.menuView = new Menu();
        this.menuItemZoomIn = new MenuItem();
        this.menuItemZoomOut = new MenuItem();

        this.menuHelp = new Menu();
        this.menuItemAbout = new MenuItem();
    }


    /*
     * #########################################################################
     * #                    Initialising                                       #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void initialize(FXBarActionListener barActionListener)
    {
        this.barActionListener = barActionListener;

        this.setupMenuFile();
        this.setupMenuNotation();
        this.setupMenuView();
        this.setupMenuHelp();

        // @todo implement
        //this.barActionListener.updateBars();
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    // @todo check if disable works as it should
    /*
     * @author  yxyxD
     */
    public void setMenuItemNewProjectEnabled(boolean enabled)
    {
        this.menuItemNewProject.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemOpenProjectEnabled(boolean enabled)
    {
        this.menuItemOpenProject.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemSaveProjectEnabled(boolean enabled)
    {
        this.menuItemSaveProject.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemSaveAsProjectEnabled(boolean enabled)
    {
        this.menuItemSaveAsProject.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemCloseProjectEnabled(boolean enabled)
    {
        this.menuItemCloseProject.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemCloseEnabled(boolean enabled)
    {
        this.menuItemClose.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemAddNotationEnabled(boolean enabled)
    {
        this.menuItemAddNotation.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemDeleteNotationEnabled(boolean enabled)
    {
        this.menuItemDeleteNotation.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemZoomInEnabled(boolean enabled)
    {
        this.menuItemZoomIn.setDisable(!enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemZoomOutEnabled(boolean enabled)
    {
        this.menuItemZoomOut.setDisable(!enabled);
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    private void setupMenuFile()
    {
        // Text des Menues und der Menuepunkte
        this.menuFile.setText(Labels.MENU_FILE_NAME);
        this.menuItemNewProject.setText(Labels.BAR_ITEM_NEW_PROJECT_NAME);
        this.menuItemOpenProject.setText(Labels.BAR_ITEM_OPEN_PROJECT_NAME);
        this.menuItemSaveProject.setText(Labels.BAR_ITEM_SAVE_PROJECT_NAME);
        this.menuItemSaveAsProject.setText(Labels.BAR_ITEM_SAVE_AS_PROJECT_NAME);
        this.menuItemCloseProject.setText(Labels.BAR_ITEM_CLOSE_PROJECT_NAME);
        this.menuItemClose.setText(Labels.BAR_ITEM_CLOSE_NAME);

        // ActionListener
        this.menuItemNewProject.setOnAction(this.barActionListener);
        this.menuItemOpenProject.setOnAction(this.barActionListener);
        this.menuItemSaveProject.setOnAction(this.barActionListener);
        this.menuItemSaveAsProject.setOnAction(this.barActionListener);
        this.menuItemCloseProject.setOnAction(this.barActionListener);
        this.menuItemClose.setOnAction(this.barActionListener);


        //Shortcuts
        this.menuItemNewProject.setAccelerator(new KeyCodeCombination(
            FXKeyStrokes.BAR_ITEM_NEW_PROJECT_KEY_STROKE,
            KeyCombination.CONTROL_DOWN
        ));
        this.menuItemOpenProject.setAccelerator(new KeyCodeCombination(
            FXKeyStrokes.BAR_ITEM_OPEN_PROJECT_KEY_STROKE,
            KeyCombination.CONTROL_DOWN
        ));
        this.menuItemSaveProject.setAccelerator(new KeyCodeCombination(
            FXKeyStrokes.BAR_ITEM_SAVE_PROJECT_KEY_STROKE,
            KeyCombination.CONTROL_DOWN
        ));
        this.menuItemSaveAsProject.setAccelerator(new KeyCodeCombination(
            FXKeyStrokes.BAR_ITEM_SAVE_AS_PROJECT_KEY_STROKE,
            KeyCombination.CONTROL_DOWN,
            KeyCombination.SHIFT_DOWN
        ));
        this.menuItemCloseProject.setAccelerator(new KeyCodeCombination(
            FXKeyStrokes.BAR_ITEM_CLOSE_PROJECT_KEY_STROKE,
            KeyCombination.CONTROL_DOWN
        ));
        this.menuItemClose.setAccelerator(new KeyCodeCombination(
            FXKeyStrokes.BAR_ITEM_CLOSE_KEY_STROKE,
            KeyCombination.ALT_DOWN
        ));



        // Menuepunkte zum Menue hinzufuegen
        this.menuFile.getItems().add(this.menuItemNewProject);
        this.menuFile.getItems().add(this.menuItemOpenProject);
        this.menuFile.getItems().add(this.menuItemSaveProject);
        this.menuFile.getItems().add(this.menuItemSaveAsProject);
        this.menuFile.getItems().add(this.menuItemCloseProject);
        this.menuFile.getItems().add(new SeparatorMenuItem());
        this.menuFile.getItems().add(this.menuItemClose);

        this.getMenus().add(this.menuFile);
    }


    /*
     * @author  yxyxD
     */
    private void setupMenuNotation()
    {
        // Text des Menues und der Menuepunkte
        this.menuNotation.setText(Labels.MENU_NOTATION_NAME);
        this.menuItemAddNotation.setText(Labels.BAR_ITEM_ADD_NOTATION_NAME);
        this.menuItemDeleteNotation.setText(Labels.BAR_ITEM_DELETE_NOTATION_NAME);

        // ActionListener
        this.menuItemAddNotation.setOnAction(this.barActionListener);
        this.menuItemDeleteNotation.setOnAction(this.barActionListener);

        // Shortcuts
        this.menuItemAddNotation.setAccelerator(new KeyCodeCombination(
            FXKeyStrokes.BAR_ITEM_ADD_NOTATION_KEY_STROKE,
            KeyCombination.CONTROL_DOWN
        ));
        this.menuItemDeleteNotation.setAccelerator(new KeyCodeCombination(
            FXKeyStrokes.BAR_ITEM_DELETE_NOTATION_KEY_STROKE,
            KeyCombination.CONTROL_DOWN
        ));

        // Menuepunkte zum Menue hinzufuegen
        this.menuNotation.getItems().add(this.menuItemAddNotation);
        this.menuNotation.getItems().add(this.menuItemDeleteNotation);

        this.getMenus().add(this.menuNotation);
    }


    /*
     * @author  marxmanEUW
     */
    private void setupMenuView()
    {
        // Text des Menues und der Menuepunkte
        this.menuView.setText(Labels.MENU_VIEW_NAME);
        this.menuItemZoomIn.setText(Labels.BAR_ITEM_ZOOM_IN_NAME);
        this.menuItemZoomOut.setText(Labels.BAR_ITEM_ZOOM_OUT_NAME);


        // ActionListener
        this.menuItemZoomIn.setOnAction(this.barActionListener);
        this.menuItemZoomOut.setOnAction(this.barActionListener);


        //Shortcuts
        this.menuItemZoomIn.setAccelerator(new KeyCodeCombination(
            FXKeyStrokes.BAR_ITEM_ZOOM_IN_KEY_STROKE,
            KeyCombination.CONTROL_DOWN
        ));
        this.menuItemZoomOut.setAccelerator(new KeyCodeCombination(
            FXKeyStrokes.BAR_ITEM_ZOOM_OUT_KEY_STROKE,
            KeyCombination.CONTROL_DOWN
        ));

        // Menuepunkte zum Menue hinzufuegen
        this.menuView.getItems().add(this.menuItemZoomIn);
        this.menuView.getItems().add(this.menuItemZoomOut);

        this.getMenus().add(this.menuView);
    }


    /*
     * @author  yxyxD
     */
    private void setupMenuHelp()
    {
        // Text des Menues und der Menuepunkte
        this.menuHelp.setText(Labels.MENU_HELP_NAME);
        this.menuItemAbout.setText(Labels.BAR_ITEM_ABOUT_NAME);

        // ActionListener
        this.menuItemAbout.setOnAction(this.barActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuHelp.getItems().add(this.menuItemAbout);

        this.getMenus().add(this.menuHelp);
    }
}
