package view.projectView.pdfObjectView.partials;

import factories.PdfZoomFactory;
import listeners.PdfAreaMouseClick;
import listeners.PdfAreaMouseWheel;
import model.Notation;
import model.PdfObject;

import threads.PdfRenderThread;

import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class PdfArea extends JPanel {

    // Pdf object view
    private PdfObjectView pdfObjectView;

    // constants
    private final double MINIMUM_ZOOM_FACTOR = 0.5;
    private final double MAXIMUM_ZOOM_FACTOR = 1.5;
    private final int NOTATION_RADIUS = 10;
    private final Color NOTATION_STANDARD_COLOR = Color.red;
    private final Color NOTATION_SELECTED_COLOR = Color.blue;

    // listeners / adapters
    private PdfAreaMouseClick pdfAreaMouseClick;
    private PdfAreaMouseWheel pdfAreaMouseWheel;

    // local variables
    private BufferedImage pdfImage;
    private int initialImageWidth;
    private int initialImageHeight;
    private double zoomLevel;

    private boolean addingNotation;

    private PdfRenderThread pdfRenderThread;
    private boolean isZoomEnabled;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Constructs a PdfArea which visualises the Pdf and its Notations.
     */
    public PdfArea()
    {
        this.setFocusable(true);
    }


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Initialises the PdfArea.  
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.pdfAreaMouseClick = this.pdfObjectView.getPdfAreaMouseClick();
        this.pdfAreaMouseWheel = this.pdfObjectView.getPdfAreaMouseWheel();

        this.addMouseListener(this.pdfAreaMouseClick);
        this.addMouseWheelListener(this.pdfAreaMouseWheel);

        this.refreshPdfArea();
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
     * @brief   Returns the current zoom level of the pdf.
     */
    public double getZoomLevel()
    {
        return zoomLevel;
    }

    /*
     * @author  marxmanEUW
     */
    public boolean getAddingNotation()
    {
        return addingNotation;
    }

    /*
     * @author  marxmanEUW
     */
    public PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the current status of the zoom (enabled or disabled).
     */
    public boolean isZoomEnabled()
    {
        return this.isZoomEnabled;
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
     */
    public void setCursorTypeToCrosshair()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    /*
     * @author  marxmanEUW
     */
    public void setCursorTypeToDefault()
    {
        this.setCursor(Cursor.getDefaultCursor());
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Repaints the PdfObject and its Notations.
     */
    @Override
    protected void paintComponent(Graphics graphics)
    {
        this.disableZoom();

        this.repaintPdfGraphics(graphics);
        this.repaintNotationPoints(graphics);

        this.pdfObjectView.getPdfScrollPane().getViewport().revalidate();

        this.enableZoom();
    }


    /*
     * #########################################################################
     * #                    Public Methods                                     #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @todo merge to one function with disableZoom
     */
    public void enableZoom()
    {
        this.isZoomEnabled = true;
    }

    /*
     * @author  yxyxD
     * @todo merge to one function with enableZoom
     */
    public void disableZoom()
    {
        this.isZoomEnabled = false;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Refreshes the PdfArea after an new PdfObject has been loaded or
     *          an old PdfObject has been closed.
     */
    public void refreshPdfArea()
    {
        this.zoomLevel = 1.0;
        this.addingNotation = false;
        this.disableZoom();

        if (this.getPdfObject() == null)
        {
            // no pdf to import => load empty pdf
            this.pdfImage = new BufferedImage(
                1,
                1,
                BufferedImage.TYPE_INT_RGB);

            this.repaint();
        }
        else
        {
            this.pdfRenderThread = new PdfRenderThread(
                this,
                true
            );
        }
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Zooms the Pdf by resizing the image. Also starts a new thread
     *          to re-render to Pdf on the current zoom level.
     */
    public void zoomPdf(double zoomChange)
    {
        if (this.isPdfZoomable(zoomChange))
        {
            this.zoomLevel += zoomChange;

            this.pdfImage = PdfZoomFactory.getZoomedImage(
                this.initialImageWidth,
                this.initialImageHeight,
                this.pdfImage,
                zoomChange
            );

            this.repaint();

            this.pdfRenderThread = new PdfRenderThread(this);
        }
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   ! IMPORTANT: May only be called by the PdfRenderThread.
     *          Sets the pdfImage to the re-rendered Pdf and repaints the
     *          PdfArea.
     */
    public void appointReRenderedPdf()
    {
        this.pdfImage = this.pdfRenderThread.getRenderedPdfImage();

        // if the pdf was imported initially, set initial width and height
        if (this.pdfRenderThread.isImportInitial())
        {
            this.initialImageWidth = this.pdfImage.getWidth();
            this.initialImageHeight = this.pdfImage.getHeight();
        }

        this.repaint();
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
     * @brief   Checks if the requested zoom is allowed.
     */
    private boolean isPdfZoomable(double zoomChange)
    {
        boolean isPdfZoomable = false;

        if (((this.zoomLevel + zoomChange) > this.MINIMUM_ZOOM_FACTOR)
            && ((this.zoomLevel + zoomChange) < this.MAXIMUM_ZOOM_FACTOR)
            && (this.pdfImage != null)) {

            isPdfZoomable = true;
        }

        return isPdfZoomable;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Repaints the pdfImage.
     */
    private void repaintPdfGraphics(Graphics graphics)
    {
        if (this.pdfImage == null)
        {
            this.setPreferredSize(new Dimension(0, 0));
        }
        else
        {
            this.setPreferredSize(new Dimension(
                this.pdfImage.getWidth(),
                this.pdfImage.getHeight())
            );
        }

        graphics.drawImage(this.pdfImage, 0, 0, this);
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Repaints the Notations on the pdfImage.
     */
    private void repaintNotationPoints(Graphics graphics)
    {
        if (this.getPdfObject() == null) { return; }
        if (this.getPdfObject().getListOfPoints() == null) { return; }

        for (Notation notation : this.getPdfObject().getListOfNotations())
        {
            if (notation.getId() == this.getPdfObject().getSelectedNotationIndex())
            {
                graphics.setColor(this.NOTATION_SELECTED_COLOR);
            }
            else
            {
                graphics.setColor(this.NOTATION_STANDARD_COLOR);
            }

            //@todo name refactoring
            int upperLeftX = (int) ((double) (notation.getX() - this.NOTATION_RADIUS)
                * this.zoomLevel);
            int upperLeftY = (int) ((double) (notation.getY() - this.NOTATION_RADIUS)
                * this.zoomLevel);
            int ovalWidth = (int) (((double) this.NOTATION_RADIUS * 2.0)
                * this.zoomLevel);
            int ovalHeight = (int) (((double) this.NOTATION_RADIUS * 2.0)
                * this.zoomLevel);

            graphics.fillOval(
                upperLeftX,
                upperLeftY,
                ovalWidth,
                ovalHeight
            );
        }
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Checks if a Notation can be painted at the clicked location.
     *          That is not allowed if an other Notation would get painted over.
     */
    public boolean isNotationInRangeOfOtherNotation(Point point)
    {
        boolean isPointInRange = false;

        // get coordinates of actual point (without zoom factor)
        Point actualPoint = this.getActualCoordinatesOfPoint(point);

        // minimal required distance for no overlapping is two time the radius
        double minimalRange = (double) NOTATION_RADIUS * 2.0;

        for (Notation notation : this.getPdfObject().getListOfNotations())
        {
            Point notationPoint = notation.getCoordinates();

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
    public Notation getClickedNotation(Point point)
    {
        //if (this.getPdfObject() == null) { return null; }

        Point actualPoint = this.getActualCoordinatesOfPoint(point);

        Notation clickedNotation = null;
        for (Notation notation : this.getPdfObject().getListOfNotations())
        {
            Point notationPoint = notation.getCoordinates();
            double distance = actualPoint.distance(notationPoint);

            if (distance <= (double) NOTATION_RADIUS)
            {
                clickedNotation = notation;
                break;
            }
        }

        return clickedNotation;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the actual coordinates of the location clicked on,
     *          because they differ based on the zoom level.
     */
    public Point getActualCoordinatesOfPoint(Point point)
    {
        return new Point(
            (int) (point.getX() / this.zoomLevel),
            (int) (point.getY() / this.zoomLevel)
        );
    }
}

