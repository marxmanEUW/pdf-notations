package fx_view.projectView.pdfObjectView.partials;

import constants.Environment;
import fx_threads.FXPdfRenderTask;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Notation;
import model.PdfObject;


public class FXPdfArea extends ScrollPane {

    // Pdf object view
    private FXPdfObjectView pdfObjectView;

    // local variables
    private Pane contentPane;
    private ImageView pdfImage;
    private double zoomLevel;

    // pdfRenderTask
    private FXPdfRenderTask pdfRenderTask;

    // state variables
    private boolean addingNotation;

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

        this.contentPane = new Pane();
        this.contentPane.setOnMouseClicked(this.pdfObjectView.getPdfAreaMouseHandler());
        this.contentPane.setOnScroll(this.pdfObjectView.getPdfAreaScrollHandler());

        this.setContent(this.contentPane);
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
     * @author  marxmanEUW
     */
    public boolean isAddingNotation()
    {
        return addingNotation;
    }

    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void setAddingNotation(boolean addingNotation)
    {
        this.addingNotation = addingNotation;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the cursor to CrossHair.
     */
    public void setCursorTypeToCrosshair()
    {
        this.contentPane.setCursor(Cursor.CROSSHAIR);
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the cursor to default.
     */
    public void setCursorTypeToDefault()
    {
        this.contentPane.setCursor(Cursor.DEFAULT);
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
            this.repaintNotations();
        }
    }

    /*
     * @author  marxmanEUW
     */
    public void refreshPdfArea()
    {
        this.contentPane.getChildren().clear();

        this.zoomLevel = 1.0;
        this.addingNotation = false;
        //this.setZoomEnabled(false);

        if (this.getPdfObject() == null)
        {
            // no pdf to import => load empty pdf
            this.pdfImage = null;
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
    public void repaintNotations()
    {
        if (this.getPdfObject() == null) { return; }
        if (this.getPdfObject().getListOfNotations() == null) { return; }

        this.contentPane.getChildren().clear();
        this.contentPane.getChildren().add(this.pdfImage);

        for (Notation notation :
            this.getPdfObject().getListOfNotations().values()
            )
        {
            Color circleColor;

            if (notation.getId() == this.getPdfObject().getSelectedNotationId())
            {
                circleColor = Environment.FX_NOTATION_SELECTED_COLOR;
            }
            else
            {
                circleColor = Environment.FX_NOTATION_STANDARD_COLOR;
            }

            int circleX = (int) (notation.getX() * this.zoomLevel);
            int circleY = (int) (notation.getY() * this.zoomLevel);
            int circleRadius = (int)
                (((double) Environment.NOTATION_RADIUS)
                    * this.zoomLevel
                );
            Circle circle = new Circle(circleX, circleY, circleRadius );
            circle.setFill(circleColor);
            this.contentPane.getChildren().add(circle);
        }
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Returns the actual coordinates of the location clicked on,
     *          because they differ based on the zoom level.
     */
    public Point2D getActualCoordinatesOfPoint(Point2D point)
    {
        return new Point2D(
            (point.getX() / this.zoomLevel),
            (point.getY() / this.zoomLevel)
        );
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Checks if a Notation can be painted at the clicked location.
     *          That is not allowed if an other Notation would get painted over.
     *          No need to calculate "actualPoint", because the right point was
     *          handed over.
     */
    public boolean isNotationInRangeOfOtherNotation(Point2D actualPoint)
    {
        boolean isPointInRange = false;

        // minimal required distance for no overlapping is two time the radius
        double minimalRange = (double) Environment.NOTATION_RADIUS * 2.0;

        for (Notation notation :
            this.getPdfObject().getListOfNotations().values()
            )
        {
            Point2D notationPoint = notation.getCoordinates();

            double distance = actualPoint.distance(notationPoint);
            if (distance <= minimalRange)
            {
                isPointInRange = true;
                break;
            }
        }

        return isPointInRange;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the Notation located in the area that has been clicked
     *          on (if there is any Notation).
     */
    public Notation getClickedNotation(Point2D actualPoint)
    {
        Notation clickedNotation = null;

        for (Notation notation :
            this.getPdfObject().getListOfNotations().values()
            )
        {
            Point2D notationPoint = notation.getCoordinates();
            double distance = actualPoint.distance(notationPoint);

            if (distance <= (double) Environment.NOTATION_RADIUS)
            {
                clickedNotation = notation;
                break;
            }
        }

        return clickedNotation;
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
        boolean returnValue = true;
        if(this.pdfImage == null)
        {
            returnValue = false;
        }
        return returnValue;
    }

    /*
     * @author  marxmanEUW
     */
    private void appointRenderedPdf()
    {
        this.pdfImage = new ImageView();
        this.pdfImage.setImage(this.pdfRenderTask.getRenderedPdfImage());
        this.pdfImage.setPreserveRatio(true);

        this.repaintNotations();
    }
}
