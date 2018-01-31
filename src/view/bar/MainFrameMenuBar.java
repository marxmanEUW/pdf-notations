package view.bar;

import listeners.BarActionListener;
import gui.Constants;

import javax.swing.*;

public class MainFrameMenuBar extends JMenuBar {

    private JMenu menuFile;
    private JMenuItem menuItemNewProject;
    private JMenuItem menuItemOpenProject;
    private JMenuItem menuItemSaveProject;
    private JMenuItem menuItemSaveAsProject;
    private JMenuItem menuItemCloseProject;
    private JMenuItem menuItemClose;

    private JMenu menuNotation;
    private JMenuItem menuItemAddNotation;
    private JMenuItem menuItemDeleteNotation;

    private JMenu menuView;
    private JMenuItem menuItemZoomIn;
    private JMenuItem menuItemZoomOut;

    private JMenu menuHelp;
    private JMenuItem menuItemAbout;

    private BarActionListener barActionListener;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public MainFrameMenuBar()
    {
        this.menuFile = new JMenu();
        this.menuItemNewProject = new JMenuItem();
        this.menuItemOpenProject = new JMenuItem();
        this.menuItemSaveProject = new JMenuItem();
        this.menuItemSaveAsProject = new JMenuItem();
        this.menuItemCloseProject = new JMenuItem();
        this.menuItemClose = new JMenuItem();

        this.menuNotation = new JMenu();
        this.menuItemAddNotation = new JMenuItem();
        this.menuItemDeleteNotation = new JMenuItem();

        this.menuView = new JMenu();
        this.menuItemZoomIn = new JMenuItem();
        this.menuItemZoomOut = new JMenuItem();

        this.menuHelp = new JMenu();
        this.menuItemAbout = new JMenuItem();
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void initialize(BarActionListener barActionListener)
    {
        this.barActionListener = barActionListener;

        this.setupMenuFile();
        this.setupMenuNotation();
        this.setupMenuView();
        this.setupMenuHelp();
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    private void setupMenuFile()
    {
        // Text des Menues und der Menuepunkte
        this.menuFile.setText(Constants.MENU_FILE_NAME);
        this.menuItemNewProject.setText(Constants.BAR_ITEM_NEW_PROJECT_NAME);
        this.menuItemOpenProject.setText(Constants.BAR_ITEM_OPEN_PROJECT_NAME);
        this.menuItemSaveProject.setText(Constants.BAR_ITEM_SAVE_PROJECT_NAME);
        this.menuItemSaveAsProject.setText(Constants.BAR_ITEM_SAVE_AS_PROJECT_NAME);
        this.menuItemCloseProject.setText(Constants.BAR_ITEM_CLOSE_PROJECT_NAME);
        this.menuItemClose.setText(Constants.BAR_ITEM_CLOSE_NAME);

        // ActionListener
        this.menuItemNewProject.addActionListener(this.barActionListener);
        this.menuItemOpenProject.addActionListener(this.barActionListener);
        this.menuItemSaveProject.addActionListener(this.barActionListener);
        this.menuItemSaveAsProject.addActionListener(this.barActionListener);
        this.menuItemCloseProject.addActionListener(this.barActionListener);
        this.menuItemClose.addActionListener(this.barActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuFile.add(this.menuItemNewProject);
        this.menuFile.add(this.menuItemOpenProject);
        this.menuFile.add(this.menuItemSaveProject);
        this.menuFile.add(this.menuItemSaveAsProject);
        this.menuFile.add(this.menuItemCloseProject);
        this.menuFile.addSeparator();
        this.menuFile.add(this.menuItemClose);

        this.add(this.menuFile);
    }


    /*
     * @author  yxyxD
     */
    private void setupMenuNotation()
    {
        // Text des Menues und der Menuepunkte
        this.menuNotation.setText(Constants.MENU_NOTATION_NAME);
        this.menuItemAddNotation.setText(Constants.BAR_ITEM_ADD_NOTATION_NAME);
        this.menuItemDeleteNotation.setText(Constants.BAR_ITEM_DELETE_NOTATION_NAME);

        // ActionListener
        this.menuItemAddNotation.addActionListener(this.barActionListener);
        this.menuItemDeleteNotation.addActionListener(this.barActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuNotation.add(this.menuItemAddNotation);
        this.menuNotation.add(this.menuItemDeleteNotation);

        this.add(this.menuNotation);
    }


    /*
     * @author  marxmanEUW
     */
    private void setupMenuView()
    {
        // Text des Menues und der Menuepunkte
        this.menuView.setText(Constants.MENU_VIEW_NAME);
        this.menuItemZoomIn.setText(Constants.BAR_ITEM_ZOOM_IN_NAME);
        this.menuItemZoomOut.setText(Constants.BAR_ITEM_ZOOM_OUT_NAME);

        // ActionListener
        this.menuItemZoomIn.addActionListener(this.barActionListener);
        this.menuItemZoomOut.addActionListener(this.barActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuView.add(this.menuItemZoomIn);
        this.menuView.add(this.menuItemZoomOut);

        this.add(this.menuView);
    }


    /*
     * @author  yxyxD
     */
    private void setupMenuHelp()
    {
        // Text des Menues und der Menuepunkte
        this.menuHelp.setText(Constants.MENU_HELP_NAME);
        this.menuItemAbout.setText(Constants.BAR_ITEM_ABOUT_NAME);

        // ActionListener
        this.menuItemAbout.addActionListener(this.barActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuHelp.add(this.menuItemAbout);

        this.add(this.menuHelp);
    }
}
