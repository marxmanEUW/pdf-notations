package view.partials.partials;

import model.ProjectCon;

import javax.swing.*;
import java.awt.*;

public class PdfScrollPane extends JScrollPane {

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

        this.pdfArea = new PdfArea(new ProjectCon());
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

