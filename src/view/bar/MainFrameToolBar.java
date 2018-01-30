package view.bar;

import gui.Constants;
import listeners.ToolBarActionListener;

import javax.swing.*;

public class MainFrameToolBar extends JToolBar {

    private JButton buttonNewDataFile;
    private JButton buttonOpenDataFile;
    private JButton buttonSaveDataFile;
    private JButton buttonSaveAsDataFile;
    private JButton buttonCloseDataFile;

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
        this.buttonNewDataFile = new JButton();
        this.buttonOpenDataFile = new JButton();
        this.buttonSaveDataFile = new JButton();
        this.buttonSaveAsDataFile = new JButton();
        this.buttonCloseDataFile = new JButton();

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
    public void initialize(ToolBarActionListener toolBarActionListener)
    {
        this.toolBarActionListener = toolBarActionListener;

        // ActionCommand
        this.buttonNewDataFile.setActionCommand(Constants.TOOLBAR_BUTTON_NEW_DATAFILE_NAME);
        this.buttonOpenDataFile.setActionCommand(Constants.TOOLBAR_BUTTON_OPEN_DATAFILE_NAME);
        this.buttonSaveDataFile.setActionCommand(Constants.TOOLBAR_BUTTON_SAVE_DATAFILE_NAME);
        this.buttonSaveAsDataFile.setActionCommand(Constants.TOOLBAR_BUTTON_SAVE_AS_DATAFILE_NAME);
        this.buttonCloseDataFile.setActionCommand(Constants.TOOLBAR_BUTTON_CLOSE_DATAFILE_NAME);

        this.buttonZoomIn.setActionCommand(Constants.TOOLBAR_BUTTON_ZOOM_IN_NAME);
        this.buttonZoomOut.setActionCommand(Constants.TOOLBAR_BUTTON_ZOOM_OUT_NAME);

        this.buttonAddNotation.setActionCommand(Constants.TOOLBAR_BUTTON_ADD_NOTATION_NAME);

        // Tooltip Text
        this.buttonNewDataFile.setToolTipText(Constants.TOOLBAR_BUTTON_NEW_DATAFILE_NAME);
        this.buttonOpenDataFile.setToolTipText(Constants.TOOLBAR_BUTTON_OPEN_DATAFILE_NAME);
        this.buttonSaveDataFile.setToolTipText(Constants.TOOLBAR_BUTTON_SAVE_DATAFILE_NAME);
        this.buttonSaveAsDataFile.setToolTipText(Constants.TOOLBAR_BUTTON_SAVE_AS_DATAFILE_NAME);
        this.buttonCloseDataFile.setToolTipText(Constants.TOOLBAR_BUTTON_CLOSE_DATAFILE_NAME);

        this.buttonZoomIn.setToolTipText(Constants.TOOLBAR_BUTTON_ZOOM_IN_NAME);
        this.buttonZoomOut.setToolTipText(Constants.TOOLBAR_BUTTON_ZOOM_OUT_NAME);

        this.buttonAddNotation.setToolTipText(Constants.TOOLBAR_BUTTON_ADD_NOTATION_NAME);

        // Image
        this.buttonNewDataFile.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_NEW_DATAFILE_ICON_PATH));
        this.buttonOpenDataFile.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_OPEN_DATAFILE_ICON_PATH));
        this.buttonSaveDataFile.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_SAVE_DATAFILE_ICON_PATH));
        this.buttonSaveAsDataFile.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_SAVE_AS_DATAFILE_ICON_PATH));
        this.buttonCloseDataFile.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_CLOSE_DATAFILE_ICON_PATH));

        this.buttonZoomIn.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_ZOOM_IN_ICON_PATH));
        this.buttonZoomOut.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_ZOOM_OUT_ICON_PATH));

        this.buttonAddNotation.setIcon(new ImageIcon(Constants.TOOLBAR_BUTTON_ADD_NOTATION_ICON_PATH));

        // Action Listener
        this.buttonNewDataFile.addActionListener(this.toolBarActionListener);
        this.buttonOpenDataFile.addActionListener(this.toolBarActionListener);
        this.buttonSaveDataFile.addActionListener(this.toolBarActionListener);
        this.buttonSaveAsDataFile.addActionListener(this.toolBarActionListener);
        this.buttonCloseDataFile.addActionListener(this.toolBarActionListener);

        this.buttonZoomIn.addActionListener(this.toolBarActionListener);
        this.buttonZoomOut.addActionListener(this.toolBarActionListener);

        this.buttonAddNotation.addActionListener(this.toolBarActionListener);

        // add
        this.add(this.buttonNewDataFile);
        this.add(this.buttonOpenDataFile);
        this.add(this.buttonSaveDataFile);
        this.add(this.buttonSaveAsDataFile);
        this.add(this.buttonCloseDataFile);

        this.addSeparator();

        this.add(this.buttonZoomIn);
        this.add(this.buttonZoomOut);

        this.addSeparator();

        this.add(this.buttonAddNotation);
    }
}
