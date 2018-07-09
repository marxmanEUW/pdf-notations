package fx_handler;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import model.Entity;

public class FXNotationEntityCellHandler implements EventHandler<TableColumn.CellEditEvent<Entity, String>> {

    @Override
    public void handle(TableColumn.CellEditEvent event)
    {
        System.out.println("old Value: " + event.getOldValue());
        System.out.println("new Value: " + event.getNewValue());
    }
}
