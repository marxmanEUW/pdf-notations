package fx_view.projectView.pdfObjectView.partials;

import constants.Labels;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Notation;
import model.PdfObject;

public class FXNotationListTableView extends TableView<Notation> {

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
     * @brief   Constructs the NotationListScrollPane which lists every notation of the
     *          PdfObject.
     */
    public FXNotationListTableView()
    {
        //this.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        //this.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */

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

        this.setPlaceholder(
            new Label(Labels.NOTATION_LIST_TABLE_PLACE_HOLDER_TEXT)
        );
        this.prefHeightProperty().bind(
            this.pdfObjectView.heightProperty().multiply(
                this.pdfObjectView.getNotationSplitPane().getDividers()
                    .get(0).positionProperty()
                    .subtract(Labels.NOTATION_SPLIT_PANE_HEIGHT_CORRECTION)
            )
        );

        this.getSelectionModel().selectedItemProperty().
            addListener(this.pdfObjectView.getNotationListTableChangeListener()
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

        this.getColumns().addAll(idColumn, xColumn, yColumn);
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
        if(this.getPdfObject() == null)
        {
            this.getItems().clear();
        }
        else
        {
            this.setItems(
                FXCollections.observableArrayList(
                    this.getPdfObject().getListOfNotationsAsList()));
        }
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Sets the selected fow of the NotationListTable.
     */
    public void setSelectedRow(int notationId)
    {
        int rowId = notationId;

        for (int i = 0; i < this.getItems().size(); i++)
        {
            if (notationId == this.getItems().get(i).getId())
            {
                rowId = i;
                break;
            }
        }

        this.getSelectionModel().select(rowId);
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Deselects every row of the NotationListTable.
     */
    public void deselectRow()
    {
        this.getSelectionModel().clearSelection();
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
