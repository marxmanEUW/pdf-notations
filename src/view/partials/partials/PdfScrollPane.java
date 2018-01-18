package view.partials.partials;

import main.Launcher;
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
    public PdfScrollPane()
    {
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.pdfArea = new PdfArea(new ProjectCon());

        this.getViewport().add(this.pdfArea);
    }


    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
    }


    public void importNewPdf(String sourcePath)
    {
        this.pdfArea.importNewPdf(sourcePath);
        this.getViewport().revalidate();
    }
}

