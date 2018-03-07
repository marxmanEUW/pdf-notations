package view.projectView.pdfObjectView.partials;

import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class ListScrollPane extends JScrollPane {

    private PdfObjectView pdfObjectView;

    private ListTableModel listTableModel;
    private ListSelectionModel listSelectionModel;

    private JTable notationListTable;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Constructs the ListScrollPane which lists every notation of the
     *          PdfObject.
     */
    public ListScrollPane()
    {
        this.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        this.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        );

        this.notationListTable = new JTable();

        this.listSelectionModel = this.notationListTable.getSelectionModel();
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
     * @brief   Initializes the ListScrollPane.
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.listTableModel = this.pdfObjectView.getListTableModel();

        this.notationListTable.setModel(this.listTableModel);

        this.listSelectionModel.addListSelectionListener(
            this.pdfObjectView.getNotationListSelectionListener()
        );
        this.notationListTable.setSelectionModel(this.listSelectionModel);
        this.notationListTable.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        this.getViewport().add(notationListTable);
    }

    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the NotationListTable of the ListScrollPane.
     */
    public JTable getNotationListTable()
    {
        return this.notationListTable;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Repaints the ListSCrollPane.
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }


    /*
     * #########################################################################
     * #                    Public Methods                                     #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Updates the content of the NotationListTable.
     */
    public void updateTable()
    {
        this.listTableModel.fireTableDataChanged();
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the selected fow of the NotationListTable.
     */
    public void setSelectedRow(int notationId)
    {
        int rowId = notationId;

        for (int i = 0; i < this.getPdfObject().getListOfNotations().size();
             i++)
        {
            if (notationId ==
                (int) this.listTableModel.getValueAt(i, 0))
            {
                rowId = i;
                break;
            }
        }

        this.notationListTable.setRowSelectionInterval(rowId, rowId);
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Deselects every row of the NotationListTable.
     */
    public void deselectRow()
    {
        this.notationListTable.clearSelection();
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfObject of the PdfObjectView.
     */
    private PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }
}
