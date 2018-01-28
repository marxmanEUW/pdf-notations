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

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


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
            case Constants.MENUITEM_NEW_DATAFILE_NAME:
                System.out.println("Ich erstelle ein neues Datendatei.");
                break;
            case Constants.MENUITEM_OPEN_DATAFILE_NAME:
                // @todo OpenFileDialog
                System.out.println("Ich öffne das eine neue Datendatei.");

                File openFile = DialogFactory.getFileFromOpenDialog("JSON (*.json)", "json");
                // @todo create new PDFObject

                break;
            case Constants.MENUITEM_SAVE_DATAFILE_NAME:
                // @todo SaveFileDialog
                System.out.println("Ich speichere die Datendatei.");

                /*
                 * @todo feature from yxyxD
                 */
                PdfObjectFactory.savePdfObjectForPdfFile(this.getPdfObject());

                break;
            case Constants.MENUITEM_SAVE_AS_DATAFILE_NAME:
                // @todo SaveFileDialog
                System.out.println("Ich  speichere unter das Projekt.");

                File saveAsFile = DialogFactory.getFileFromSaveDialog("JSON (*.json)", "json");
                this.getPdfObject().setJsonAbsolutePath(saveAsFile.getAbsolutePath());
                PdfObjectFactory.savePdfObjectForPdfFile(this.getPdfObject());

                break;
            case Constants.MENUITEM_CLOSE_DATAFILE_NAME:
                // @todo Close PdfObject
                System.out.println("Ich schließe das Projekt.");
                break;
            case Constants.MENUITEM_CLOSE_NAME:
                // @todo letzte Änderungen Speichern bevor man schließt
                System.exit(0);
                break;
            case Constants.MENUITEM_IMPORT_PDF_NAME:
                // @todo Import PDF + Open File Dialog
                System.out.println("Ich importiere eine neue PDF.");
                break;
            case Constants.MENUITEM_SHOW_LIST_NAME:
                // @todo Show Noations List
                System.out.println("Ich zeige die Liste der Notationen.");
                break;
            case Constants.MENUITEM_ADD_NOTATION_NAME:
                // @todo Add Notation
                System.out.println("Ich bin ein neue Notation.");
                this.getPdfArea().setAddingNotation(true);
                this.getPdfArea().setCursorTypeToCrosshair();
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
