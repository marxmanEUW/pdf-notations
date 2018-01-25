package view.bar;

import gui.Constants;
import listeners.ToolBarActionListener;

import javax.swing.*;

public class MainFrameToolBar extends JToolBar {

    // @todo icons

    private JButton buttonNewProject;
    private JButton buttonOpenProject;
    private JButton buttonSaveProject;
    private JButton buttonSaveAsProject;
    private JButton buttonCloseProject;

    private JButton buttonZoomIn;
    private JButton buttonZoomOut;
    //private JButton buttonZoomFitToPage;

    private JButton buttonAddNotation;
    //private JButton buttonShowNotationList;

    private ToolBarActionListener toolBarActionListener;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public MainFrameToolBar()
    {
        this.buttonNewProject = new JButton();
        this.buttonOpenProject = new JButton();
        this.buttonSaveProject = new JButton();
        this.buttonSaveAsProject = new JButton();
        this.buttonCloseProject = new JButton();

        this.buttonZoomIn = new JButton();
        this.buttonZoomOut = new JButton();
        //this.buttonZoomFitToPage = new JButton();

        this.buttonAddNotation = new JButton();
        //this.buttonShowNotationList = new JButton();
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */

    /*
     * @todo white space at beginning of toolbar,  coming from .addSeparator??????
     */

    public void initialize(ToolBarActionListener toolBarActionListener)
    {
        this.toolBarActionListener = toolBarActionListener;

        // ActionCommand
        this.buttonNewProject.setActionCommand(Constants.TOOLBAR_BUTTON_NEW_PROJECT_NAME);
        this.buttonOpenProject.setActionCommand(Constants.TOOLBAR_BUTTON_OPEN_PROJECT_NAME);
        this.buttonSaveProject.setActionCommand(Constants.TOOLBAR_BUTTON_SAVE_PROJECT_NAME);
        this.buttonSaveAsProject.setActionCommand(Constants.TOOLBAR_BUTTON_SAVE_AS_PROJECT_NAME);
        this.buttonCloseProject.setActionCommand(Constants.TOOLBAR_BUTTON_CLOSE_PROJECT_NAME);

        this.buttonZoomIn.setActionCommand(Constants.TOOLBAR_BUTTON_ZOOM_IN_NAME);
        this.buttonZoomOut.setActionCommand(Constants.TOOLBAR_BUTTON_ZOOM_OUT_NAME);

        this.buttonAddNotation.setActionCommand(Constants.TOOLBAR_BUTTON_ADD_NOTATION_NAME);

        // Tooltip Text
        this.buttonNewProject.setToolTipText(Constants.TOOLBAR_BUTTON_NEW_PROJECT_NAME);
        this.buttonOpenProject.setToolTipText(Constants.TOOLBAR_BUTTON_OPEN_PROJECT_NAME);
        this.buttonSaveProject.setToolTipText(Constants.TOOLBAR_BUTTON_SAVE_PROJECT_NAME);
        this.buttonSaveAsProject.setToolTipText(Constants.TOOLBAR_BUTTON_SAVE_AS_PROJECT_NAME);
        this.buttonCloseProject.setToolTipText(Constants.TOOLBAR_BUTTON_CLOSE_PROJECT_NAME);

        this.buttonZoomIn.setToolTipText(Constants.TOOLBAR_BUTTON_ZOOM_IN_NAME);
        this.buttonZoomOut.setToolTipText(Constants.TOOLBAR_BUTTON_ZOOM_OUT_NAME);

        this.buttonAddNotation.setToolTipText(Constants.TOOLBAR_BUTTON_ADD_NOTATION_NAME);

        // Image
        this.buttonNewProject.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_NEW_PROJECT_ICON_PATH));
        this.buttonOpenProject.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_OPEN_PROJECT_ICON_PATH));
        this.buttonSaveProject.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_SAVE_PROJECT_ICON_PATH));
        this.buttonSaveAsProject.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_SAVE_AS_PROJECT_ICON_PATH));
        this.buttonCloseProject.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_CLOSE_PROJECT_ICON_PATH));

        this.buttonZoomIn.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_ZOOM_IN_ICON_PATH));
        this.buttonZoomOut.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_ZOOM_OUT_ICON_PATH));

        this.buttonAddNotation.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_ADD_NOTATION_ICON_PATH));

        // Action Listener
        this.buttonNewProject.addActionListener(this.toolBarActionListener);
        this.buttonOpenProject.addActionListener(this.toolBarActionListener);
        this.buttonSaveProject.addActionListener(this.toolBarActionListener);
        this.buttonSaveAsProject.addActionListener(this.toolBarActionListener);
        this.buttonCloseProject.addActionListener(this.toolBarActionListener);

        this.buttonZoomIn.addActionListener(this.toolBarActionListener);
        this.buttonZoomOut.addActionListener(this.toolBarActionListener);

        this.buttonAddNotation.addActionListener(this.toolBarActionListener);

        // add
        this.add(this.buttonNewProject);
        this.add(this.buttonOpenProject);
        this.add(this.buttonSaveProject);
        this.add(this.buttonSaveAsProject);
        this.add(this.buttonCloseProject);

        this.addSeparator();

        this.add(this.buttonZoomIn);
        this.add(this.buttonZoomOut);

        this.addSeparator();

        this.add(this.buttonAddNotation);
    }
}
