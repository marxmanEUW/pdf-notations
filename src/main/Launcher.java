package main;

import view.MainFrame;

import java.io.File;
import java.io.IOException;

public class Launcher {

    // @todo testing
    public static final File FILE1 = new File("files/file1.pdf");
    public static final File FILE2 = new File("files/file2.pdf");
    //public static final String PATH_TO_PDF1 = "files/file1.pdf";
    //public static final String PATH_TO_PDF2 = "files/file2.pdf";
    public static final String PROJECT_NAME = "Project-Name";

    /*
     * @todo main-method must not throw an exception
     */
    public static void main(String[] args) throws IOException
    {
        MainFrame mainFrame = new MainFrame();
        mainFrame.initialize();
    }
}
