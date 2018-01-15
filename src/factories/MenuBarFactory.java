package factories;

import gui.Constants;

import javax.swing.*;

public abstract class MenuBarFactory {

    /*
     * #########################################################################
     * #                    oeffentliche Methoden                              #
     * #########################################################################
     */
    public static JMenuBar createAndReturnMenuBarForMainFrame()
    {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = createAndReturnMenuFile();
        JMenu menuProject = createAndReturnMenuProject();
        JMenu menuNoation = createAndReturnMenuNotation();
        JMenu menuHelp = createAndReturnMenuHelp();

        menuBar.add(menuFile);
        menuBar.add(menuProject);
        menuBar.add(menuNoation);
        menuBar.add(menuHelp);

        return menuBar;
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethoden                              #
     * #########################################################################
     */
    private static JMenu createAndReturnMenuFile()
    {
        JMenu menuFile = new JMenu();

        // Menuepunkte
        JMenuItem menuItemNewProject = new JMenuItem();
        JMenuItem menuItemOpenProject = new JMenuItem();
        JMenuItem menuItemSaveProject = new JMenuItem();
        JMenuItem menuItemSaveAsProject = new JMenuItem();
        JMenuItem menuItemCloseProject = new JMenuItem();
        JMenuItem menuItemClose = new JMenuItem();

        // Trennstriche
        JSeparator jSeparator1 = new JSeparator();

        // Text des Menues und der Menuepunkte
        menuFile.setText(Constants.MENU_FILE_NAME);
        menuItemNewProject.setText(Constants.MENUITEM_NEW_PROJECT_NAME);
        menuItemOpenProject.setText(Constants.MENUITEM_OPEN_PROJECT_NAME);
        menuItemSaveProject.setText(Constants.MENUITEM_SAVE_PROJECT_NAME);
        menuItemSaveAsProject.setText(Constants.MENUITEM_SAVE_AS_PROJECT_NAME);
        menuItemCloseProject.setText(Constants.MENUITEM_CLOSE_PROJECT_NAME);
        menuItemClose.setText(Constants.MENUITEM_CLOSE_NAME);

        // Menuepunkte zum Menue hinzufuegen
        menuFile.add(menuItemNewProject);
        menuFile.add(menuItemOpenProject);
        menuFile.add(menuItemSaveProject);
        menuFile.add(menuItemSaveAsProject);
        menuFile.add(menuItemCloseProject);
        menuFile.add(jSeparator1);
        menuFile.add(menuItemClose);

        return menuFile;
    }

    private static JMenu createAndReturnMenuProject()
    {
        JMenu menuProject = new JMenu();

        // Menuepunkte
        JMenuItem menuItemImportPDF = new JMenuItem();
        JMenuItem menuItemShowList = new JMenuItem();

        // Text des Menues und der Menuepunkte
        menuProject.setText(Constants.MENU_PROJECT_NAME);
        menuItemImportPDF.setText(Constants.MENUITEM_IMPORT_PDF_NAME);
        menuItemShowList.setText(Constants.MENUITEM_SHOW_LIST_NAME);

        // Menuepunkte zum Menue hinzufuegen
        menuProject.add(menuItemImportPDF);
        menuProject.add(menuItemShowList);

        return menuProject;
    }

    private static JMenu createAndReturnMenuNotation()
    {
        JMenu menuNotation = new JMenu();

        // Menuepunkte
        JMenuItem menuItemAddNotation = new JMenuItem();

        // Text des Menues und der Menuepunkte
        menuNotation.setText(Constants.MENU_NOTATION_NAME);
        menuItemAddNotation.setText(Constants.MENUITEM_ADD_NOTATION_NAME);

        // Menuepunkte zum Menue hinzufuegen
        menuNotation.add(menuItemAddNotation);

        return menuNotation;
    }

    private static JMenu createAndReturnMenuHelp()
    {
        JMenu menuHelp = new JMenu();

        // Menuepunkte
        JMenuItem menuItemAbout = new JMenuItem();

        // Text des Menues und der Menuepunkte
        menuHelp.setText(Constants.MENU_HELP_NAME);
        menuItemAbout.setText(Constants.MENUITEM_ABOUT_NAME);

        // Menuepunkte zum Menue hinzufuegen
        menuHelp.add(menuItemAbout);

        return menuHelp;
    }
}
