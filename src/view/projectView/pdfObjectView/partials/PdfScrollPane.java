package view.projectView.pdfObjectView.partials;


import model.PdfObject;

import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;


public class PdfScrollPane extends JScrollPane {

    private PdfObjectView pdfObjectView;

    private PdfArea pdfArea;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Constructs a PdfScrollPane which holds the PdfArea.
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Initialises the PdfScrollPane
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.pdfArea = this.pdfObjectView.getPdfArea();

        this.getViewport().add(this.pdfArea);
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    private PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }
}

