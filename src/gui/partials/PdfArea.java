package gui.partials;

import controller.PdfAreaMouseListener;
import handlers.PdfHandler;
import org.apache.pdfbox.rendering.ImageType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PdfArea extends JLabel {

    private final double MINIMUM_ZOOM_FACTOR = 0.5;
    private final double MAXIMUM_ZOOM_FACTOR = 1.5;

    private PdfAreaMouseListener pdfAreaMouseListener;

    BufferedImage pdfImage;
    Graphics2D graphics2D;
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
    // @todo path als parameter uebergeben statt als konstante
    public void importNewPdf(String sourcePath)
    {
        this.pdfImage = PdfHandler.renderPdfAsImage(sourcePath);

        /*
         * @todo !WICHTIG: unbedingt testen, ob die alten Images wirklich geloescht werden
         * @todo           (Ueberpruefung des RAM-Verbrauchs)
         */
        this.setIcon(new ImageIcon(this.pdfImage));
    }


    public void resizePdf(double zoomChange)
    {
        if (((this.zoomLevel + zoomChange) > this.MINIMUM_ZOOM_FACTOR)
            && ((this.zoomLevel + zoomChange) < this.MAXIMUM_ZOOM_FACTOR)
            && (this. pdfImage != null)) {

            double imageWidth = (double) this.pdfImage.getWidth();
            double imageHeight = (double) this.pdfImage.getHeight();
            this.zoomLevel += zoomChange;

            this.pdfImage = new BufferedImage(
                (int) (imageWidth * this.zoomLevel),
                (int) (imageHeight * this.zoomLevel),
                BufferedImage.TYPE_INT_ARGB  // @todo noch nach richtigem Type suchen
            );
            this.setIcon(new ImageIcon(this.pdfImage));
        }
    }
}
