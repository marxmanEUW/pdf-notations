package view.bar;

import constants.KeyStrokes;
import constants.Labels;
import listeners.BarActionListener;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MainFrameMenuBar extends JMenuBar {

    // "File"-menu
    private JMenu menuFile;
    private JMenuItem menuItemNewProject;
    private JMenuItem menuItemOpenProject;
    private JMenuItem menuItemSaveProject;
    private JMenuItem menuItemSaveAsProject;
    private JMenuItem menuItemCloseProject;
    private JMenuItem menuItemClose;

    // "Notation"-menu
    private JMenu menuNotation;
    private JMenuItem menuItemAddNotation;
    private JMenuItem menuItemDeleteNotation;

    // "View"-menu
    private JMenu menuView;
    private JMenuItem menuItemZoomIn;
    private JMenuItem menuItemZoomOut;

    // "Help"-menu
    private JMenu menuHelp;
    private JMenuItem menuItemAbout;

    // Listener
    private BarActionListener barActionListener;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  yxyxD
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
     * #                    Initialising                                       #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void initialize(MainFrame mainFrame)
    {
        this.barActionListener = mainFrame.getBarActionListener();

        this.setupMenuFile();
        this.setupMenuNotation();
        this.setupMenuView();
        this.setupMenuHelp();

        this.barActionListener.updateBars();
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void setMenuItemNewProjectEnabled(boolean enabled)
    {
        this.menuItemNewProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemOpenProjectEnabled(boolean enabled)
    {
        this.menuItemOpenProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemSaveProjectEnabled(boolean enabled)
    {
        this.menuItemSaveProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemSaveAsProjectEnabled(boolean enabled)
    {
        this.menuItemSaveAsProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemCloseProjectEnabled(boolean enabled)
    {
        this.menuItemCloseProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemCloseEnabled(boolean enabled)
    {
        this.menuItemClose.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemAddNotationEnabled(boolean enabled)
    {
        this.menuItemAddNotation.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemDeleteNotationEnabled(boolean enabled)
    {
        this.menuItemDeleteNotation.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemZoomInEnabled(boolean enabled)
    {
        this.menuItemZoomIn.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setMenuItemZoomOutEnabled(boolean enabled)
    {
        this.menuItemZoomOut.setEnabled(enabled);
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    private void setupMenuFile()
    {
        // Text des Menues und der Menuepunkte
        this.menuFile.setText(Labels.MENU_FILE_NAME);
        this.menuItemNewProject.setText(Labels.BAR_ITEM_NEW_PROJECT_NAME);
        this.menuItemOpenProject.setText(Labels.BAR_ITEM_OPEN_PROJECT_NAME);
        this.menuItemSaveProject.setText(Labels.BAR_ITEM_SAVE_PROJECT_NAME);
        this.menuItemSaveAsProject.setText(Labels.BAR_ITEM_SAVE_AS_PROJECT_NAME);
        this.menuItemCloseProject.setText(Labels.BAR_ITEM_CLOSE_PROJECT_NAME);
        this.menuItemClose.setText(Labels.BAR_ITEM_CLOSE_NAME);

        // ActionListener
        this.menuItemNewProject.addActionListener(this.barActionListener);
        this.menuItemOpenProject.addActionListener(this.barActionListener);
        this.menuItemSaveProject.addActionListener(this.barActionListener);
        this.menuItemSaveAsProject.addActionListener(this.barActionListener);
        this.menuItemCloseProject.addActionListener(this.barActionListener);
        this.menuItemClose.addActionListener(this.barActionListener);

        //Shortcuts
        this.menuItemNewProject.setAccelerator(KeyStroke.getKeyStroke(
            KeyStrokes.BAR_ITEM_NEW_PROJECT_KEY_STROKE,
            KeyEvent.CTRL_DOWN_MASK
        ));
        this.menuItemOpenProject.setAccelerator(KeyStroke.getKeyStroke(
            KeyStrokes.BAR_ITEM_OPEN_PROJECT_KEY_STROKE,
            KeyEvent.CTRL_DOWN_MASK
        ));
        this.menuItemSaveProject.setAccelerator(KeyStroke.getKeyStroke(
            KeyStrokes.BAR_ITEM_SAVE_PROJECT_KEY_STROKE,
            KeyEvent.CTRL_DOWN_MASK
        ));
        this.menuItemSaveAsProject.setAccelerator(KeyStroke.getKeyStroke(
            KeyStrokes.BAR_ITEM_SAVE_AS_PROJECT_KEY_STROKE,
            KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK
        ));
        this.menuItemCloseProject.setAccelerator(KeyStroke.getKeyStroke(
            KeyStrokes.BAR_ITEM_CLOSE_PROJECT_KEY_STROKE,
            KeyEvent.CTRL_DOWN_MASK
        ));
        this.menuItemClose.setAccelerator(KeyStroke.getKeyStroke(
            KeyStrokes.BAR_ITEM_CLOSE_KEY_STROKE,
            KeyEvent.ALT_DOWN_MASK
        ));


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
        this.menuNotation.setText(Labels.MENU_NOTATION_NAME);
        this.menuItemAddNotation.setText(Labels.BAR_ITEM_ADD_NOTATION_NAME);
        this.menuItemDeleteNotation.setText(Labels.BAR_ITEM_DELETE_NOTATION_NAME);

        // ActionListener
        this.menuItemAddNotation.addActionListener(this.barActionListener);
        this.menuItemDeleteNotation.addActionListener(this.barActionListener);

        // Shortcuts
        this.menuItemAddNotation.setAccelerator(KeyStroke.getKeyStroke(
            KeyStrokes.BAR_ITEM_ADD_NOTATION_KEY_STROKE,
            KeyEvent.CTRL_DOWN_MASK
        ));
        this.menuItemDeleteNotation.setAccelerator(KeyStroke.getKeyStroke(
            KeyStrokes.BAR_ITEM_DELETE_NOTATION_KEY_STROKE,
            KeyEvent.CTRL_DOWN_MASK
        ));

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
        this.menuView.setText(Labels.MENU_VIEW_NAME);
        this.menuItemZoomIn.setText(Labels.BAR_ITEM_ZOOM_IN_NAME);
        this.menuItemZoomOut.setText(Labels.BAR_ITEM_ZOOM_OUT_NAME);

        // ActionListener
        this.menuItemZoomIn.addActionListener(this.barActionListener);
        this.menuItemZoomOut.addActionListener(this.barActionListener);

        //Shortcuts
        this.menuItemZoomIn.setAccelerator(KeyStroke.getKeyStroke(
            KeyStrokes.BAR_ITEM_ZOOM_IN_KEY_STROKE,
            KeyEvent.CTRL_DOWN_MASK
        ));
        this.menuItemZoomOut.setAccelerator(KeyStroke.getKeyStroke(
            KeyStrokes.BAR_ITEM_ZOOM_OUT_KEY_STROKE,
            KeyEvent.CTRL_DOWN_MASK
        ));

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
        this.menuHelp.setText(Labels.MENU_HELP_NAME);
        this.menuItemAbout.setText(Labels.BAR_ITEM_ABOUT_NAME);

        // ActionListener
        this.menuItemAbout.addActionListener(this.barActionListener);

        // Menuepunkte zum Menue hinzufuegen
        this.menuHelp.add(this.menuItemAbout);

        this.add(this.menuHelp);
    }
}
