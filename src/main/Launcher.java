package main;

import view.MainFrame;

import java.io.File;

public class Launcher {

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Starting point of the program.
     */
    public static void main(String[] args)
    {
        MainFrame mainFrame = new MainFrame();
        mainFrame.initialize();

        //@todo for testing purposes
        mainFrame.getPdfObjectView().openProject(new File("files/file1.pdf"));
    }
}
