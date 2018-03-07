package view.projectView.pdfObjectView.partials;

import constants.Environment;
import factories.PdfZoomFactory;
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

    // PDF image
    private BufferedImage pdfImage;
    private int initialImageWidth;
    private int initialImageHeight;
    private double zoomLevel;

    // pdfRenderThread
    private PdfRenderThread pdfRenderThread;

    // state variables
    private boolean isZoomEnabled;
    private boolean addingNotation;

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

        this.addMouseListener(this.pdfObjectView.getPdfAreaMouseClick());
        this.addMouseWheelListener(this.pdfObjectView.getPdfAreaMouseWheel());

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
     *      2018-02-19 (yxyxD)  created
     * @brief   Returns the pdfImage of the PdfArea.
     */
    public BufferedImage getPdfImage()
    {
        return this.pdfImage;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-19 (yxyxD)  created
     * @brief   Returns the initial width of the pdfImage.
     */
    public int getInitialImageWidth()
    {
        return this.initialImageWidth;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-19 (yxyxD)  created
     * @brief   Returns the initial height of the pdfImage.
     */
    public int getInitialImageHeight()
    {
        return this.initialImageHeight;
    }

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
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns AddingNotation of the PdfArea.
     */
    public boolean getAddingNotation()
    {
        return addingNotation;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-28 (yxyxD)  created
     * @brief   Returns the PdfObjectView.
     */
    public PdfObjectView getPdfObjectView()
    {
        return this.pdfObjectView;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfObject of the PdfObjectView.
     */
    public PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns whether or not the zoom is disabled.
     */
    public boolean isZoomDisabled()
    {
        return !this.isZoomEnabled;
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets AddingNotation of PdfArea.
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
    public void setCursorTypeToCrossHair()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the cursor to default.
     */
    public void setCursorTypeToDefault()
    {
        this.setCursor(Cursor.getDefaultCursor());
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Enables or disables the zoom.
     */
    private void setZoomEnabled(boolean zoomEnabled)
    {
        this.isZoomEnabled = zoomEnabled;
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
        this.setZoomEnabled(false);

        this.repaintPdfGraphics(graphics);
        this.repaintNotationPoints(graphics);

        this.pdfObjectView.getPdfScrollPane().getViewport().revalidate();
        this.getPdfObjectView().getMainFrame().getToolBar().setLabelZoomLevel(
            this.zoomLevel
        );

        this.setZoomEnabled(true);
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
     * @brief   Refreshes the PdfArea after an new PdfObject has been loaded or
     *          an old PdfObject has been closed.
     */
    public void refreshPdfArea()
    {
        this.zoomLevel = 1.0;
        this.addingNotation = false;
        this.setZoomEnabled(false);

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
            this.zoomLevel = this.calculateAndReturnNewZoomLevel(zoomChange);

            this.pdfImage = PdfZoomFactory.getZoomedImage(
                this,
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
        double minimalRange = (double) Environment.NOTATION_RADIUS * 2.0;

        for (Notation notation : this.getPdfObject().getListOfNotations().values())
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

        for (Notation notation : this.getPdfObject().getListOfNotations().values())
        {
            Point notationPoint = notation.getCoordinates();
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

        double newZoomLevel = this.calculateAndReturnNewZoomLevel(zoomChange);

        if ((newZoomLevel >= Environment.MINIMUM_ZOOM_FACTOR)
            && (newZoomLevel <= Environment.MAXIMUM_ZOOM_FACTOR)
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

        for (Notation notation : this.getPdfObject().getListOfNotations().values())
        {
            if (notation.getId() == this.getPdfObject().getSelectedNotationIndex())
            {
                graphics.setColor(Environment.NOTATION_SELECTED_COLOR);
            }
            else
            {
                graphics.setColor(Environment.NOTATION_STANDARD_COLOR);
            }

            int circleX = (int) ((double) (notation.getX() - Environment.NOTATION_RADIUS)
                * this.zoomLevel);
            int circleY = (int) ((double) (notation.getY() - Environment.NOTATION_RADIUS)
                * this.zoomLevel);
            int circleDiameter = (int) (((double) Environment.NOTATION_RADIUS * 2.0)
                * this.zoomLevel);

            graphics.fillOval(
                circleX,
                circleY,
                circleDiameter,
                circleDiameter
            );
        }
    }

    /*
     * @author  AbellaMort
     * @changes
     *      2018-03-02 (AbellaMort) created
     * @brief   Calculates and returns the new ZoomLevel. Necessary to correct
     *      float point calculation errors by rounding to one decimal point.
     */

    private double calculateAndReturnNewZoomLevel(double zoomChange)
    {
        return Math.round((this.zoomLevel + zoomChange)*10.0)/10.0;
    }

}

