package factories;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public abstract class DialogFactory {

    public static File getFileFromOpenDialog(String fileType, String fileExtension)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter(fileType, fileExtension));
        int state = fileChooser.showOpenDialog(null);

        if (state == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            System.out.println( file.getAbsolutePath() );
        } else
        {
            System.out.println( "Open Dialog: Cancelled" );
        }

        return null;
    }

    public static File getFileFromSaveDialog(String fileType, String fileExtension)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter(fileType, fileExtension));
        fileChooser.setSelectedFile(new File("newFile." + fileExtension));
        int state = fileChooser.showSaveDialog(null);

        if (state == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            System.out.println( file.getAbsolutePath() );
            return file;
        } else
        {
            System.out.println( "Save Dialog: Cancelled" );
            return null;
        }
    }
}
