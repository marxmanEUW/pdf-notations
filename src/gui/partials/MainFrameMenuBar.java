package gui.partials;

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
    private JSeparator jSeparator1;

    private JMenu menuProject;
    private JMenuItem menuItemImportPDF;
    private JMenuItem menuItemShowList;

    private JMenu menuNotation;
    private JMenuItem menuItemAddNotation;

    private JMenu menuHelp;
    private JMenuItem menuItemAbout;


    public MainFrameMenuBar()
    {
        this.setupMenuFile();
        this.setupMenuProject();
        this.setupMenuNotation();
        this.setupMenuHelp();
    }


    private void setupMenuFile()
    {
        this.menuFile = new JMenu();

        // Menuepunkte
        this.menuItemNewProject = new JMenuItem();
        this.menuItemOpenProject = new JMenuItem();
        this.menuItemSaveProject = new JMenuItem();
        this.menuItemSaveAsProject = new JMenuItem();
        this.menuItemCloseProject = new JMenuItem();
        this.menuItemClose = new JMenuItem();

        // Trennstriche
        this.jSeparator1 = new JSeparator();

        // Text des Menues und der Menuepunkte
        this.menuFile.setText(Constants.MENU_FILE_NAME);
        this.menuItemNewProject.setText(Constants.MENUITEM_NEW_PROJECT_NAME);
        this.menuItemOpenProject.setText(Constants.MENUITEM_OPEN_PROJECT_NAME);
        this.menuItemSaveProject.setText(Constants.MENUITEM_SAVE_PROJECT_NAME);
        this.menuItemSaveAsProject.setText(Constants.MENUITEM_SAVE_AS_PROJECT_NAME);
        this.menuItemCloseProject.setText(Constants.MENUITEM_CLOSE_PROJECT_NAME);
        this.menuItemClose.setText(Constants.MENUITEM_CLOSE_NAME);

        // Menuepunkte zum Menue hinzufuegen
        this.menuFile.add(this.menuItemNewProject);
        this.menuFile.add(this.menuItemOpenProject);
        this.menuFile.add(this.menuItemSaveProject);
        this.menuFile.add(this.menuItemSaveAsProject);
        this.menuFile.add(this.menuItemCloseProject);
        this.menuFile.add(this.jSeparator1);
        this.menuFile.add(this.menuItemClose);

        this.add(this.menuFile);
    }

    private void setupMenuProject()
    {
        this.menuProject = new JMenu();

        // Menuepunkte
        this.menuItemImportPDF = new JMenuItem();
        this.menuItemShowList = new JMenuItem();

        // Text des Menues und der Menuepunkte
        this.menuProject.setText(Constants.MENU_PROJECT_NAME);
        this.menuItemImportPDF.setText(Constants.MENUITEM_IMPORT_PDF_NAME);
        this.menuItemShowList.setText(Constants.MENUITEM_SHOW_LIST_NAME);

        // Menuepunkte zum Menue hinzufuegen
        this.menuProject.add(this.menuItemImportPDF);
        this.menuProject.add(this.menuItemShowList);

        this.add(this.menuProject);
    }

    private void setupMenuNotation()
    {
        this.menuNotation = new JMenu();

        // Menuepunkte
        this.menuItemAddNotation = new JMenuItem();

        // Text des Menues und der Menuepunkte
        this.menuNotation.setText(Constants.MENU_NOTATION_NAME);
        this.menuItemAddNotation.setText(Constants.MENUITEM_ADD_NOTATION_NAME);

        // Menuepunkte zum Menue hinzufuegen
        this.menuNotation.add(this.menuItemAddNotation);

        this.add(this.menuNotation);
    }

    private void setupMenuHelp()
    {
        this.menuHelp = new JMenu();

        // Menuepunkte
        this.menuItemAbout = new JMenuItem();

        // Text des Menues und der Menuepunkte
        this.menuHelp.setText(Constants.MENU_HELP_NAME);
        this.menuItemAbout.setText(Constants.MENUITEM_ABOUT_NAME);

        // Menuepunkte zum Menue hinzufuegen
        this.menuHelp.add(this.menuItemAbout);

        this.add(this.menuHelp);
    }
}
