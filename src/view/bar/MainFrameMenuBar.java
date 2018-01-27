package view.bar;

import listeners.MenuBarActionListener;
import gui.Constants;

import javax.swing.*;

public class MainFrameMenuBar extends JMenuBar {

    private JMenu menuFile;
    private JMenuItem menuItemNewDataFile;
    private JMenuItem menuItemOpenDataFile;
    private JMenuItem menuItemSaveDataFile;
    private JMenuItem menuItemSaveAsDataFile;
    private JMenuItem menuItemCloseDataFile;
    private JMenuItem menuItemClose;

    private JMenu menuProject;
    private JMenuItem menuItemImportPDF;
    private JMenuItem menuItemShowList;

    private JMenu menuNotation;
    private JMenuItem menuItemAddNotation;

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
        this.menuItemNewDataFile = new JMenuItem();
        this.menuItemOpenDataFile = new JMenuItem();
        this.menuItemSaveDataFile = new JMenuItem();
        this.menuItemSaveAsDataFile = new JMenuItem();
        this.menuItemCloseDataFile = new JMenuItem();
        this.menuItemClose = new JMenuItem();

        this.menuProject = new JMenu();
        this.menuItemImportPDF = new JMenuItem();
        this.menuItemShowList = new JMenuItem();

        this.menuNotation = new JMenu();
        this.menuItemAddNotation = new JMenuItem();

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
        this.setupMenuProject();
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
        this.menuItemNewDataFile.setText(Constants.MENUITEM_NEW_DATAFILE_NAME);
        this.menuItemOpenDataFile.setText(Constants.MENUITEM_OPEN_DATAFILE_NAME);
        this.menuItemSaveDataFile.setText(Constants.MENUITEM_SAVE_DATAFILE_NAME);
        this.menuItemSaveAsDataFile.setText(Constants.MENUITEM_SAVE_AS_DATAFILE_NAME);
        this.menuItemCloseDataFile.setText(Constants.MENUITEM_CLOSE_DATAFILE_NAME);
        this.menuItemClose.setText(Constants.MENUITEM_CLOSE_NAME);

        // ActionListener
        this.menuItemNewDataFile.addActionListener(this.mbActionListener);
        this.menuItemOpenDataFile.addActionListener(this.mbActionListener);
        this.menuItemSaveDataFile.addActionListener(this.mbActionListener);
        this.menuItemSaveAsDataFile.addActionListener(this.mbActionListener);
        this.menuItemCloseDataFile.addActionListener(this.mbActionListener);
        this.menuItemClose.addActionListener(this.mbActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuFile.add(this.menuItemNewDataFile);
        this.menuFile.add(this.menuItemOpenDataFile);
        this.menuFile.add(this.menuItemSaveDataFile);
        this.menuFile.add(this.menuItemSaveAsDataFile);
        this.menuFile.add(this.menuItemCloseDataFile);
        this.menuFile.addSeparator();
        this.menuFile.add(this.menuItemClose);

        this.add(this.menuFile);
    }

    /*
     * @author  yxyxD
     */
    private void setupMenuProject()
    {
        // Text des Menues und der Menuepunkte
        this.menuProject.setText(Constants.MENU_PROJECT_NAME);
        this.menuItemImportPDF.setText(Constants.MENUITEM_IMPORT_PDF_NAME);
        this.menuItemShowList.setText(Constants.MENUITEM_SHOW_LIST_NAME);

        // ActionListener
        this.menuItemImportPDF.addActionListener(this.mbActionListener);
        this.menuItemShowList.addActionListener(this.mbActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuProject.add(this.menuItemImportPDF);
        this.menuProject.add(this.menuItemShowList);

        this.add(this.menuProject);
    }

    /*
     * @author  yxyxD
     */
    private void setupMenuNotation()
    {
        // Text des Menues und der Menuepunkte
        this.menuNotation.setText(Constants.MENU_NOTATION_NAME);
        this.menuItemAddNotation.setText(Constants.MENUITEM_ADD_NOTATION_NAME);

        // ActionListener
        this.menuItemAddNotation.addActionListener(this.mbActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuNotation.add(this.menuItemAddNotation);

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
