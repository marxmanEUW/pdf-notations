package fx_view;

import gui.Constants;
import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class FXMainFrame extends Application {

    public FXMainFrame()
    {

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle(Constants.FRAME_TITLE);

        Group root = new Group();
        Scene scene = new Scene(root, 350, 250, Color.WHITE);

        SplitPane splitPane = new SplitPane();
        splitPane.prefWidthProperty().bind(scene.widthProperty());
        splitPane.prefHeightProperty().bind(scene.heightProperty());

        VBox leftArea = new VBox(10);
        HBox rowBox = new HBox(20);
        final Text leftText = TextBuilder.create()
            .text("Left ")
            .translateX(20)
            .fill(Color.RED)
            .font(Font.font(null, FontWeight.BOLD, 20))
            .build();

        rowBox.getChildren().add(leftText);
        leftArea.getChildren().add(rowBox);

        leftArea.setAlignment(Pos.CENTER);

        SplitPane splitPane2 = new SplitPane();
        splitPane2.setOrientation(Orientation.VERTICAL);
        splitPane2.prefWidthProperty().bind(scene.widthProperty());
        splitPane2.prefHeightProperty().bind(scene.heightProperty());

        HBox centerArea = new HBox();

        final Text upperRight = TextBuilder.create()
            .text("Text")
            .x(100)
            .y(50)
            .fill(Color.RED)
            .font(Font.font(null, FontWeight.BOLD, 35))
            .translateY(50)
            .build();
        centerArea.getChildren().add(upperRight);

        HBox rightArea = new HBox();

        final Text lowerRight = TextBuilder.create()
            .text("Lower Right")
            .x(100)
            .y(50)
            .fill(Color.RED)
            .font(Font.font(null, FontWeight.BOLD, 35))
            .translateY(50)
            .build();
        rightArea.getChildren().add(lowerRight);

        splitPane2.getItems().add(centerArea);
        splitPane2.getItems().add(rightArea);

        splitPane.getItems().add(leftArea);

        splitPane.getItems().add(splitPane2);

        ObservableList<SplitPane.Divider> dividers = splitPane.getDividers();
        for (int i = 0; i < dividers.size(); i++) {
            dividers.get(i).setPosition((i + 1.0) / 3);
        }
        HBox hbox = new HBox();
        hbox.getChildren().add(splitPane);
        root.getChildren().add(hbox);

        primaryStage.setScene(scene);

        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
