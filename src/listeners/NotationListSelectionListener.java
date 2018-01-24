package listeners;

import model.PdfObject;
import view.projectView.pdfObjectView.partials.NotationSplitPane;
import view.projectView.pdfObjectView.PdfObjectView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NotationListSelectionListener implements ListSelectionListener {

    // @todo was soll angezeigt / gemacht werden, wenn mehrer Reihen ausgewählt werden

    private PdfObjectView pdfObjectView;
    private PdfObject pdfObject;
    private NotationSplitPane notationSplitPane;


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;

        this.pdfObject = this.pdfObjectView.getPdfObject();
        this.notationSplitPane = this.pdfObjectView.getNotationSplitPane();
    }


    /*
     * #########################################################################
     * #                    Overrides                                         #
     * #########################################################################
     */

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        this.pdfObject.setSelectedNotationIndex(lsm.getLeadSelectionIndex());
        this.notationSplitPane.updateNotationEntityTable();
    }
}
