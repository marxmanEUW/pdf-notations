package view.partials.partials;

import model.ProjectCon;

import javax.swing.*;
import java.awt.*;

public class PdfScrollPane extends JScrollPane {

    private PdfArea pdfArea;
    private ProjectCon projectCon;

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

    public void initialize(ProjectCon projectCon)
    {
        this.projectCon = projectCon;

        this.pdfArea.initialize(this.projectCon);

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

