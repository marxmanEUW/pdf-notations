package main;

import view.MainFrame;
import model.ProjectCon;

import java.io.IOException;

public class Launcher {

    // @todo Look and Feel ~ Conrad

    // @todo testing
    public static final String PATH_TO_PDF1 = "files/file1.pdf";
    public static final String PATH_TO_PDF2 = "files/file2.pdf";


    public static void main(String[] args) throws IOException
    {
        MainFrame mainFrame = new MainFrame();
        ProjectCon projectCon = new ProjectCon();
        // @todo MVC welche Teil muss welchen Teil kennen

        mainFrame.initialize(projectCon);

        mainFrame.getPdfArea().importNewPdf(PATH_TO_PDF1);
        //mainFrame.getPdfArea().importNewPdf(PATH_TO_PDF2);
    }


    public static void skdjfskjdkj()
    {

    }
}
