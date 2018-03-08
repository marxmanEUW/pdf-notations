package factories;

import constants.Environment;
import constants.Labels;
import fx_handler.FXHyperlinkChangeListener;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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

        return fileChooser.showOpenDialog(null);
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
        Alert warningAlert = new Alert(Alert.AlertType.CONFIRMATION);
        warningAlert.setTitle(Labels.WARNING_TITLE);
        warningAlert.setHeaderText(Labels.WARNING_TITLE);
        warningAlert.setContentText(Labels.WARNING_TEXT);
        return warningAlert.showAndWait();
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-08 (marxmanEUW)  created
     * @brief   Shows the About-Dialog.
     */
    public static void showAboutDialog(FXHyperlinkChangeListener hyperlinkChangeListener)
    {
        Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
        aboutAlert.setTitle(Labels.ABOUT_TITLE);
        aboutAlert.setHeaderText(Labels.ABOUT_TITLE);

        WebView aboutWebView = new WebView();
        WebEngine aboutWebEngine = aboutWebView.getEngine();

        aboutWebEngine.loadContent(Labels.ABOUT_TEXT);

        hyperlinkChangeListener.setWebEngine(aboutWebEngine);
        aboutWebEngine.getLoadWorker().stateProperty().addListener(hyperlinkChangeListener);

        aboutWebView.setPrefSize(400, 300);

        aboutAlert.getDialogPane().setContent(aboutWebView);
        aboutAlert.showAndWait();
    }
}
