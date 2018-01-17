package listeners;

import view.partials.partials.PdfArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PdfResizeTimerActionListener implements ActionListener {

    private PdfArea pdfArea;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public PdfResizeTimerActionListener(PdfArea pdfArea)
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
