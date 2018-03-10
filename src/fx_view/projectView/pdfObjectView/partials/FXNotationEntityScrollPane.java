package fx_view.projectView.pdfObjectView.partials;

import constants.Environment;
import constants.Labels;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Entity;
import model.PdfObject;

public class FXNotationEntityScrollPane extends ScrollPane {

    private FXPdfObjectView pdfObjectView;

    private TableView<Entity> notationEntityTable;

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
    public FXNotationEntityScrollPane()
    {
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
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

        this.notationEntityTable = new TableView<>();
        this.notationEntityTable.setPlaceholder(
            new Label(Labels.NOTATION_ENTITY_TABLE_PLACE_HOLDER_TEXT)
        );
        this.notationEntityTable.prefHeightProperty().bind(
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

        this.notationEntityTable.getColumns().addAll(propertyColumn, valueColumn);

        this.setContent(notationEntityTable);
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
        if(this.getPdfObject() == null) { return; }
        if(this.getPdfObject().getSelectedNotationId() == Environment.SELECTED_NOTATION_NULL_VALUE)
        {
            this.notationEntityTable.getItems().clear();
        }
        else
        {
            this.notationEntityTable.setItems(
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
