package main;

import gui.MainFrame;
import java.io.IOException;

public class Launcher {

    // @todo testing
    public static final String PATH_TO_PDF1 = "";
    public static final String PATH_TO_PDF2 = "";


    public static void main(String[] args) throws IOException
    {
        MainFrame mainFrame = new MainFrame();

        mainFrame.initialize();

        mainFrame.getPdfArea().importNewPdf(PATH_TO_PDF1);
        //mainFrame.getPdfArea().importNewPdf(PATH_TO_PDF2);
    }
}
