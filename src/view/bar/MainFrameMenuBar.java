package view.bar;

import listeners.MenuBarActionListener;
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

    private JMenu menuHelp;
    private JMenuItem menuItemAbout;

    private MenuBarActionListener mbActionListener;


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
    public void initialize(MenuBarActionListener mbActionListener)
    {
        this.mbActionListener = mbActionListener;

        this.setupMenuFile();
        this.setupMenuNotation();
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
        this.menuItemNewProject.setText(Constants.MENUITEM_NEW_PROJECT_NAME);
        this.menuItemOpenProject.setText(Constants.MENUITEM_OPEN_PROJECT_NAME);
        this.menuItemSaveProject.setText(Constants.MENUITEM_SAVE_POJECT_NAME);
        this.menuItemSaveAsProject.setText(Constants.MENUITEM_SAVE_AS_PROJECT_NAME);
        this.menuItemCloseProject.setText(Constants.MENUITEM_CLOSE_PROJECT_NAME);
        this.menuItemClose.setText(Constants.MENUITEM_CLOSE_NAME);

        // ActionListener
        this.menuItemNewProject.addActionListener(this.mbActionListener);
        this.menuItemOpenProject.addActionListener(this.mbActionListener);
        this.menuItemSaveProject.addActionListener(this.mbActionListener);
        this.menuItemSaveAsProject.addActionListener(this.mbActionListener);
        this.menuItemCloseProject.addActionListener(this.mbActionListener);
        this.menuItemClose.addActionListener(this.mbActionListener);

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
        this.menuItemAddNotation.setText(Constants.MENUITEM_ADD_NOTATION_NAME);
        this.menuItemDeleteNotation.setText(Constants.MENUITEM_DELETE_NOTATION_NAME);

        // ActionListener
        this.menuItemAddNotation.addActionListener(this.mbActionListener);
        this.menuItemDeleteNotation.addActionListener(this.mbActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuNotation.add(this.menuItemAddNotation);
        this.menuNotation.add(this.menuItemDeleteNotation);

        this.add(this.menuNotation);
    }

    /*
     * @author  yxyxD
     */
    private void setupMenuHelp()
    {
        // Text des Menues und der Menuepunkte
        this.menuHelp.setText(Constants.MENU_HELP_NAME);
        this.menuItemAbout.setText(Constants.MENUITEM_ABOUT_NAME);

        // ActionListener
        this.menuItemAbout.addActionListener(this.mbActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuHelp.add(this.menuItemAbout);

        this.add(this.menuHelp);
    }
}
