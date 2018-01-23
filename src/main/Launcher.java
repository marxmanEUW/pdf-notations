package main;

import model.Project;
import view.MainFrame;
import model.PdfObject;

import java.io.IOException;

public class Launcher {

    // @todo Look and Feel ~ Conrad

    // @todo testing
    public static final String PATH_TO_PDF1 = "files/file1.pdf";
    public static final String PATH_TO_PDF2 = "files/file2.pdf";
    public static final String PROJECT_NAME = "Project-Name";


    public static void main(String[] args) throws IOException
    {
        MainFrame mainFrame = new MainFrame();
        Project project = new Project();
        project.initialize(PROJECT_NAME);
        //PdfObject pdfObject = new PdfObject();
        // @todo MVC welche Teil muss welchen Teil kennen

        mainFrame.initialize(project);

        mainFrame.pdfObjectView.getPdfArea().importNewPdf(PATH_TO_PDF1);

        //mainFrame.centerSplitPane.pdfScrollPane.importNewPdf(PATH_TO_PDF1);
    }
}
