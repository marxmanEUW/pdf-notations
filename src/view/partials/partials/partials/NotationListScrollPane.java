package view.partials.partials.partials;

import listeners.NotationListSelectionListener;
import model.PdfObject;
import view.partials.partials.partials.partials.NotationListTableModel;

import javax.swing.*;
import java.awt.*;

public class NotationListScrollPane extends JScrollPane {

    /*
     * @todo implement EowSorter, alter musste entfernt werden, weil er Fehler ausgeworfen hat
     */

    private PdfObject pdfObject;
    private NotationListTableModel notationListTableModel;
    private ListSelectionModel listSelectionModel;
    private NotationListSelectionListener notationListSelectionListener;

    private JTable notationListTable;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */

    public NotationListScrollPane()
    {
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.notationListTableModel = new NotationListTableModel();

        this.notationListTable = new JTable();

        this.listSelectionModel = this.notationListTable.getSelectionModel();
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(PdfObject pdfObject, NotationListSelectionListener notationListSelectionListener)
    {
        this.pdfObject = pdfObject;
        this.notationListTableModel.initialize(this.pdfObject);

        this.notationListTable.setModel(this.notationListTableModel);

        this.notationListSelectionListener = notationListSelectionListener;
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
        this.notationListTableModel.fireTableDataChanged();
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
}
