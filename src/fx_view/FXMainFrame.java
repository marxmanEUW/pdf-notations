package fx_view;

import constants.Labels;
import fx_listener.FXBarActionListener;
import fx_view.bar.FXMainFrameMenuBar;
import fx_view.bar.FXMainFrameToolBar;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.application.*;
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
    private FXBarActionListener barActionListener;


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

        // initialize GUI components and add them
        // Bar Action Listener
        this.barActionListener = new FXBarActionListener();
        this.barActionListener.initialize(this);

        // Menu Bar
        this.menuBar = new FXMainFrameMenuBar();
        this.menuBar.initialize(this.barActionListener);

        // Tool Bar
        this.toolBar = new FXMainFrameToolBar();
        this.toolBar.initialize(this.barActionListener);

        // set Menu Bar and Tool BAr at Top
        this.topComponent = new VBox();
        this.topComponent.getChildren().add(this.menuBar);
        this.topComponent.getChildren().add(this.toolBar);
        this.layout.setTop(this.topComponent);

        // Pdf Object View
        this.pdfObjectView = new FXPdfObjectView();
        this.pdfObjectView.initialize();

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
     * @brief   Returns the Toolbar of the MainFrame
     */
    public FXMainFrameToolBar getToolBar()
    {
        return this.toolBar;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the PdfObjectView of the MainFrame
     */
    public FXPdfObjectView getPdfObjectView()
    {
        return this.pdfObjectView;
    }
}
