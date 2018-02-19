package view.projectView.pdfObjectView.partials;

import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import java.awt.*;

public class EntityScrollPane extends JScrollPane {

    private PdfObjectView pdfObjectView;

    private EntityTableModel entityTableModel;

    private JTable notationEntityTable;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
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
    /*
     * @author  marxmanEUW
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
    /*
     * @author  marxmanEUW
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
