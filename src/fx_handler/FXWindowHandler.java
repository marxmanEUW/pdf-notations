package fx_handler;

import factories.FXDialogFactory;
import fx_view.FXMainFrame;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class FXWindowHandler implements EventHandler<WindowEvent> {

    private FXMainFrame mainFrame;


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
    public void handle(WindowEvent event)
    {
        Optional<ButtonType> userChoice = FXDialogFactory.showWarningAtCloseDialog();
        if ((userChoice.isPresent()) && (userChoice.get() == ButtonType.OK))
        {
            this.mainFrame.getWindow().close();
        }
    }
}
