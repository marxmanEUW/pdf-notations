package view.projectView.pdfObjectView.partials;


import factories.PdfRenderFactory;
import factories.PdfZoomFactory;
import listeners.PdfAreaMouseClick;
import listeners.PdfAreaMouseWheel;
import model.Notation;
import model.PdfObject;

import threads.PdfRenderThread;

import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;


public class PdfArea extends JPanel {

    // constants
    private final double MINIMUM_ZOOM_FACTOR = 0.5;
    private final double MAXIMUM_ZOOM_FACTOR = 1.5;
    private final int NOTATION_RADIUS = 10;
    private final Color NOTATION_STANDARD_COLOR = Color.red;
    private final Color NOTATION_SELECTED_COLOR = Color.blue;
    
    // Pdf object view
    private PdfObjectView pdfObjectView;

    // listeners and adapters
    private PdfAreaMouseClick pdfAreaMouseClick;
    private PdfAreaMouseWheel pdfAreaMouseWheel;

    // local variables
    private BufferedImage pdfImage;
    private int initialImageWidth;
    private int initialImageHeight;
    private double zoomLevel;

    private boolean addingNotation;

    private PdfRenderThread pdfRenderThread;
    private boolean isZoomEnbabled;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public PdfArea()
    {
        this.pdfImage = null;
        this.zoomLevel = 1.0;
        this.addingNotation = false;
    }

    /*
     * @author  yxyxD
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.pdfAreaMouseClick = this.pdfObjectView.getPdfAreaMouseClick();
        this.pdfAreaMouseWheel = this.pdfObjectView.getPdfAreaMouseWheel();

        this.addMouseListener(this.pdfAreaMouseClick);
        this.addMouseWheelListener(this.pdfAreaMouseWheel);

        this.loadPdf();
        this.setFocusable(true);
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public double getZoomLevel()
    {
        return zoomLevel;
    }

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
     */
    public boolean isZoomEnbabled()
    {
        return this.isZoomEnbabled;
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
    @Override
    protected void paintComponent(Graphics graphics)
    {
        //super.paintComponent(graphics);

        this.repaintPdfGraphics(graphics);
        this.repaintNotationPoints(graphics);

        this.pdfObjectView.getPdfScrollPane().getViewport().revalidate();
    }


    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void enableZoom()
    {
        this.isZoomEnbabled = true;
    }

    /*
     * @author  yxyxD
     */
    public void disableZoom()
    {
        this.isZoomEnbabled = false;
    }

    /*
     * @author  yxyxD
     */
    public void loadPdf()
    {
        if (this.getPdfObject() == null)
        {
            // no pdf to import => load empty pdf
            this.pdfImage = new BufferedImage(
                1,
                1,
                BufferedImage.TYPE_INT_RGB);
            System.out.println("empty image");
        }
        else
        {
            this.pdfImage = PdfRenderFactory.renderPdfFromPdfObject(
                this.getPdfObject()
            );
            this.enableZoom();
        }

        this.initialImageWidth = this.pdfImage.getWidth();
        this.initialImageHeight = this.pdfImage.getHeight();

        this.repaint();
    }

    /*
     * @author  yxyxD
     */
    public void resizePdf(double zoomChange)
    {
        if (this.isPdfZoomable(zoomChange))
        {
            this.zoomLevel += zoomChange;

            this.zoomPdf(zoomChange);
        }
    }

    /*
     * @author  yxyxD
     */
    public void reRenderPdf()
    {
        this.pdfImage = this.pdfRenderThread.getPdfImage();
        this.repaint();
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    private void zoomPdf(double zoomChange)
    {
        this.pdfImage = PdfZoomFactory.getZoomedImage(
            this.initialImageWidth,
            this.initialImageHeight,
            this.pdfImage,
            zoomChange
        );

        this.repaint();

        this.pdfRenderThread = new PdfRenderThread(this);
    }

    /*
     * @author  yxyxD
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
     * @todo Wahrheitsfunktion, damit punkte nicht überlappend gezeichnet werden
     * @todo können
     */
    public boolean isNotationInRange(Point point)
    {
        boolean isPointInRange = false;

        // get coordinates of actual point (without zoom factor)
        Point actualPoint = new Point(
            (int) (point.getX() / this.zoomLevel),
            (int) (point.getY() / this.zoomLevel)
        );

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
     */
    public Notation getClickedNotation(Point point)
    {
        if (this.getPdfObject() == null)
        {
            return null;
        }

        Notation clickedNotation = null;

        // get coordinates of actual point (without zoom factor)
        Point actualPoint = new Point(
            (int) (point.getX() / this.zoomLevel),
            (int) (point.getY() / this.zoomLevel)
        );

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
     */
    public Point getActualCoordinatesOfPoint(Point point)
    {
        return new Point(
            (int) (point.getX() / this.zoomLevel),
            (int) (point.getY() / this.zoomLevel)
        );
    }
}

