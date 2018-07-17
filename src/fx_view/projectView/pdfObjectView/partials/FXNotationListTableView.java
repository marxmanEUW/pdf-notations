package fx_view.projectView.pdfObjectView.partials;

import constants.Labels;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.MapEntry;
import model.Notation;
import model.PdfObject;

public class FXNotationListTableView extends TableView<MapEntry<Integer, Notation>> {

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

        TableColumn<MapEntry<Integer, Notation>, String> idColumn = new TableColumn<>(
            Labels.LIST_TABLE_MODEL_COLUMN_1_NAME
        );
        idColumn.prefWidthProperty().bind(
            this.widthProperty().divide(3)
        );
        // @todo hold values maybe in Observeables
        idColumn.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue().getValue().getValue(0)));

        TableColumn<MapEntry<Integer, Notation>, String> xColumn = new TableColumn<>(
            Labels.LIST_TABLE_MODEL_COLUMN_2_NAME
        );
        xColumn.prefWidthProperty().bind(
            this.widthProperty().divide(3)
        );
        xColumn.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue().getValue().getValue(1)));

        TableColumn<MapEntry<Integer, Notation>, String> yColumn = new TableColumn<>(
            Labels.LIST_TABLE_MODEL_COLUMN_3_NAME
        );
        yColumn.prefWidthProperty().bind(
            this.widthProperty().divide(3)
        );
        yColumn.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue().getValue().getValue(2)));

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
            this.refresh();

            if (this.getItems().size() == 0 && this.getPdfObject().getListOfNotationsReadOnly().size() > 0)
            {
                this.setItems(FXCollections.observableList(this.getPdfObject().getListOfNotationsReadOnly()));
            }

        }
    }

    /*
     * @author  marxmanEUW
     */
    private void initializeData()
    {
        if(this.getPdfObject() == null)
        {
            this.getItems().clear();
        }
        else
        {
            this.setItems(this.getPdfObject().getListOfNotationsReadOnly());
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
        MapEntry<Integer, Notation> notationToSelect = null;

        for (int i = 0; i < this.getItems().size(); i++)
        {
            if (this.getItems().get(i).getValue().getId() == notationId)
            {
                notationToSelect = this.getItems().get(i);
                rowId = i;
                break;
            }
        }

        // @todo testing output
        System.out.println("NotationListTableView Selected Row Id: " + rowId);

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
