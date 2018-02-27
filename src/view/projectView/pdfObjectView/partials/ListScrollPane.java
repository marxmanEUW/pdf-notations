package view.projectView.pdfObjectView.partials;

import listeners.NotationListSelectionListener;
import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class ListScrollPane extends JScrollPane {

    private PdfObjectView pdfObjectView;

    private ListTableModel listTableModel;
    private ListSelectionModel listSelectionModel;
    private NotationListSelectionListener notationListSelectionListener;

    private JTable notationListTable;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public ListScrollPane()
    {
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.notationListTable = new JTable();

        this.listSelectionModel = this.notationListTable.getSelectionModel();
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.listTableModel = this.pdfObjectView.getListTableModel();
        this.notationListSelectionListener =
            this.pdfObjectView.getNotationListSelectionListener();



        this.notationListTable.setModel(this.listTableModel);

        this.listSelectionModel.addListSelectionListener(
            this.notationListSelectionListener
        );
        this.notationListTable.setSelectionModel(this.listSelectionModel);
        this.notationListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.getViewport().add(notationListTable);
    }

    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public JTable getNotationListTable()
    {
        return notationListTable;
    }

    /*
     * #########################################################################
     * #                    public methods                                     #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void updateTable()
    {
        this.listTableModel.fireTableDataChanged();
    }


    /*
     * @author  marxmanEUW
     */
    public void setSelectedRow(int notationId)
    {
        int rowId = notationId;

        for (int i = 0; i < this.getPdfObject().getListOfNotations().size(); i++)
        {
            if (notationId == (int) this.listTableModel.getValueAt(i, 0))
            {
                rowId = i;
                break;
            }
        }

        this.notationListTable.setRowSelectionInterval(rowId, rowId);
    }


    /*
     * @author  marxmanEUW
     */
    public void unselectRow()
    {
        this.notationListTable.clearSelection();
    }

    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }


    /*
     * #########################################################################
     * #                    private methods                                    #
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
