package view.projectView.pdfObjectView.partials;

import listeners.NotationListSelectionListener;
import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class ListScrollPane extends JScrollPane {

    /*
     * @todo implement EowSorter, alter musste entfernt werden, weil er Fehler ausgeworfen hat
     */

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

    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.listTableModel = this.pdfObjectView.getListTableModel();
        this.notationListSelectionListener = this.pdfObjectView.getNotationListSelectionListener();



        this.notationListTable.setModel(this.listTableModel);

        this.listSelectionModel.addListSelectionListener(this.notationListSelectionListener);
        this.notationListTable.setSelectionModel(this.listSelectionModel);

        this.getViewport().add(notationListTable);
    }


    /*
     * #########################################################################
     * #                    öffentliche Methoden                               #
     * #########################################################################
     */

    public void updateTable()
    {
        this.listTableModel.fireTableDataChanged();
    }

    public void setSelectedRow(int i)
    {
        this.notationListTable.setRowSelectionInterval(i, i);
    }

    public void unselectRow()
    {
        this.notationListTable.clearSelection();
    }

    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethode                               #
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
