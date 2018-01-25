package view.projectView.pdfObjectView.partials;

import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class EntityScrollPane extends JScrollPane {

    /*
     * @todo make editable
     * @todo implement EowSorter, alter musste entfernt werden, weil er Fehler ausgeworfen hat
     */

    private PdfObjectView pdfObjectView;

    private EntityTableModel entityTableModel;

    private JTable notationEntityTable;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public EntityScrollPane()
    {
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

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

        this.entityTableModel = this.pdfObjectView.getEntityTableModel();

        this.notationEntityTable.setModel(this.entityTableModel);
        this.getViewport().add(notationEntityTable);
    }


    /*
     * #########################################################################
     * #                    öffentliche Methoden                               #
     * #########################################################################
     */

    public void updateTable()
    {
        this.entityTableModel.fireTableDataChanged();
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
