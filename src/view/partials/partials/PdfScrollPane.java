package view.partials.partials;

import model.PdfObject;
import view.partials.partials.partials.PdfArea;

import javax.swing.*;
import java.awt.*;

public class PdfScrollPane extends JScrollPane {

    private PdfArea pdfArea;
    private PdfObject pdfObject;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public PdfScrollPane()
    {
        this.pdfArea = new PdfArea();

        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public void initialize(PdfObject pdfObject)
    {
        this.pdfObject = pdfObject;

        this.pdfArea.initialize(this.pdfObject);

        this.getViewport().add(this.pdfArea);
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public PdfArea getPdfArea()
    {
        return pdfArea;
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
        this.pdfArea.importNewPdf(sourcePath);
        this.getViewport().revalidate();
    }
}

