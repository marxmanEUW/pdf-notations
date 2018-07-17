package fx_handler;

import javafx.collections.MapChangeListener;
import model.MapEntry;
import model.Notation;
import model.PdfObject;

public class ListOfNotationMapChangeListener implements MapChangeListener<Integer, Notation> {

    private PdfObject pdfObject;

    /*
     * #########################################################################
     * #                    Initialising                                       #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-07-17 (marxmanEUW)  created
     * @brief   Initializes the ListOfNotationMapChangeListener.
     */
    public void initialize(PdfObject pdfObject)
    {
        this.pdfObject = pdfObject;
    }


    /*
     * #########################################################################
     * #                    Overrides                                         #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-07-17 (marxmanEUW)  created
     * @brief
     */

    @Override
    public void onChanged(Change<? extends Integer, ? extends Notation> change)
    {
        boolean removed = change.wasRemoved();
        if (removed != change.wasAdded()) {
            if (removed) {
                // no put for existing key
                // remove pair completely
                this.pdfObject.getListOfNotationsReadOnly().remove(new MapEntry<>(change.getKey(), (Notation) null));
            } else {
                // add new entry
                this.pdfObject.getListOfNotationsReadOnly().add(new MapEntry<>(change.getKey(), change.getValueAdded()));
            }
        } else {
            // replace existing entry
            MapEntry<Integer, Notation> entry = new MapEntry<>(change.getKey(), change.getValueAdded());

            int index = this.pdfObject.getListOfNotationsReadOnly().indexOf(entry);
            this.pdfObject.getListOfNotationsReadOnly().set(index, entry);
        }
    }
}
