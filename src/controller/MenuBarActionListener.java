package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Constants;
import gui.partials.PdfArea;
import model.Project;

public class MenuBarActionListener implements ActionListener {

    private Project project;
    private PdfArea pdfArea;

    public void initialize(Project project, PdfArea pdfArea)
    {
        this.project = project;
        this.pdfArea = pdfArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()) {
            case Constants.MENUITEM_NEW_PROJECT_NAME:
                System.out.println("Ich erstelle ein neues Projekt.");
                break;
            case Constants.MENUITEM_OPEN_PROJECT_NAME:
                // @todo OpenFileDialog
                System.out.println("Ich öffne das Projekt.");
                break;
            case Constants.MENUITEM_SAVE_PROJECT_NAME:
                // @todo SaveFileDialog
                System.out.println("Ich speichere das Projekt.");
                break;
            case Constants.MENUITEM_SAVE_AS_PROJECT_NAME:
                // @todo SaveFileDialog
                System.out.println("Ich  speichere unter das Projekt.");
                break;
            case Constants.MENUITEM_CLOSE_PROJECT_NAME:
                // @todo Close Project
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
                this.project.addNotation();
                this.pdfArea.setCursor(Cursor.CROSSHAIR_CURSOR);

                break;
            case Constants.MENUITEM_ABOUT_NAME:
                // @todo Show About Information
                System.out.println("Ich zeige die About Informationen.");
                break;
        }
    }
}
