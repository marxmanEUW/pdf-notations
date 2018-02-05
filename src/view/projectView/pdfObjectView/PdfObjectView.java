package view.projectView.pdfObjectView;

import factories.PdfObjectFactory;
import listeners.*;
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
import java.io.File;

public class PdfObjectView extends JSplitPane {

    /*
     * @note "final" could be removed to impelement a feature which can memorize
     *       the position of the dividers even after a restart
     */
    // @todo Dividerposition an Größe des MainFrames festmachen
    private final int DEVIDER_LOCATION
        = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.8);

    // PDF-Object
    private PdfObject pdfObject;

    // Listeners
    private NotationListSelectionListener notationListSelectionListener;
    private PdfAreaMouseClick pdfAreaMouseClick;
    private PdfAreaMouseWheel pdfAreaMouseWheel;

    // Left part of the center component
    private PdfScrollPane pdfScrollPane;
        private PdfArea pdfArea;

    // Right part of the center component
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
    /*
     * @author  yxyxD
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
        this.pdfAreaMouseWheel = new PdfAreaMouseWheel();;

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
    /*
     * @author  yxyxD
     */
    public void initialize()
    {
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
    /*
     * @author  yxyxD
     */
    public PdfObject getPdfObject()
    {
        return this.pdfObject;
    }

    /*
     * @author  yxyxD
     */
    public PdfScrollPane getPdfScrollPane()
    {
        return this.pdfScrollPane;
    }

    /*
     * @author  yxyxD
     */
    public PdfArea getPdfArea()
    {
        return this.pdfArea;
    }

    /*
     * @author  yxyxD
     */
    public NotationSplitPane getNotationSplitPane()
    {
        return this.notationSplitPane;
    }

    /*
     * @author  yxyxD
     */
    public ListScrollPane getNotationListScrollPane()
    {
        return this.notationListScrollPane;
    }

    /*
     * @author  yxyxD
     */
    public ListTableModel getListTableModel()
    {
        return this.listTableModel;
    }

    /*
     * @author  yxyxD
     */
    public EntityScrollPane getEntityScrollPane()
    {
        return this.entityScrollPane;
    }

    /*
     * @author  yxyxD
     */
    public EntityTableModel getEntityTableModel()
    {
        return this.entityTableModel;
    }

    /*
     * @author  yxyxD
     */
    public NotationListSelectionListener getNotationListSelectionListener()
    {
        return this.notationListSelectionListener;
    }

    /*
     * @author  yxyxD
     */
    public PdfAreaMouseClick getPdfAreaMouseClick()
    {
        return this.pdfAreaMouseClick;
    }

    /*
     * @author  yxyxD
     */
    public PdfAreaMouseWheel getPdfAreaMouseWheel()
    {
        return this.pdfAreaMouseWheel;
    }


    /*
     * #########################################################################
     * #                    Open Methods                                       #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void openProject(File file)
    {
        this.pdfObject = PdfObjectFactory.loadPdfObjectFromFile(file);
        this.updateViews();
    }

    /*
     * @author  yxyxD
     */
    public void closeProject()
    {
        this.pdfObject = null;
        this.updateViews();
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    private void updateViews()
    {
        // @todo update Notationlist and NotationEntity
        this.pdfArea.refreshPdfArea();
    }
}
