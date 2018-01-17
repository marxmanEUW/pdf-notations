package gui.partials;

import controller.PdfAreaMouseListener;
import handlers.PdfHandler;
import main.Launcher;
import model.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class PdfArea extends JPanel {

    private final double MINIMUM_ZOOM_FACTOR = 0.5;
    private final double MAXIMUM_ZOOM_FACTOR = 1.5;
    private final int NOTATION_RADIUS = 10;

    private PdfAreaMouseListener pdfAreaMouseListener;
    private Project project;

    private BufferedImage pdfImage;
    private String pdfImagePath;
    private int initialImageWidth;
    private int initialImageHeight;
    private double zoomLevel;


    public PdfArea(Project project)
    {
        this.project = project;

        this.pdfAreaMouseListener = new PdfAreaMouseListener(this, this.project);
        this.addMouseListener(this.pdfAreaMouseListener);
        this.addMouseWheelListener(this.pdfAreaMouseListener);

        this.pdfImage = null;
        this.zoomLevel = 1.0;
    }


    public double getZoomLevel()
    {
        return zoomLevel;
    }


    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */

    public void importNewPdf(String sourcePath)
    {
        this.pdfImagePath = sourcePath;
        this.pdfImage = PdfHandler.renderPdfAsImage(this.pdfImagePath);
        this.initialImageWidth = this.pdfImage.getWidth();
        this.initialImageHeight = this.pdfImage.getHeight();

        this.setPreferredSize(new Dimension(
            this.pdfImage.getWidth(),
            this.pdfImage.getHeight())
        );

        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(this.pdfImage, 0, 0, this);

        if(this.project.getListOfPoints() != null)
        {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.red);
            for (Point point : this.project.getListOfPoints()) {
                g2.fillOval(point.x - NOTATION_RADIUS, point.y - NOTATION_RADIUS, NOTATION_RADIUS * 2, NOTATION_RADIUS * 2);
            }
            this.repaint();
        }

    }

    public void resizePdf(double zoomChange)
    {
        if (this.isPdfZoomable(zoomChange)) {

            // Zoomlevel speichern
            this.zoomLevel += zoomChange;

            this.zoomPdf(zoomChange);
        }
    }

    private void zoomPdf(double zoomChange)
    {
        double scaledImageWidth =
            ((double) this.pdfImage.getWidth() + ((double) this.initialImageWidth * zoomChange));
        double scaledImageHeight =
            ((double) this.pdfImage.getHeight() + ((double) this.initialImageHeight * zoomChange));
        BufferedImage scaledPdfImage = new BufferedImage(
            (int) scaledImageWidth,
            (int) scaledImageHeight,
            BufferedImage.TYPE_INT_ARGB
        );

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.scale(
            (scaledImageWidth / (double) this.pdfImage.getWidth()),
            (scaledImageHeight / (double) this.pdfImage.getHeight())
        );
        AffineTransformOp transformOp = new AffineTransformOp(
            affineTransform,
            AffineTransformOp.TYPE_BILINEAR
        );
        scaledPdfImage = transformOp.filter(this.pdfImage, scaledPdfImage);

        this.pdfImage = scaledPdfImage;
        /*
         * @todo !Prüfen: Ist die Größe des skalierten Images genau so
         * @todo          groß wie Größe des Elementes?
         * @todo Lösung => JScrollPane rezisen
         */
        this.setPreferredSize(new Dimension(
            this.pdfImage.getWidth(),
            this.pdfImage.getHeight()
        ));

        this.repaint();
    }

    /*
     * @todo Exception werfen
     */
    private void rerenderPdf()
    {
        // das geht, aber nicht schnell => neues Rendering bei
        // jedem Zoomvorgang
        this.pdfImage = PdfHandler.renderPdfWithZoom(
            this.pdfImagePath,
            (float) this.zoomLevel
        );

        this.setPreferredSize(new Dimension(
            this.pdfImage.getWidth(),
            this.pdfImage.getHeight()
        ));

        this.repaint();
    }


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

    public void setCursor(int cursorStyle){
        this.setCursor(new Cursor(cursorStyle));
    }
}

