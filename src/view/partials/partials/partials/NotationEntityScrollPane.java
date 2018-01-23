package view.partials.partials.partials;

import model.PdfObject;
import view.partials.partials.partials.partials.NotationEntityTableModel;
import view.test.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class NotationEntityScrollPane extends JScrollPane {

    /*
     * @todo make editable
     * @todo implement EowSorter, alter musste entfernt werden, weil er Fehler ausgeworfen hat
     */

    private PdfObjectView pdfObjectView;
    private PdfObject pdfObject;
    private NotationEntityTableModel notationEntityTableModel;

    private JTable notationEntityTable;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */

    public NotationEntityScrollPane()
    {
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //this.notationEntityTableModel = new NotationEntityTableModel();
        this.notationEntityTable = new JTable();
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.pdfObject = this.pdfObjectView.getPdfObject();
        this.notationEntityTableModel = this.pdfObjectView.getNotationEntityTableModel();

        //this.notationEntityTableModel.initialize(this.pdfObject);

        this.notationEntityTable.setModel(this.notationEntityTableModel);
        this.getViewport().add(notationEntityTable);
    }

    /*
     * #########################################################################
     * #                    öffentliche Methoden                               #
     * #########################################################################
     */

    public void updateTable()
    {
        this.notationEntityTableModel.fireTableDataChanged();
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
