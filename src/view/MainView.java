package view;

import listeners.PdfAreaMouseListener;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/*
 * @todo !obsolete Klasse
 */
public class MainView extends JFrame {

    public static final String PATH_TO_PDF = "files/file1.pdf";

    private PdfAreaMouseListener pdfAreaMouseListener;

    private JScrollPane scrollPane;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public MainView()
    {

    }


    public void initialise(PdfAreaMouseListener pdfAreaMouseListener)
    {
        this.pdfAreaMouseListener = pdfAreaMouseListener;


        this.setup();

        //this.importWithPdfRenderer();
        this.importWithPdfBox();
    }

    public void paint(Graphics graphics)
    {

    }


    /*
     * #########################################################################
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    private void setup()
    {
        this.setTitle("MyTitle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 500));
        this.pack();
    }





    private void importWithPdfBox()
    {
        try {
            File pdfFile = new File(PATH_TO_PDF);
            PDDocument pdfDocument = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(pdfDocument);
            BufferedImage pdfImage = renderer.renderImage(0);
            pdfDocument.close();

            JLabel label = new JLabel(new ImageIcon(pdfImage));
            label.addMouseListener(this.pdfAreaMouseListener);

            this.scrollPane = new JScrollPane(
                label,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
            );

            this.getContentPane().add(scrollPane);
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
