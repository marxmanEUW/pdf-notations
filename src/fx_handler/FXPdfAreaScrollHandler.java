package fx_handler;

import constants.Environment;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import fx_view.projectView.pdfObjectView.partials.FXPdfArea;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;

public class FXPdfAreaScrollHandler implements EventHandler<ScrollEvent> {

    private FXPdfObjectView pdfObjectView;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public FXPdfAreaScrollHandler()
    {
    }

    /*
     * #########################################################################
     * #                    Initialising                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void initialize(FXPdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;
    }


    /*
     * #########################################################################
     * #                    Overrides                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    @Override
    public void handle(ScrollEvent event)
    {
        if (event.isControlDown())
        {
            double zoomChange = 0;
            if (event.getDeltaY() > 0)
            {
                zoomChange = Environment.ZOOM_IN;
            }
            else if (event.getDeltaY() < 0)
            {
                zoomChange = Environment.ZOOM_OUT;
            }

            this.getPdfArea().zoomPdf(zoomChange);
        }
    }


    /*
     * #########################################################################
     * #                    pirvate methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    private FXPdfArea getPdfArea()
    {
        return this.pdfObjectView.getPdfArea();
    }
}
