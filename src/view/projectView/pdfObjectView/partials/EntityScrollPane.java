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
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Constructs the EntityScrollPane which shows the information of
     *          the selected notation.
     */
    public EntityScrollPane()
    {
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.notationEntityTable = new JTable();
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
     * @brief   Initializes the EntityScrollPane.
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
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-01 (marxmanEUW)  created
     * @brief   Returns the NotationEntityTable of the EntityScrollPane.
     */
    public JTable getNotationEntityTable()
    {
        return notationEntityTable;
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
     * @brief   Repaints the EntityScrollPane.
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
     * @brief   Updates the content of the NotationEntityTable
     */
    public void updateTable()
    {
        this.entityTableModel.fireTableDataChanged();
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
