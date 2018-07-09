package fx_view.projectView.pdfObjectView.partials;

import constants.Environment;
import constants.Labels;
import fx_handler.FXNotationEntityCellHandler;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import model.Entity;
import model.PdfObject;

/*import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
*/

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class FXNotationEntityTableView extends TableView<Entity> {

    private FXPdfObjectView pdfObjectView;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Constructs the NotationEntityScrollPane which shows the information of
     *          the selected notation.
     */
    public FXNotationEntityTableView()
    {
    }


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Initializes the NotationEntityScrollPane.
     */
    public void initialize(FXPdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.setPlaceholder(
            new Label(Labels.NOTATION_ENTITY_TABLE_PLACE_HOLDER_TEXT)
        );
        this.prefHeightProperty().bind(
            this.pdfObjectView.heightProperty().multiply(
                this.pdfObjectView.getNotationSplitPane().getDividers()
                    .get(0).positionProperty()
                    .subtract(1).multiply(-1)
                    .subtract(Labels.NOTATION_SPLIT_PANE_HEIGHT_CORRECTION)
            )
        );

        this.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory =
            new Callback<TableColumn, TableCell>() {
                public TableCell call(TableColumn p) {
                    return new EditableCell();
                }
            };

        TableColumn propertyColumn = new TableColumn(
            Labels.ENTITY_TABLE_MODEL_COLUMN_1_NAME
        );
        propertyColumn.prefWidthProperty().bind(
            this.widthProperty().divide(2)
        );
        propertyColumn.setSortable(false);
        propertyColumn.setCellValueFactory(
            new PropertyValueFactory<>("valueName")
        );


        TableColumn valueColumn = new TableColumn(
            Labels.ENTITY_TABLE_MODEL_COLUMN_2_NAME
        );
        valueColumn.prefWidthProperty().bind(
            this.widthProperty().divide(2)
        );
        valueColumn.setSortable(false);
        valueColumn.setCellValueFactory(
            new PropertyValueFactory<Entity, String>("value"));
        valueColumn.setCellFactory(cellFactory);
        valueColumn.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<Entity, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Entity, String> t) {
                    ((Entity) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                    ).setValue(t.getNewValue());
                    System.out.println(t.getNewValue());
                }
            }
        );


        this.getColumns().addAll(propertyColumn, valueColumn);
    }


    /*
     * #########################################################################
     * #                    Public  Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void updateTable()
    {

        if(this.getPdfObject() == null ||
            this.getPdfObject().getSelectedNotationId()
                == Environment.SELECTED_NOTATION_NULL_VALUE
            )
        {
            this.getItems().clear();
        }
        else
        {
            //this.setItems(this.getPdfObject().getSelectedNotationAsObservableList());
            this.setItems(this.getPdfObject().getSelectedNotation().getListOfEntities());
        }
    }

    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    private PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }
}
