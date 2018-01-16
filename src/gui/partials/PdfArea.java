package gui.partials;

import controller.PdfAreaMouseListener;
import handlers.PdfHandler;
import main.Launcher;
import model.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PdfArea extends JPanel {

    private final double MINIMUM_ZOOM_FACTOR = 0.5;
    private final double MAXIMUM_ZOOM_FACTOR = 1.5;

    private PdfAreaMouseListener pdfAreaMouseListener;
    private Project project;

    BufferedImage pdfImage;
    // Graphics2D graphics2D;
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
        this.pdfImage = PdfHandler.renderPdfAsImage(sourcePath);
        this.setPreferredSize(new Dimension(
            pdfImage.getWidth(),
            pdfImage.getHeight())
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
                g2.fillOval(point.x, point.y, 20, 20);
            }
            this.repaint();
        }

    }

    public void resizePdf(double zoomChange)
    {
        if (((this.zoomLevel + zoomChange) > this.MINIMUM_ZOOM_FACTOR)
            && ((this.zoomLevel + zoomChange) < this.MAXIMUM_ZOOM_FACTOR)
            && (this.pdfImage != null)) {

            /*
            double imageWidth = (double) this.pdfImage.getWidth();
            double imageHeight = (double) this.pdfImage.getHeight();
            this.zoomLevel += zoomChange;

            this.pdfImage = new BufferedImage(
                (int) (imageWidth * this.zoomLevel),
                (int) (imageHeight * this.zoomLevel),
                BufferedImage.TYPE_INT_ARGB  // @todo noch nach richtigem Type suchen
            );
            */

            // das geht, aber nicht schnell => neues Rendering bei
            // jedem Zoomvorgang
            /*
            this.zoomLevel += zoomChange;
            this.pdfImage = PdfHandler.renderPdfWithZoom(
                Launcher.PATH_TO_PDF1,
                (float) this.zoomLevel
            );
            this.setPreferredSize(new Dimension(
                this.pdfImage.getWidth(),
                this.pdfImage.getHeight()
            ));
            */


            this.repaint();
        }
    }


}

