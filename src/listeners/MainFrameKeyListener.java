package listeners;

import model.PdfObject;
import view.MainFrame;
import view.projectView.pdfObjectView.PdfObjectView;
import view.projectView.pdfObjectView.partials.PdfArea;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrameKeyListener implements KeyListener {

    private MainFrame mainFrame;


    /*
     * #########################################################################
     * #                    Initialising                                       #
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
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfObjectView.
     */
    private PdfObjectView getPdfObjectView()
    {
        return this.mainFrame.getPdfObjectView();
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfObject of the PdfObjectView.
     */
    private PdfObject getPdfObject()
    {
        return this.getPdfObjectView().getPdfObject();
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the PdfArea of the PdfObjectView.
     */
    private PdfArea getPdfArea()
    {
        return this.getPdfObjectView().getPdfArea();
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
            this.getPdfArea().setAddingNotation(false);
            this.getPdfArea().setCursorTypeToDefault();
        }
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Gets called when a key is typed.
     */
    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Gets called when a key is pressed.
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
    }
}
