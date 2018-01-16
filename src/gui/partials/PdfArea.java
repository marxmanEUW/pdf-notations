package gui.partials;

import controller.PdfAreaMouseListener;
import handlers.PdfHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class PdfArea extends JPanel {

    private final double MINIMUM_ZOOM_FACTOR = 0.5;
    private final double MAXIMUM_ZOOM_FACTOR = 1.5;

    private PdfAreaMouseListener pdfAreaMouseListener;

    private BufferedImage pdfImage;
    private String pdfImagePath;
    private int initialImageWidth;
    private int initialImageHeight;
    private double zoomLevel;


    public PdfArea()
    {
        this.pdfAreaMouseListener = new PdfAreaMouseListener(this);
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


}

