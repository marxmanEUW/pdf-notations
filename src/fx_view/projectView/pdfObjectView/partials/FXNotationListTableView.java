package fx_view.projectView.pdfObjectView.partials;

import constants.Labels;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        this.initializeData();
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
            // @todo real error, items get deleted when imported again ??
            ObservableList<Notation> oldItems = this.getItems();
            ObservableList<Notation> newItems = FXCollections.observableArrayList(this.getPdfObject().getListOfNotationsAsList());

            boolean same = oldItems.equals(newItems);
            System.out.println("FXNotationListTableView oldItems (" + oldItems.size() + ") = newItems(" + newItems.size() + "): " + same);

            this.refresh();

            if (oldItems.size() == 0 && newItems.size() > 0)
            //if (oldItems.size() < newItems.size())
            {
                this.setItems(FXCollections.observableArrayList(this.getPdfObject().getListOfNotations().values()));
            }

        }
    }

    // @todo testing
    public void initializeData()
    {
        if(this.getPdfObject() == null)
        {
            this.getItems().clear();
        }
        else
        {
            // @todo real error, items get deleted when imported again ??
            ObservableList<Notation> newItems = FXCollections.observableArrayList(this.getPdfObject().getListOfNotationsAsList());
            this.setItems(newItems);
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
