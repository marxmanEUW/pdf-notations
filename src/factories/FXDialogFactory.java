package factories;

import constants.Environment;
import constants.Labels;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public abstract class FXDialogFactory {

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-07 (marxmanEUW)  created
     * @brief   Shows a OpenFileDialog and returns the selected file
     *          or returns null if no file was selected.
     */
    public static File getFileFromOpenDialog(int fileType)
    {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add( new FileChooser.ExtensionFilter(
            Environment.FILE_TYPE_ARRAY[fileType][0],
            Environment.FILE_TYPE_ARRAY[fileType][1])
        );

        File openFile = fileChooser.showOpenDialog(null);

        return openFile;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-07 (marxmanEUW)  created
     * @brief   Shows a SaveFileDialog and returns the selected file
     *          or returns null if no file was selected.
     */
    public static File getFileFromSaveDialog(int fileType)
    {
        String fileExtension = Environment.FILE_TYPE_ARRAY[fileType][1];

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add( new FileChooser.ExtensionFilter(
            Environment.FILE_TYPE_ARRAY[fileType][0],
            fileExtension)
        );

        fileChooser.setInitialFileName("newFile." + fileExtension);

        File saveFile = fileChooser.showSaveDialog(null);

        if (saveFile != null)
        {
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
     * @author  marxmanEUW
     * @changes
     *      2018-03-07 (marxmanEUW)  created
     * @brief   Shows the Waring-At-Close-Dialog whenever a project or
     *          the entire window is closed.
     */
    public static Optional<ButtonType> showWarningAtCloseDialog()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(Labels.WARNING_TITLE);
        alert.setHeaderText(Labels.WARNING_TITLE);
        alert.setContentText(Labels.WARNING_TEXT);
        return alert.showAndWait();
    }
}
