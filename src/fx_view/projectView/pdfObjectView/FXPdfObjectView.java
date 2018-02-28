package fx_view.projectView.pdfObjectView;

import fx_view.projectView.pdfObjectView.partials.FXPdfArea;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public class FXPdfObjectView extends SplitPane {

    // Left part of the center component
    private FXPdfArea pdfArea;

    public FXPdfObjectView()
    {
        this.setOrientation(Orientation.HORIZONTAL);
    }

    public void initialize()
    {
        Label label2 = new Label("Label 2");

        this.pdfArea = new FXPdfArea();
        this.pdfArea.initialize();

        this.getItems().add(this.pdfArea);
        this.getItems().add(label2);
    }

    public FXPdfArea getPdfArea()
    {
        return pdfArea;
    }
}
