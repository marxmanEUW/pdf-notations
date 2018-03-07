package view.projectView.pdfObjectView.partials;

import constants.Environment;

import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;

public class PdfScrollPane extends JScrollPane {


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

        this.getVerticalScrollBar().setUnitIncrement(
            Environment.JSCROLLPANE_SCROLLBAR_UNIT_INCREMENT
        );
        this.getHorizontalScrollBar().setUnitIncrement(
            Environment.JSCROLLPANE_SCROLLBAR_UNIT_INCREMENT
        );
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
        this.getViewport().add(pdfObjectView.getPdfArea());
    }
}

