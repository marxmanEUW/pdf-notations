package fx_view.projectView.pdfObjectView;

import factories.PdfObjectFactory;
import fx_handler.FXPdfAreaMouseHandler;
import fx_handler.FXPdfAreaScrollHandler;
import fx_view.projectView.pdfObjectView.partials.FXPdfArea;
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

    // Left part of the center component
    private FXPdfArea pdfArea;

    // Right part
    private Label label2;


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
        this.pdfAreaScrollHandler = new FXPdfAreaScrollHandler();
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
        this.pdfAreaScrollHandler.initialize(this);

        this.label2 = new Label("Label 2");

        this.pdfAreaMouseHandler = new FXPdfAreaMouseHandler();
        this.pdfAreaMouseHandler.initialize(this);

        this.pdfAreaScrollHandler = new FXPdfAreaScrollHandler();
        this.pdfAreaScrollHandler.initialize(this);

        this.pdfArea = new FXPdfArea();
        this.pdfArea.initialize(this);


        this.getItems().add(this.pdfArea);
        this.getItems().add(label2);
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

    public Label getLabel2()
    {
        return label2;
    }

    /*
     * #########################################################################
     * #                    public methods                                     #
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
        //this.entityScrollPane.updateTable();
        //this.notationListScrollPane.updateTable();
    }
}
