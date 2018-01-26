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
    @Override
    public void keyReleased(KeyEvent e)
    {
        System.out.println( "typed " + e.getKeyChar() + " " + e.getSource());
        System.out.println( "typed " + e.getKeyCode() + " " + e.getSource());

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            System.out.println("Escape released");
            this.mainFrame.getPdfObjectView().getPdfArea().setAddingNotation(false);
            this.mainFrame.getPdfObjectView().getPdfArea().setCursorTypeToDeafault();
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
