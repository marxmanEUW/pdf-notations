package fx_view.projectView.pdfObjectView.partials;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;

import java.io.File;

public class FXPdfArea extends ScrollPane {

    private final static String PATH_TO_IMAGE = "rtbvbls2fojz.jpg";

    private ImageView pdfImage;


    public void initialize()
    {
        File file = new File(PATH_TO_IMAGE);
        this.pdfImage = new ImageView(file.toURI().toString());
        this.setContent(this.pdfImage);
    }
}
