package fx_view.projectView.pdfObjectView;

import factories.PdfObjectFactory;
import fx_handler.FXNotationListTableChangeListener;
import fx_handler.FXPdfAreaMouseHandler;
import fx_handler.FXPdfAreaScrollHandler;
import fx_view.projectView.pdfObjectView.partials.*;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import model.PdfObject;

import java.io.File;

public class FXPdfObjectView extends SplitPane {

    // PDF-Object
    private PdfObject pdfObject;

    // event handler
    private FXPdfAreaScrollHandler pdfAreaScrollHandler;
    private FXPdfAreaMouseHandler pdfAreaMouseHandler;
    private FXNotationListTableChangeListener notationListTableChangeListener;

    // Left part of the center component
    private FXPdfArea pdfArea;

    // Right part
    private FXNotationSplitPane notationSplitPane;
    private FXNotationListTableView notationListTableView;
    private FXNotationEntityTableView notationEntityTableView;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public FXPdfObjectView()
    {
        this.setOrientation(Orientation.HORIZONTAL);

    }


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void initialize()
    {
        // create
        this.pdfAreaScrollHandler = new FXPdfAreaScrollHandler();
        this.pdfAreaMouseHandler = new FXPdfAreaMouseHandler();
        this.notationListTableChangeListener = new FXNotationListTableChangeListener();

        this.pdfArea = new FXPdfArea();
        this.notationSplitPane = new FXNotationSplitPane();

        this.notationListTableView = new FXNotationListTableView();
        this.notationEntityTableView = new FXNotationEntityTableView();

        // initialize
        this.pdfAreaMouseHandler.initialize(this);
        this.pdfAreaScrollHandler.initialize(this);
        this.notationListTableChangeListener.initialize(this);

        this.pdfArea.initialize(this);

        this.notationSplitPane.initialize(this);
        this.notationListTableView.initialize(this);
        this.notationEntityTableView.initialize(this);

        this.getItems().add(this.pdfArea);
        this.getItems().add(this.notationSplitPane);
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public FXPdfArea getPdfArea()
    {
        return pdfArea;
    }

    /*
     * @author  marxmanEUW
     */
    public PdfObject getPdfObject()
    {
        return pdfObject;
    }

    /*
     * @author  marxmanEUW
     */
    public FXPdfAreaScrollHandler getPdfAreaScrollHandler()
    {
        return pdfAreaScrollHandler;
    }

    /*
     * @author  marxmanEUW
     */
    public FXPdfAreaMouseHandler getPdfAreaMouseHandler()
    {
        return pdfAreaMouseHandler;
    }

    /*
     * @author  marxmanEUW
     */
    public FXNotationSplitPane getNotationSplitPane()
    {
        return notationSplitPane;
    }

    /*
     * @author  marxmanEUW
     */
    public FXNotationListTableView getNotationListTableView()
    {
        return notationListTableView;
    }

    /*
     * @author  marxmanEUW
     */
    public FXNotationEntityTableView getNotationEntityTableView()
    {
        return notationEntityTableView;
    }

    /*
     * @author  marxmanEUW
     */
    public FXNotationListTableChangeListener getNotationListTableChangeListener()
    {
        return notationListTableChangeListener;
    }

    /*
     * #########################################################################
     * #                    Public Methods                                     #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Opens a new Project.
     */
    public void openProject(File file)
    {
        this.pdfObject = PdfObjectFactory.loadPdfObjectFromFile(file);

        this.updateViews();
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Closes a loaded Project.
     */
    public void closeProject()
    {
        this.pdfObject = null;

        this.updateViews();
    }

    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Updates the PdfObjectView-Components when a new Pdf-Object has
     *          been loaded (or closed).
     */
    private void updateViews()
    {
        this.pdfArea.refreshPdfArea();
        this.notationListTableView.updateTable();
        this.notationEntityTableView.updateTable();
    }
}
