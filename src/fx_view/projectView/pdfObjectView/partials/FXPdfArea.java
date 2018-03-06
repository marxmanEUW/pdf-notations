package fx_view.projectView.pdfObjectView.partials;

import fx_handler.FXPdfAreaScrollHandler;
import fx_threads.FXPdfRenderTask;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import model.PdfObject;

public class FXPdfArea extends ScrollPane {

    private final static String PATH_TO_IMAGE = "C:\\Users\\Conrad\\Pictures\\rtbvbls2fojz.jpg";
    private final static String PATH_TO_PDF = "files\\file1.pdf";

    // Pdf object view
    private FXPdfObjectView pdfObjectView;

    // event handler
    private FXPdfAreaScrollHandler scrollHandler;

    // local variables
    private ImageView pdfImage;
    private double zoomLevel;

    private FXPdfRenderTask pdfRenderTask;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public FXPdfArea()
    {
        this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        this.setPannable(true);
    }


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void initialize(FXPdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;
        this.scrollHandler = this.pdfObjectView.getScrollHandler();

        //File file = new File(PATH_TO_IMAGE);
        //this.pdfImage = new ImageView(file.toURI().toString());

        this.refreshPdfArea();
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public ImageView getPdfImage()
    {
        return pdfImage;
    }

    /*
     * @author  marxmanEUW
     */
    public PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }


    /*
     * #########################################################################
     * #                    public Methods                                     #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @todo zoom to mouse position
     */
    public void zoomPdf(double zoomChange)
    {
        if (this.isPdfZoomable(zoomChange))
        {
            double oldZoomLevel = this.zoomLevel;
            this.zoomLevel += zoomChange;

            double newWidth = this.pdfImage.getImage().getWidth() * this.zoomLevel;
            double newHeight = this.pdfImage.getImage().getHeight() * this.zoomLevel;

            // no need to set height, because the aspect ratio can not change
            // -> height gets calculated automatically
            pdfImage.setFitWidth(newWidth);
        }
    }

    /*
     * @author  marxmanEUW
     */
    public void refreshPdfArea()
    {
        this.zoomLevel = 1.0;
        //this.addingNotation = false;
        //this.setZoomEnabled(false);

        if (this.getPdfObject() == null)
        {
            // no pdf to import => load empty pdf
            this.pdfImage = null;
            //this.setContent(this.pdfImage);
        }
        else
        {
            this.pdfRenderTask = new FXPdfRenderTask(this);
            new Thread(this.pdfRenderTask).start();
            this.pdfRenderTask.setOnSucceeded(e -> this.appointRenderedPdf());
        }
    }

    /*
     * @author  marxmanEUW
     */
    public void appointRenderedPdf()
    {
        this.pdfImage = new ImageView();
        this.pdfImage.setImage(this.pdfRenderTask.getRenderedPdfImage());
        this.pdfImage.setPreserveRatio(true);

        this.pdfImage.setOnScroll(this.scrollHandler);

        this.setContent(this.pdfImage);
    }

    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @todo implement logic
     */
    private boolean isPdfZoomable(double zoomChange)
    {
        return true;
    }
}
