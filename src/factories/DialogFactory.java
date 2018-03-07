package factories;

import constants.Environment;
import constants.Labels;
import listeners.EditorPaneListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public abstract class DialogFactory {

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Shows a OpenFileDialog and returns the selected file
     *          or returns null if no file was selected.
     */
    public static File getFileFromOpenDialog(int fileType)
    {
        File openFile = null;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter(
            Environment.FILE_TYPE_ARRAY[fileType][0],
            Environment.FILE_TYPE_ARRAY[fileType][1])
        );

        int state = fileChooser.showOpenDialog(null);

        if (state == JFileChooser.APPROVE_OPTION)
        {
            openFile = fileChooser.getSelectedFile();
        }

        return openFile;
    }


    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Shows a SaveFileDialog and returns the selected file
     *          or returns null if no file was selected.
     */
    public static File getFileFromSaveDialog(int fileType)
    {
        String fileExtension = Environment.FILE_TYPE_ARRAY[fileType][1];

        File saveFile = null;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter(
            Environment.FILE_TYPE_ARRAY[fileType][0],
            fileExtension)
        );
        fileChooser.setSelectedFile(
            new File("newFile." + fileExtension)
        );

        int state = fileChooser.showSaveDialog(null);

        if (state == JFileChooser.APPROVE_OPTION)
        {
            saveFile = fileChooser.getSelectedFile();

            if (!saveFile.getAbsolutePath().endsWith("." + fileExtension))
            {
                saveFile = new File(
                    saveFile.getAbsolutePath() + "." + fileExtension
                );
            }
        }

        return saveFile;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-19 (yxyxD)  created
     * @brief   Shows the Waring-At-Close-Dialog whenever a project or
     *          the entire window is closed.
     */
    public static int showWarningAtCloseDialog()
    {
        return JOptionPane.showConfirmDialog(
            null,
            Labels.WARNING_TEXT,
            Labels.WARNING_TITLE,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-19 (yxyxD)  created
     *      2018-02-20 (AbellaMort) Changed to EditorPane with Hyperlinks
     * @brief   Shows the About-Dialog.
     */
    public static void showAboutDialog()
    {

        JEditorPane htmlPane = new JEditorPane(
            "text/html",
            Labels.ABOUT_TEXT
        );

        htmlPane.setEditable(false);

        htmlPane.addHyperlinkListener(new EditorPaneListener());
        htmlPane.setBackground(Color.WHITE);

        JOptionPane.showMessageDialog(
            null,
            htmlPane,
            Labels.ABOUT_TITLE,
            JOptionPane.PLAIN_MESSAGE
        );

    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-20 (marxmanEUW)  created
     * @brief   Shows the Waring-That-Value-Is-No-Int dialog.
     */
    public static void showWarningThatValueIsNoInt(String value)
    {
        JOptionPane.showMessageDialog(
            null,
            Labels.INTEGER_TEXT + value,
            Labels.INTEGER_TITLE,
            JOptionPane.WARNING_MESSAGE
        );
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-23 (marxmanEUW)  created
     * @brief   Shows the Waring-Delete-Notation dialog.
     */
    public static int showWarningDeleteNotation(int value)
    {
        return JOptionPane.showConfirmDialog(
            null,
            Labels.DELETE_NOTATION_TEXT + value,
            Labels.DELETE_NOTATION_TITLE,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
    }

    /*
     * @author AbellaMort
     * @changes
     *      2018-03-02 (AbellaMort) created
     * @brief Shows the ErrorDialog
     *
     */

    public static void showErrorDialog(String errorMessage)
    {
        JOptionPane.showMessageDialog(
            null,
            errorMessage,
            Labels.ERROR_TITLE,
            JOptionPane.PLAIN_MESSAGE
        );
    }

}
