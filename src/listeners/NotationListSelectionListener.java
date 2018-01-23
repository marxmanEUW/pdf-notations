package listeners;

import model.PdfObject;
import view.partials.partials.NotationSplitPane;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NotationListSelectionListener implements ListSelectionListener {

    // @todo was soll angezeigt / gemacht werden, wenn mehrer Reihen ausgewählt werden

    private PdfObject pdfObject;
    private NotationSplitPane notationSplitPane;


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    public void initialize(NotationSplitPane notationSplitPane, PdfObject pdfObject)
    {
        this.pdfObject = pdfObject;
        this.notationSplitPane = notationSplitPane;
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
