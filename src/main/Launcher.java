package main;

import view.MainFrame;

import java.io.File;

public class Launcher {

    // @todo testing
    public static final File FILE1 = new File("files/file1.pdf");
    public static final File FILE2 = new File("files/file2.pdf");

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

        mainFrame.getPdfObjectView().openProject(FILE1);
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief
     */
}
