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
import model.Notation;
import model.PdfObject;

public class FXNotationListScrollPane extends ScrollPane {

    private FXPdfObjectView pdfObjectView;

    private TableView<Notation> notationListTable;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Constructs the NotationListScrollPane which lists every notation of the
     *          PdfObject.
     */
    public FXNotationListScrollPane()
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
     * @brief   Initializes the NotationListScrollPane.
     */
    public void initialize(FXPdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.notationListTable = new TableView<>();
        this.notationListTable.setPlaceholder(
            new Label(Labels.NOTATION_LIST_TABLE_PLACE_HOLDER_TEXT)
        );
        this.notationListTable.prefHeightProperty().bind(
            this.pdfObjectView.heightProperty().multiply(
                this.pdfObjectView.getNotationSplitPane().getDividers()
                    .get(0).positionProperty()
                    .subtract(Labels.NOTATION_SPLIT_PANE_HEIGHT_CORRECTION)
            )
        );

        TableColumn idColumn = new TableColumn(
            Labels.LIST_TABLE_MODEL_COLUMN_1_NAME
        );
        idColumn.prefWidthProperty().bind(
            this.widthProperty().divide(3)
        );
        idColumn.setCellValueFactory(
            new PropertyValueFactory<>("id")
        );

        TableColumn xColumn = new TableColumn(
            Labels.LIST_TABLE_MODEL_COLUMN_2_NAME
        );
        xColumn.prefWidthProperty().bind(
            this.widthProperty().divide(3)
        );
        xColumn.setCellValueFactory(
            new PropertyValueFactory<>("x")
        );

        TableColumn yColumn = new TableColumn(
            Labels.LIST_TABLE_MODEL_COLUMN_3_NAME
        );
        yColumn.prefWidthProperty().bind(
            this.widthProperty().divide(3)
        );
        yColumn.setCellValueFactory(
            new PropertyValueFactory<>("y")
        );

        this.notationListTable.getColumns().addAll(idColumn, xColumn, yColumn);

        this.setContent(notationListTable);
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
            this.notationListTable.getItems().clear();
        }
        else
        {
            this.notationListTable.setItems(
                FXCollections.observableArrayList(
                    this.getPdfObject().getListOfNotationsAsList()));
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