package view.test;

import listeners.NotationListSelectionListener;
import listeners.PdfAreaMouseAdapter;
import model.PdfObject;
import view.partials.partials.NotationSplitPane;
import view.partials.partials.PdfScrollPane;
import view.partials.partials.partials.NotationEntityScrollPane;
import view.partials.partials.partials.NotationListScrollPane;
import view.partials.partials.partials.PdfArea;
import view.partials.partials.partials.partials.NotationEntityTableModel;
import view.partials.partials.partials.partials.NotationListTableModel;

import javax.swing.*;
import java.awt.*;

public class PdfObjectView extends JSplitPane {

    /*
     * @note "final" could be removed to impelement a feature which can memorize
     *       the position of the dividers even after a restart
     */
    // @todo Dividerposition an Größe des MainFrames festmachen
    private final int DEVIDER_LOCATION
        = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.8);

    private PdfObject pdfObject;


    private NotationListSelectionListener notationListSelectionListener;
    private PdfAreaMouseAdapter pdfAreaMouseAdapter;

    private PdfScrollPane pdfScrollPane;
        private PdfArea pdfArea;

    private NotationSplitPane notationSplitPane;
        private NotationListScrollPane notationListScrollPane;
            private NotationListTableModel notationListTableModel;
        private NotationEntityScrollPane notationEntityScrollPane;
            private NotationEntityTableModel notationEntityTableModel;




    public PdfObjectView()
    {
        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        this.setDividerLocation(this.DEVIDER_LOCATION);
        this.setOneTouchExpandable(true);
        this.setContinuousLayout(true);


        // Listener
        this.notationListSelectionListener = new NotationListSelectionListener();
        this.pdfAreaMouseAdapter = new PdfAreaMouseAdapter();

        this.pdfScrollPane = new PdfScrollPane();
        this.pdfArea = new PdfArea();

        this.notationSplitPane = new NotationSplitPane();
        this.notationListScrollPane = new NotationListScrollPane();
        this.notationListTableModel = new NotationListTableModel();
        this.notationEntityScrollPane = new NotationEntityScrollPane();
        this.notationEntityTableModel = new NotationEntityTableModel();


    }


    public void initialize(PdfObject pdfObject)
    {
        this.pdfObject = pdfObject;

        this.pdfScrollPane.initialize(this);
        this.pdfArea.initialize(this);

        this.notationSplitPane.initialize(this);
        this.notationListScrollPane.initialize(this);
        this.notationListTableModel.initialize(this);
        this.notationEntityScrollPane.initialize(this);
        this.notationEntityTableModel.initialize(this);

        this.notationListSelectionListener.initialize(this);
        this.pdfAreaMouseAdapter.initialize(this);


        this.setLeftComponent(this.pdfScrollPane);
        this.setRightComponent(this.notationSplitPane);
    }



    public PdfObject getPdfObject()
    {
        return this.pdfObject;
    }

    public PdfScrollPane getPdfScrollPane()
    {
        return this.pdfScrollPane;
    }

    public PdfArea getPdfArea()
    {
        return this.pdfArea;
    }

    public NotationSplitPane getNotationSplitPane()
    {
        return this.notationSplitPane;
    }

    public NotationListScrollPane getNotationListScrollPane()
    {
        return this.notationListScrollPane;
    }

    public NotationListTableModel getNotationListTableModel()
    {
        return this.notationListTableModel;
    }

    public NotationEntityScrollPane getNotationEntityScrollPane()
    {
        return this.notationEntityScrollPane;
    }

    public NotationEntityTableModel getNotationEntityTableModel()
    {
        return this.notationEntityTableModel;
    }

    public NotationListSelectionListener getNotationListSelectionListener()
    {
        return this.notationListSelectionListener;
    }

    public PdfAreaMouseAdapter getPdfAreaMouseAdapter()
    {
        return this.pdfAreaMouseAdapter;
    }
}
