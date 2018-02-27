package listeners;

import factories.DialogFactory;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrameWindowAdapter extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent evt)
    {
        int userChoice = DialogFactory.showWarningAtCloseDialog();
        if (userChoice == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
}
