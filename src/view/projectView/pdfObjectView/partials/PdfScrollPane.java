package view.projectView.pdfObjectView.partials;


import model.PdfObject;

import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;


public class PdfScrollPane extends JScrollPane {

    private PdfObjectView pdfObjectView;
    private PdfObject pdfObject;

    private PdfArea pdfArea;


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
    }


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.pdfObject = this.pdfObjectView.getPdfObject();
        this.pdfArea = this.pdfObjectView.getPdfArea();

        this.getViewport().add(this.pdfArea);
    }
}

