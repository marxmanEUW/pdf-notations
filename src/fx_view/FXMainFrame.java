package fx_view;

import constants.Environment;
import constants.Labels;
import fx_handler.FXBarActionHandler;
import fx_handler.FXHyperlinkChangeListener;
import fx_handler.FXWindowHandler;
import fx_view.bar.FXMainFrameMenuBar;
import fx_view.bar.FXMainFrameToolBar;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class FXMainFrame extends Application {

    private Stage window;
    private Scene scene;

    // layouts
    private BorderPane layout;
    private VBox topComponent;

    // Bars
    private FXMainFrameMenuBar menuBar;
    private FXMainFrameToolBar toolBar;

    // PDF-Object
    private FXPdfObjectView pdfObjectView;

    // Listeners
    private FXBarActionHandler barActionHandler;
    private FXWindowHandler windowHandler;
    private FXHyperlinkChangeListener hyperlinkChangeListener;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-27 (marxmanEUW) created
     * @brief   Constructor of the MainFrame.
     */
    public FXMainFrame()
    {
    }


    /*
     * #########################################################################
     * #                    Initialising                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-27 (marxmanEUW) created
     * @brief   Initialises the MainFrame.
     */
    public void initialize()
    {
        Application.launch(this.getClass());
    }


    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-27 (marxmanEUW) created
     * @brief   Initialises the MainFrame.
     *          Gets called from the initialize method.
     */
    @Override
    public void start(Stage primaryStage)
    {
        this.window = primaryStage;

        // create important components
        this.layout = new BorderPane();
        this.scene = new Scene(this.layout);

        this.window.setTitle(Labels.FRAME_TITLE);

        // create GUI components (can´t to this in constructor)
        this.hyperlinkChangeListener = new FXHyperlinkChangeListener();
        this.barActionHandler = new FXBarActionHandler();
        this.windowHandler = new FXWindowHandler();

        this.menuBar = new FXMainFrameMenuBar();
        this.toolBar = new FXMainFrameToolBar();

        this.pdfObjectView = new FXPdfObjectView();


        // initialize GUI components

        // Hyperlink Action Listener
        this.hyperlinkChangeListener.initialize(this);

        // Bar Action Listener
        this.barActionHandler.initialize(this);

        // close handling
        this.windowHandler.initialize(this);
        this.window.setOnCloseRequest(this.windowHandler);

        // Menu Bar
        this.menuBar.initialize(this.barActionHandler);

        // Tool Bar
        this.toolBar.initialize(this.barActionHandler);

        // Pdf Object View
        this.pdfObjectView.initialize();

        this.setDividerLocationsOfSplitPanes();

        // add GUI components
        this.topComponent = new VBox();
        this.topComponent.getChildren().add(this.menuBar);
        this.topComponent.getChildren().add(this.toolBar);
        this.layout.setTop(this.topComponent);

        this.layout.setCenter(this.pdfObjectView);

        //set scene and display
        this.window.setScene(this.scene);
        this.window.setMaximized(true);

        this.window.show();
    }

    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the MenuBar of the MainFrame.
     */
    public FXMainFrameMenuBar getJMenuBar()
    {
        return this.menuBar;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the Toolbar of the MainFrame.
     */
    public FXMainFrameToolBar getToolBar()
    {
        return this.toolBar;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the PdfObjectView of the MainFrame.
     */
    public FXPdfObjectView getPdfObjectView()
    {
        return this.pdfObjectView;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-08 (marxmanEUW)  created
     * @brief   Returns the Windows of the MainFrame.
     */
    public Stage getWindow()
    {
        return window;
    }

    public FXHyperlinkChangeListener getHyperlinkChangeListener()
    {
        return hyperlinkChangeListener;
    }

    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Sets the Split Pane Divider Locations.
     * @todo refactor
     */
    private void setDividerLocationsOfSplitPanes()
    {
        this.window.showingProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(
                ObservableValue<? extends Boolean> observable,
                Boolean oldValue,
                Boolean newValue)
            {
                if (newValue) {
                    pdfObjectView.setDividerPositions(
                        Environment.PDF_OBJECT_VIEW_DIVIDER_LOCATION
                    );
                    pdfObjectView.getNotationSplitPane().setDividerPositions(
                        Environment.NOTATION_SPLIT_PANE_DIVIDER_LOCATION
                    );
                    observable.removeListener(this);
                }
            }
        });
    }
}
