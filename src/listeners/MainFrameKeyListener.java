package listeners;

import view.MainFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrameKeyListener implements KeyListener {

    private MainFrame mainFrame;


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Initializes the MainFrameKeyListener.
     */
    public void initialize(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Gets called when a key is released.
     *          If "Escape"-Key was released it sets some variables to abort
     *          procedure to add a notation.
     */
    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.mainFrame.getPdfObjectView().getPdfArea().setAddingNotation(false);
            this.mainFrame.getPdfObjectView().getPdfArea().setCursorTypeToDefault();
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }
}
