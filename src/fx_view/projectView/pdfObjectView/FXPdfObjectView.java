package fx_view.projectView.pdfObjectView;

import fx_handler.FXPdfAreaScrollHandler;
import fx_view.projectView.pdfObjectView.partials.FXPdfArea;
import javafx.geometry.Orientation;
import javafx.scene.control.*;

public class FXPdfObjectView extends SplitPane {

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
    public FXPdfAreaScrollHandler getScrollHandler()
    {
        return scrollHandler;
    }
}
