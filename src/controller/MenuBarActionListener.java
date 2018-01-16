package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Constants;

public class MenuBarActionListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()) {
            case Constants.MENUITEM_NEW_PROJECT_NAME:
                System.out.println("Ich bin ein neues Projekt.");
                break;
            case Constants.MENUITEM_OPEN_PROJECT_NAME:
                // @todo OpenFileDialog
                System.out.println("Ich bin ein geöffnetes Projekt.");
                break;
            case Constants.MENUITEM_SAVE_PROJECT_NAME:
                // @todo SaveFileDialog
                System.out.println("Ich bin ein gespeichertes Projekt.");
                break;
            case Constants.MENUITEM_SAVE_AS_PROJECT_NAME:
                // @todo SaveFileDialog
                System.out.println("Ich bin ein gespeichert als Projekt.");
                break;
            case Constants.MENUITEM_CLOSE_PROJECT_NAME:
                // @todo Close Project
                System.out.println("Ich bin ein geschlossenes Projekt.");
                break;
            case Constants.MENUITEM_CLOSE_NAME:
                System.exit(0);
                break;

        }
    }
}
