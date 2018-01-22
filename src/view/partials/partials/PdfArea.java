package view.partials.partials;

import listeners.PdfAreaMouseAdapter;
import factories.PdfFactory;
import model.ProjectCon;
import listeners.PdfResizeTimerActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class PdfArea extends JPanel {

    private final double MINIMUM_ZOOM_FACTOR = 0.5;
    private final double MAXIMUM_ZOOM_FACTOR = 1.5;
    private final int PDF_RESIZED_TIMER_DELAY = 3000;

    private final int NOTATION_RADIUS = 10;

    private PdfAreaMouseAdapter pdfAreaMouseAdapter;
    private Timer pdfResizedTimer;

    private ProjectCon projectCon;

    private BufferedImage pdfImage;
    private String pdfImagePath;
    private int initialImageWidth;
    private int initialImageHeight;
    private double zoomLevel;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @todo saubere Trennung zwischen Constructor und initialize-Methode fehlt
     */
    public PdfArea()
    {
        this.pdfAreaMouseAdapter = new PdfAreaMouseAdapter();
        this.addMouseListener(this.pdfAreaMouseAdapter);
        this.addMouseWheelListener(this.pdfAreaMouseAdapter);

        this.pdfImage = null;
        this.zoomLevel = 1.0;
    }

    public void initialize(ProjectCon projectCon)
    {
        this.projectCon = projectCon;

        this.pdfAreaMouseAdapter.initialize(this, this.projectCon);
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


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        this.repaintPdfGraphics(graphics);
        this.repaintNotationPoints(graphics);
    }


    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void importNewPdf(String sourcePath)
    {
        this.pdfImagePath = sourcePath;

        this.pdfImage = PdfFactory.renderPdfAsImage(this.pdfImagePath);
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
            this.refreshTimerOnRerenderingPdf();
        }
    }

    /*
     * @todo Exception werfen
     * @todo refactoring needed
     * @author  yxyxD
     */
    public void rerenderPdf()
    {
        this.pdfAreaMouseAdapter.disableZoom();
        System.out.println("Zoom aus");

        // das geht, aber nicht schnell => neues Rendering bei
        // jedem Zoomvorgang
        this.pdfImage = PdfFactory.renderPdfWithZoom(
            this.pdfImagePath,
            (float) this.zoomLevel
        );

        this.repaint();


        this.pdfAreaMouseAdapter.enableZoom();
        System.out.println("Zoom an");
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
        double scaledImageWidth = (double) this.pdfImage.getWidth()
            + ((double) this.initialImageWidth * zoomChange);
        double scaledImageHeight = (double) this.pdfImage.getHeight()
            + ((double) this.initialImageHeight * zoomChange);

        BufferedImage scaledPdfImage = this.getScaledPdfImage(
            scaledImageWidth,
            scaledImageHeight
        );

        AffineTransformOp transformOp = this.getAffineTransformOp(
            scaledImageWidth,
            scaledImageHeight
        );

        this.pdfImage = transformOp.filter(this.pdfImage, scaledPdfImage);

        this.repaint();
    }

    /*
     * @author  yxyxD
     */
    private BufferedImage getScaledPdfImage(
        double scaledImageWidth,
        double scaledImageHeight
    )
    {
        return new BufferedImage(
            (int) scaledImageWidth,
            (int) scaledImageHeight,
            BufferedImage.TYPE_INT_ARGB
        );
    }

    /*
     * @author  yxyxD
     */
    private AffineTransformOp getAffineTransformOp(
        double scaledImageWidth,
        double scaledImageHeight
    )
    {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.scale(
            (scaledImageWidth / (double) this.pdfImage.getWidth()),
            (scaledImageHeight / (double) this.pdfImage.getHeight())
        );

        return new AffineTransformOp(
            affineTransform,
            AffineTransformOp.TYPE_BILINEAR //@todo noch gucken
        );
    }

    /*
     * @author  yxyxD
     */
    private void refreshTimerOnRerenderingPdf()
    {
        if (this.pdfResizedTimer != null && this.pdfResizedTimer.isRunning())
        {
            this.pdfResizedTimer.stop();
        }

        this.pdfResizedTimer = new Timer(
            this.PDF_RESIZED_TIMER_DELAY,
            new PdfResizeTimerActionListener(this)
        );
        this.pdfResizedTimer.setRepeats(false);
        this.pdfResizedTimer.start();
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
            return;
        }

        this.setPreferredSize(new Dimension(
            this.pdfImage.getWidth(),
            this.pdfImage.getHeight())
        );

        graphics.drawImage(this.pdfImage, 0, 0, this);
    }

    /*
     * @author  yxyxD
     */
    private void repaintNotationPoints(Graphics graphics)
    {
        if (this.projectCon == null) { return; }
        if (this.projectCon.getListOfPoints() == null) { return; }

        graphics.setColor(Color.red);
        for (Point point : this.projectCon.getListOfPoints())
        {
            //@todo name refactoring
            int upperLeftX = (int) ((double) (point.x - this.NOTATION_RADIUS) * this.zoomLevel);
            int upperLeftY = (int) ((double) (point.y - this.NOTATION_RADIUS) * this.zoomLevel);
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


}

