package fx_view.projectView.pdfObjectView.partials;

import constants.Environment;
import fx_view.projectView.pdfObjectView.FXPdfObjectView;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;

public class FXNotationSplitPane extends SplitPane {

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW)  created
     * @brief   Constructs the NotationSplitPane which contains ListScrollPane
     *          and EntityScrollPane.
     */
    public FXNotationSplitPane()
    {
        this.setOrientation(Orientation.VERTICAL);
        this.setDividerPositions(Environment.NOTATION_SPLIT_PANE_DIVIDER_LOCATION);
    }


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Initialises the NotationSplitPane.
     */
    public void initialize(FXPdfObjectView pdfObjectView)
    {
        this.getItems().add(pdfObjectView.getNotationListTableView());
        //this.getItems().add(pdfObjectView.getNotationEntityScrollPane());
        this.getItems().add(pdfObjectView.getNotationEntityTableView());
    }
}
