package timer;

import view.projectView.pdfObjectView.partials.PdfArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PdfRenderingTimer implements ActionListener {

    private PdfArea pdfArea;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public PdfRenderingTimer(PdfArea pdfArea)
    {
        this.pdfArea = pdfArea;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        this.pdfArea.rerenderPdf();
    }
}
