package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import factories.DialogFactory;
import factories.PdfObjectFactory;
import gui.Constants;
import model.PdfObject;
import view.projectView.pdfObjectView.PdfObjectView;
import view.projectView.pdfObjectView.partials.PdfArea;


public class MenuBarActionListener implements ActionListener {

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
            case Constants.MENUITEM_NEW_PROJECT_NAME:
                System.out.println("Ich erstelle ein neues Projekt.");
                break;
            case Constants.MENUITEM_OPEN_PROJECT_NAME:
                // @todo OpenFileDialog
                System.out.println("Ich öffne ein Projekt.");

                File openFile = DialogFactory.getFileFromOpenDialog("JSON (*.json)", "pdfnot.json");
                // @todo create new PDFObject

                break;
            case Constants.MENUITEM_SAVE_POJECT_NAME:
                // @todo SaveFileDialog
                System.out.println("Ich speichere das Projekt.");

                /*
                 * @todo feature from yxyxD
                 */
                PdfObjectFactory.savePdfObjectForPdfFile(this.getPdfObject());

                break;
            case Constants.MENUITEM_SAVE_AS_PROJECT_NAME:
                // @todo SaveFileDialog
                System.out.println("Ich  speichere unter das Projekt.");

                File saveAsFile = DialogFactory.getFileFromSaveDialog("JSON (*.json)", "json");
                if (saveAsFile != null)
                {
                    this.getPdfObject().setJsonAbsolutePath(saveAsFile.getAbsolutePath());
                    PdfObjectFactory.savePdfObjectForPdfFile(this.getPdfObject());
                }


                break;
            case Constants.MENUITEM_CLOSE_PROJECT_NAME:
                // @todo Close PdfObject
                System.out.println("Ich schließe das Projekt.");
                break;
            case Constants.MENUITEM_CLOSE_NAME:
                // @todo letzte Änderungen Speichern bevor man schließt
                System.exit(0);
                break;
            case Constants.MENUITEM_ADD_NOTATION_NAME:
                // @todo Add Notation
                System.out.println("Ich bin ein neue Notation.");
                this.getPdfArea().setAddingNotation(true);
                this.getPdfArea().setCursorTypeToCrosshair();
                break;
            case Constants.MENUITEM_DELETE_NOTATION_NAME:
                // @todo Delete Notation
                System.out.println("Ich löschen eine Notation.");
                break;
            case Constants.MENUITEM_ABOUT_NAME:
                // @todo Show About Information
                System.out.println("Ich zeige die About Informationen.");
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

    /*
     * @author  marxmanEUW
     */
    private PdfArea getPdfArea()
    {
        return this.pdfObjectView.getPdfArea();
    }
}
