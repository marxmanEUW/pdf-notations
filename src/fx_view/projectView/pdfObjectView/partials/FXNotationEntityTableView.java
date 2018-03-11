package fx_view.projectView.pdfObjectView.partials;

import constants.Environment;
import constants.Labels;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Entity;
import model.PdfObject;

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

        TableColumn propertyColumn = new TableColumn(
            Labels.ENTITY_TABLE_MODEL_COLUMN_1_NAME
        );
        propertyColumn.prefWidthProperty().bind(
            this.widthProperty().divide(2)
        );
        propertyColumn.setCellValueFactory(
            new PropertyValueFactory<>("valueName")
        );

        TableColumn valueColumn = new TableColumn(
            Labels.ENTITY_TABLE_MODEL_COLUMN_2_NAME
        );
        valueColumn.prefWidthProperty().bind(
            this.widthProperty().divide(2)
        );
        valueColumn.setCellValueFactory(
            new PropertyValueFactory<>("value")
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
            this.setItems(
                FXCollections.observableArrayList(
                    this.getPdfObject().getSelectedNotationAsObservableList()));
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
