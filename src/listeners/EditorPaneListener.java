package listeners;

import factories.DialogFactory;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;

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
          catch (Exception exception)
          {
              DialogFactory.showErrorDialog(exception.getMessage());
          }
      }
    }

}
