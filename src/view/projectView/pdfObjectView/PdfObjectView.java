package view.projectView.pdfObjectView;

import constants.Environment;
import factories.PdfObjectFactory;
import listeners.*;
import model.PdfObject;
import view.MainFrame;
import view.projectView.pdfObjectView.partials.*;

import javax.swing.*;
import java.io.File;

public class PdfObjectView extends JSplitPane {

    // PDF-Object
    private PdfObject pdfObject;

    // MainFrame
    private MainFrame mainFrame;

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
     * @brief   Constructs a PdfObjectView that holds a PdfObject.
     */
    public PdfObjectView()
    {
        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
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
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Initialises the PdfObjectView.
     */
    public void initialize(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;

        this.setDividerLocation(
            (int) (this.mainFrame.getWidth()
                * Environment.PDF_OBJECT_VIEW_DIVIDER_LOCATION)
        );

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
     *      2018-02-28 (yxyxD)  created
     * @brief   Returns the MainFrame of the PdfObjectView.
     */
    public MainFrame getMainFrame()
    {
        return this.mainFrame;
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
     * #                    Public Methods                                     #
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
        this.pdfArea.refreshPdfArea();
        this.entityScrollPane.updateTable();
        this.notationListScrollPane.updateTable();
    }
}
