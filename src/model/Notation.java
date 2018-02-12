package model;

import model.entity.Entity;

import java.util.ArrayList;

public class Notation {

    public static final String STANDARD_NAME = "Punkt";
    public static final Double STANDARD_DESCRIPTION = 42.0;

    // @todo timestamp

    private ArrayList<Entity> listOfEntities;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public Notation(ArrayList<Entity> listOfEntities)
    {
        this.listOfEntities = listOfEntities;
    }

    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    // @todo implement old getter for easier handling
    public Object getValue(int index)
    {
        return this.listOfEntities.get(index).getValue();
    }

    public String getValueName(int index)
    {
        return this.listOfEntities.get(index).getName();
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    public void setValue(int index, Object value)
    {
        this.listOfEntities.get(index).setValue(value);
    }
}
