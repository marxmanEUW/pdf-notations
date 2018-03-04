package fx_view.projectView.pdfObjectView;

import factories.PdfObjectFactory;
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
    private FXPdfAreaScrollHandler scrollHandler;

    // Left part of the center component
    private FXPdfArea pdfArea;


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
        this.scrollHandler = new FXPdfAreaScrollHandler();
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
        this.scrollHandler.initialize(this);

        Label label2 = new Label("Label 2");

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
    public FXPdfAreaScrollHandler getScrollHandler()
    {
        return scrollHandler;
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
