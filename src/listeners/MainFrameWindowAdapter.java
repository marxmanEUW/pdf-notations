package listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrameWindowAdapter extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent evt)
    {
        System.exit(0);
    }
}
