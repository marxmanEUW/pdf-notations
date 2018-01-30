package factories;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public abstract class DialogFactory {

    public static final int FILE_TYPE_PDF = 0;
    public static final int FILE_TYPE_PDFNOT = 1;

    private static final String FILE_TYPE_ARRAY[][] = {
        {"PDF (.*pdf)", "pdf"},
        {"PDF Notations (.*pdfnot)", "pdfnot"}
    };

    /*
     * @author marxmanEUW
     */
    public static File getFileFromOpenDialog(int fileType)
    {
        File openFile = null;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter(FILE_TYPE_ARRAY[fileType][0], FILE_TYPE_ARRAY[fileType][1]));

        int state = fileChooser.showOpenDialog(null);

        if (state == JFileChooser.APPROVE_OPTION)
        {
            openFile = fileChooser.getSelectedFile();
            System.out.println( openFile.getAbsolutePath() );
        }

        return openFile;
    }


    /*
     * @author marxmanEUW
     */
    public static File getFileFromSaveDialog(int fileType)
    {
        String fileExtension = FILE_TYPE_ARRAY[fileType][1];

        File saveFile = null;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter(FILE_TYPE_ARRAY[fileType][0], fileExtension));
        fileChooser.setSelectedFile(new File("newFile." + fileExtension));

        int state = fileChooser.showSaveDialog(null);

        if (state == JFileChooser.APPROVE_OPTION)
        {
            saveFile = fileChooser.getSelectedFile();

            if (!saveFile.getAbsolutePath().endsWith("." + fileExtension))
            {
                saveFile = new File(saveFile.getAbsolutePath() + "." + fileExtension);
            }

            System.out.println( saveFile.getAbsolutePath() );
        }

        return saveFile;
    }
}
