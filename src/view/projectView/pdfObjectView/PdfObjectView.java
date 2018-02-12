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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Constructs a PdfObjectView that holds on PdfObject.
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Initialises the PdfObjectView.
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the PdfObject held by the View.
     */
    public PdfObject getPdfObject()
    {
        return this.pdfObject;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the PdfScrollPane which holds the PdfArea.
     */
    public PdfScrollPane getPdfScrollPane()
    {
        return this.pdfScrollPane;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the PdfArea held by the PdfScrollPane.
     */
    public PdfArea getPdfArea()
    {
        return this.pdfArea;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the NotationSplitPane which holds the
     *          NotationListScrollPane and the EntityScrollPane.
     */
    public NotationSplitPane getNotationSplitPane()
    {
        return this.notationSplitPane;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the NotationListScrollPane held by the
     *          NotationSplitPane.
     */
    public ListScrollPane getNotationListScrollPane()
    {
        return this.notationListScrollPane;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the ListTableModel held by the NotationListScrollPane.
     *          The TableModel contains a list with all Notations on the Pdf.
     */
    public ListTableModel getListTableModel()
    {
        return this.listTableModel;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the EntityScrollPane held by the NotationSplitPane.
     */
    public EntityScrollPane getEntityScrollPane()
    {
        return this.entityScrollPane;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the EntityTableModel held by the EntityScrollPane. The
     *          TableModel shows the data of the selected Notation if there is
     *          one.
     */
    public EntityTableModel getEntityTableModel()
    {
        return this.entityTableModel;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the NotationSelectionListener of the NotationSplitPane
     *          that handles Events on the ListTableModel and the
     *          EntityTableModel.
     */
    public NotationListSelectionListener getNotationListSelectionListener()
    {
        return this.notationListSelectionListener;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the PdfAreaMouseClick of the PdfArea that handles
     *          MouseClick-Events on the PdfArea.
     */
    public PdfAreaMouseClick getPdfAreaMouseClick()
    {
        return this.pdfAreaMouseClick;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the PdfAreaMouseWheel of the PdfArea that handles
     *          MouseScroll-Events on the PdfArea.
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Opens a new Project.
     */
    public void openProject(File file)
    {
        // todo load pdf via thread
        this.pdfObject = PdfObjectFactory.loadPdfObjectFromFile(file);
        this.updateViews();
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Closes a loaded Project.
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Updates the PdfObjectView-Components when a new Pdf-Object has
     *          been loaded (or closed).
     */
    private void updateViews()
    {
        // @todo update Notationlist and NotationEntity
        this.pdfArea.refreshPdfArea();
    }
}
