package view.projectView.pdfObjectView;

import factories.PdfObjectFactory;
import listeners.MainFrameKeyListener;
import listeners.NotationListSelectionListener;
import listeners.PdfAreaMouseClick;
import listeners.PdfAreaMouseWheel;
import main.Launcher;
import model.PdfObject;
import view.projectView.pdfObjectView.partials.NotationSplitPane;
import view.projectView.pdfObjectView.partials.PdfScrollPane;
import view.projectView.pdfObjectView.partials.EntityScrollPane;
import view.projectView.pdfObjectView.partials.ListScrollPane;
import view.projectView.pdfObjectView.partials.PdfArea;
import view.projectView.pdfObjectView.partials.EntityTableModel;
import view.projectView.pdfObjectView.partials.ListTableModel;

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
    private PdfAreaMouseClick pdfAreaMouseClick;
    private PdfAreaMouseWheel pdfAreaMouseWheel;

    private PdfScrollPane pdfScrollPane;
        private PdfArea pdfArea;

    private NotationSplitPane notationSplitPane;
        private ListScrollPane notationListScrollPane;
            private ListTableModel listTableModel;
        private EntityScrollPane entityScrollPane;
            private EntityTableModel entityTableModel;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public PdfObjectView()
    {
        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        this.setDividerLocation(this.DEVIDER_LOCATION);
        this.setOneTouchExpandable(true);
        this.setContinuousLayout(true);

        // listeners
        this.notationListSelectionListener = new NotationListSelectionListener();
        this.pdfAreaMouseClick = new PdfAreaMouseClick();
        this.pdfAreaMouseWheel = new PdfAreaMouseWheel();

        // GUI elements
        this.pdfScrollPane = new PdfScrollPane();
        this.pdfArea = new PdfArea();
        this.notationSplitPane = new NotationSplitPane();
        this.notationListScrollPane = new ListScrollPane();
        this.listTableModel = new ListTableModel();
        this.entityScrollPane = new EntityScrollPane();
        this.entityTableModel = new EntityTableModel();
    }


    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    public void initialize()
    {
        /*
         * @todo Diesen Eintrag löschen => es wird NullPointerExceptions geben,
         * @todo die noch abgefangen werden müssen
         */
        this.pdfObject = PdfObjectFactory.createAndReturnPdfObject(Launcher.PATH_TO_PDF1);

        this.pdfScrollPane.initialize(this);
        this.pdfArea.initialize(this);

        this.notationSplitPane.initialize(this);
        this.notationListScrollPane.initialize(this);
        this.listTableModel.initialize(this);
        this.entityScrollPane.initialize(this);
        this.entityTableModel.initialize(this);

        this.notationListSelectionListener.initialize(this);
        this.pdfAreaMouseClick.initialize(this);
        this.pdfAreaMouseWheel.initialize(this);


        this.setLeftComponent(this.pdfScrollPane);
        this.setRightComponent(this.notationSplitPane);
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
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

    public ListScrollPane getNotationListScrollPane()
    {
        return this.notationListScrollPane;
    }

    public ListTableModel getListTableModel()
    {
        return this.listTableModel;
    }

    public EntityScrollPane getEntityScrollPane()
    {
        return this.entityScrollPane;
    }

    public EntityTableModel getEntityTableModel()
    {
        return this.entityTableModel;
    }

    public NotationListSelectionListener getNotationListSelectionListener()
    {
        return this.notationListSelectionListener;
    }


    public PdfAreaMouseClick getPdfAreaMouseClick()
    {
        return this.pdfAreaMouseClick;
    }

    public PdfAreaMouseWheel getPdfAreaMouseWheel()
    {
        return this.pdfAreaMouseWheel;
    }


    /*
    public void setPdfObject(PdfObject pdfObject)
    {
        this.pdfObject = pdfObject;
    }
    */


    /*
     * @author  yxyxD
     */
    public void importNewPdf(String sourcePath)
    {
        this.pdfObject = PdfObjectFactory.createAndReturnPdfObject(sourcePath);
        this.updateViews();
    }

    /*
     * @author  yxyxD
     */
    public void updateViews()
    {
        // @todo update Notationlist and NotationEntity
        this.pdfArea.importNewPdf();
    }
}
