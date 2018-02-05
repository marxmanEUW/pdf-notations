package view.bar;

import gui.Constants;
import listeners.BarActionListener;

import javax.swing.*;

public class MainFrameToolBar extends JToolBar {

    private JButton buttonNewProject;
    private JButton buttonOpenProject;
    private JButton buttonSaveProject;
    private JButton buttonSaveAsProject;
    private JButton buttonCloseProject;

    private JButton buttonZoomIn;
    private JButton buttonZoomOut;
    //private JButton buttonZoomFitToPage;

    private JButton buttonAddNotation;

    private BarActionListener barActionListener;

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
     * #                    Initialising                                       #
     * #########################################################################
     */
    public void initialize(BarActionListener barActionListener)
    {
        this.barActionListener = barActionListener;


        // ActionCommand
        this.buttonNewProject.setActionCommand(Constants.BAR_ITEM_NEW_PROJECT_NAME);
        this.buttonOpenProject.setActionCommand(Constants.BAR_ITEM_OPEN_PROJECT_NAME);
        this.buttonSaveProject.setActionCommand(Constants.BAR_ITEM_SAVE_PROJECT_NAME);
        this.buttonSaveAsProject.setActionCommand(Constants.BAR_ITEM_SAVE_AS_PROJECT_NAME);
        this.buttonCloseProject.setActionCommand(Constants.BAR_ITEM_CLOSE_PROJECT_NAME);

        this.buttonZoomOut.setActionCommand(Constants.BAR_ITEM_ZOOM_OUT_NAME);
        this.buttonZoomIn.setActionCommand(Constants.BAR_ITEM_ZOOM_IN_NAME);

        this.buttonAddNotation.setActionCommand(Constants.BAR_ITEM_ADD_NOTATION_NAME);


        // Tooltip Text
        this.buttonNewProject.setToolTipText(Constants.BAR_ITEM_NEW_PROJECT_NAME);
        this.buttonOpenProject.setToolTipText(Constants.BAR_ITEM_OPEN_PROJECT_NAME);
        this.buttonSaveProject.setToolTipText(Constants.BAR_ITEM_SAVE_PROJECT_NAME);
        this.buttonSaveAsProject.setToolTipText(Constants.BAR_ITEM_SAVE_AS_PROJECT_NAME);
        this.buttonCloseProject.setToolTipText(Constants.BAR_ITEM_CLOSE_PROJECT_NAME);

        this.buttonZoomOut.setToolTipText(Constants.BAR_ITEM_ZOOM_OUT_NAME);
        this.buttonZoomIn.setToolTipText(Constants.BAR_ITEM_ZOOM_IN_NAME);

        this.buttonAddNotation.setToolTipText(Constants.BAR_ITEM_ADD_NOTATION_NAME);


        // Image
        this.buttonNewProject.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_NEW_PROJECT_ICON_PATH));
        this.buttonOpenProject.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_OPEN_PROJECT_ICON_PATH));
        this.buttonSaveProject.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_SAVE_PROJECT_ICON_PATH));
        this.buttonSaveAsProject.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_SAVE_AS_PROJECT_ICON_PATH));
        this.buttonCloseProject.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_CLOSE_PROJECT_ICON_PATH));

        this.buttonZoomOut.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_ZOOM_OUT_ICON_PATH));
        this.buttonZoomIn.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_ZOOM_IN_ICON_PATH));

        this.buttonAddNotation.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_ADD_NOTATION_ICON_PATH));


        // Action Listener
        this.buttonNewProject.addActionListener(this.barActionListener);
        this.buttonOpenProject.addActionListener(this.barActionListener);
        this.buttonSaveProject.addActionListener(this.barActionListener);
        this.buttonSaveAsProject.addActionListener(this.barActionListener);
        this.buttonCloseProject.addActionListener(this.barActionListener);

        this.buttonZoomOut.addActionListener(this.barActionListener);
        this.buttonZoomIn.addActionListener(this.barActionListener);

        this.buttonAddNotation.addActionListener(this.barActionListener);

        // add
        this.add(this.buttonNewProject);
        this.add(this.buttonOpenProject);
        this.add(this.buttonSaveProject);
        this.add(this.buttonSaveAsProject);
        this.add(this.buttonCloseProject);

        this.addSeparator();

        this.add(this.buttonZoomOut);
        this.add(this.buttonZoomIn);

        this.addSeparator();

        this.add(this.buttonAddNotation);
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public void setButtonSaveProjectEnabled(boolean enabled)
    {
        this.buttonSaveProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setButtonSaveAsProjectEnabled(boolean enabled)
    {
        this.buttonSaveAsProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setButtonCloseProjectEnabled(boolean enabled)
    {
        this.buttonCloseProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setButtonZoomInEnabled(boolean enabled)
    {
        this.buttonZoomIn.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setButtonZoomOutEnabled(boolean enabled)
    {
        this.buttonZoomOut.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     */
    public void setButtonAddNotationEnabled(boolean enabled)
    {
        this.buttonAddNotation.setEnabled(enabled);
    }
}
