package fx_handler;

import fx_view.FXMainFrame;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.html.HTMLAnchorElement;


public class FXHyperlinkChangeListener implements ChangeListener<Worker.State> {

    private FXMainFrame mainFrame;
    private WebEngine webEngine;

    /*
     * #########################################################################
     * #                    Initializing                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void initialize(FXMainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        this.webEngine = null;
    }


    /*
     * #########################################################################
     * #                    Overrides                                          #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @todo move EventListener to separate class
     */
    @Override
    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue)
    {
        if (this.webEngine == null) { return; }

        if (newValue == Worker.State.SUCCEEDED) {
            Document document = this.webEngine.getDocument();

            NodeList nodeList = document.getElementsByTagName("a");
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node= nodeList.item(i);
                EventTarget eventTarget = (EventTarget) node;
                eventTarget.addEventListener("click", new EventListener()
                {
                    @Override
                    public void handleEvent(Event event)
                    {
                        EventTarget target = event.getCurrentTarget();
                        HTMLAnchorElement anchorElement = (HTMLAnchorElement) target;
                        String href = anchorElement.getHref();
                        mainFrame.getHostServices().showDocument(href);
                        event.preventDefault();
                    }
                }, false);
            }
        }
    }

    /*
     * #########################################################################
     * #                    Public Methods                                     #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     */
    public void setWebEngine(WebEngine webEngine)
    {
        this.webEngine = webEngine;
    }
}
