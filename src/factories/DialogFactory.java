package factories;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public abstract class DialogFactory {

    public static File getFileFromOpenDialog(String fileType, String fileExtension)
    {
        File openFile = null;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter(fileType, fileExtension));

        int state = fileChooser.showOpenDialog(null);

        if (state == JFileChooser.APPROVE_OPTION)
        {
            openFile = fileChooser.getSelectedFile();
            System.out.println( openFile.getAbsolutePath() );
        }

        return openFile;
    }

    public static File getFileFromSaveDialog(String fileType, String fileExtension)
    {
        File saveFile = null;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter(fileType, fileExtension));
        fileChooser.setSelectedFile(new File("newFile." + fileExtension));

        int state = fileChooser.showSaveDialog(null);

        if (state == JFileChooser.APPROVE_OPTION)
        {
            saveFile = fileChooser.getSelectedFile();
            System.out.println( saveFile.getAbsolutePath() );
        }

        return saveFile;
    }
}
