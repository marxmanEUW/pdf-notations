package listeners;

import factories.DialogFactory;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class EditorPaneListener implements HyperlinkListener {

    /*
     *
     * @author AbellaMort
     * @changes
     *      2018-02-20 (AbellaMort) created
     * @brief   Listener that implements HyperlinkListener that opens the machines
     *          default browser when a hyperlink is clicked
     *
     */

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e)
    {
      if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
      {
          try {
              Desktop.getDesktop().browse(e.getURL().toURI());
          }
          catch (URISyntaxException syntaxException)
          {
              DialogFactory.showErrorDialog(syntaxException.getMessage());
          }
          catch (IOException ioException)
          {
              DialogFactory.showErrorDialog(ioException.getMessage());
          }
      }
    }

}
