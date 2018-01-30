package listeners;

import gui.Constants;
import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarActionListener implements ActionListener {

    private PdfObjectView pdfObjectView;


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void initialize(PdfObjectView pdfObjectView)
    {
        this.pdfObjectView = pdfObjectView;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()) {
            case Constants.TOOLBAR_BUTTON_NEW_PROJECT_NAME:
                System.out.println("Ich erstelle ein neues Projekt.");
                break;
            case Constants.TOOLBAR_BUTTON_OPEN_PROJECT_NAME:
                // @todo OpenFileDialog
                System.out.println("Ich öffne das Projekt.");
                break;
            case Constants.TOOLBAR_BUTTON_SAVE_PROJECT_NAME:
                // @todo SaveFileDialog
                System.out.println("Ich speichere das Projekt.");
                break;
            case Constants.TOOLBAR_BUTTON_SAVE_AS_PROJECT_NAME:
                // @todo SaveFileDialog
                System.out.println("Ich  speichere unter das Projekt.");
                break;
            case Constants.TOOLBAR_BUTTON_CLOSE_PROJECT_NAME:
                // @todo Close PdfObject
                System.out.println("Ich schließe das Projekt.");
                break;
            case Constants.TOOLBAR_BUTTON_ZOOM_IN_NAME:
                // @todo Close PdfObject
                System.out.println("Ich zoome rein.");
                break;
            case Constants.TOOLBAR_BUTTON_ZOOM_OUT_NAME:
                // @todo Close PdfObject
                System.out.println("Ich zoome raus.");
                break;
            case Constants.TOOLBAR_BUTTON_ADD_NOTATION_NAME:
                // @todo Add Notation
                System.out.println("Ich bin ein neue Notation.");
                break;

        }
    }


    /*
     * #########################################################################
     * #                    private Hilfsmethode                               #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    private PdfObject getPdfObject()
    {
        return this.pdfObjectView.getPdfObject();
    }
}
