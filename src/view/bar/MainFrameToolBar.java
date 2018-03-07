package view.bar;

import constants.Environment;
import constants.Labels;
import listeners.BarActionListener;

import javax.swing.*;
import java.awt.*;

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

    private JLabel labelZoomLevel;

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

        this.labelZoomLevel = new JLabel("");
        Font labelFont = new Font(
            this.labelZoomLevel.getFont().getName(),
            Font.BOLD,
            this.labelZoomLevel.getFont().getSize()
        );
        this.labelZoomLevel.setFont(labelFont);
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
        this.buttonNewProject.setActionCommand(Labels.BAR_ITEM_NEW_PROJECT_NAME);
        this.buttonOpenProject.setActionCommand(Labels.BAR_ITEM_OPEN_PROJECT_NAME);
        this.buttonSaveProject.setActionCommand(Labels.BAR_ITEM_SAVE_PROJECT_NAME);
        this.buttonSaveAsProject.setActionCommand(Labels.BAR_ITEM_SAVE_AS_PROJECT_NAME);
        this.buttonCloseProject.setActionCommand(Labels.BAR_ITEM_CLOSE_PROJECT_NAME);

        this.buttonZoomOut.setActionCommand(Labels.BAR_ITEM_ZOOM_OUT_NAME);
        this.buttonZoomIn.setActionCommand(Labels.BAR_ITEM_ZOOM_IN_NAME);

        this.buttonAddNotation.setActionCommand(Labels.BAR_ITEM_ADD_NOTATION_NAME);


        // Tooltip Text
        this.buttonNewProject.setToolTipText(Labels.BAR_ITEM_NEW_PROJECT_NAME);
        this.buttonOpenProject.setToolTipText(Labels.BAR_ITEM_OPEN_PROJECT_NAME);
        this.buttonSaveProject.setToolTipText(Labels.BAR_ITEM_SAVE_PROJECT_NAME);
        this.buttonSaveAsProject.setToolTipText(Labels.BAR_ITEM_SAVE_AS_PROJECT_NAME);
        this.buttonCloseProject.setToolTipText(Labels.BAR_ITEM_CLOSE_PROJECT_NAME);

        this.buttonZoomOut.setToolTipText(Labels.BAR_ITEM_ZOOM_OUT_NAME);
        this.buttonZoomIn.setToolTipText(Labels.BAR_ITEM_ZOOM_IN_NAME);

        this.buttonAddNotation.setToolTipText(Labels.BAR_ITEM_ADD_NOTATION_NAME);


        // Image
        this.buttonNewProject.setIcon(new ImageIcon(Labels.TOOLBAR_BUTTON_NEW_PROJECT_ICON_PATH));
        this.buttonOpenProject.setIcon(new ImageIcon(Labels.TOOLBAR_BUTTON_OPEN_PROJECT_ICON_PATH));
        this.buttonSaveProject.setIcon(new ImageIcon(Labels.TOOLBAR_BUTTON_SAVE_PROJECT_ICON_PATH));
        this.buttonSaveAsProject.setIcon(new ImageIcon(Labels.TOOLBAR_BUTTON_SAVE_AS_PROJECT_ICON_PATH));
        this.buttonCloseProject.setIcon(new ImageIcon(Labels.TOOLBAR_BUTTON_CLOSE_PROJECT_ICON_PATH));

        this.buttonZoomOut.setIcon(new ImageIcon(Labels.TOOLBAR_BUTTON_ZOOM_OUT_ICON_PATH));
        this.buttonZoomIn.setIcon(new ImageIcon(Labels.TOOLBAR_BUTTON_ZOOM_IN_ICON_PATH));

        this.buttonAddNotation.setIcon(new ImageIcon(Labels.TOOLBAR_BUTTON_ADD_NOTATION_ICON_PATH));


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
        this.add(this.labelZoomLevel);
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Enables or disables the save-project-button.
     */
    public void setButtonSaveProjectEnabled(boolean enabled)
    {
        this.buttonSaveProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Enables or disables the save-project-as-button.
     */
    public void setButtonSaveAsProjectEnabled(boolean enabled)
    {
        this.buttonSaveAsProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Enables or disables the close-project-button.
     */
    public void setButtonCloseProjectEnabled(boolean enabled)
    {
        this.buttonCloseProject.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Enables or disables the zoom-in-button.
     */
    public void setButtonZoomInEnabled(boolean enabled)
    {
        this.buttonZoomIn.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Enables or disables the zoom-out-button.
     */
    public void setButtonZoomOutEnabled(boolean enabled)
    {
        this.buttonZoomOut.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Enables or disables the add-notation-button.
     */
    public void setButtonAddNotationEnabled(boolean enabled)
    {
        this.buttonAddNotation.setEnabled(enabled);
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Alters the label with the current zoom level.
     */
    public void setLabelZoomLevel(double zoomLevel)
    {
        String newZoomString = Integer.toString(
            (int) (zoomLevel * Environment.TOTAL_PERCENTAGE)
        );

        this.labelZoomLevel.setText(newZoomString + " %");
    }

}
