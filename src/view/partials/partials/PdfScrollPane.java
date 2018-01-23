package view.partials.partials;

import model.PdfObject;
import view.partials.partials.partials.PdfArea;
import view.test.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class PdfScrollPane extends JScrollPane {


    private PdfObjectView pdfObjectView;

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
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //this.pdfArea = new PdfArea();
    }

    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.pdfObject = this.pdfObjectView.getPdfObject();
        this.pdfArea = this.pdfObjectView.getPdfArea();


        //this.pdfArea.initialize(this.pdfObject);

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

