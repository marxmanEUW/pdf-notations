package model;

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
    public Object getValue(int index)
    {
        return this.listOfEntities.get(index).getValue();
    }

    public String getValueName(int index)
    {
        return this.listOfEntities.get(index).getValueName();
    }

    public String getValueType(int index)
    {
        return this.listOfEntities.get(index).getValueType();
    }

    // @todo maybe set 0, 1 and 2 to global constants
    public int getId()
    {
        return (int) this.listOfEntities.get(0).getValue();
    }

    public int getX()
    {
        return (int) this.listOfEntities.get(1).getValue();
    }

    public int getY()
    {
        return (int) this.listOfEntities.get(2).getValue();
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    public void setValue(int entityIndex, Object value)
    {
        this.listOfEntities.get(entityIndex).setValue(value);
    }

    public void setX(int xValue)
    {
        this.listOfEntities.get(1).setValue(xValue);
    }

    public void setY(int yValue)
    {
        this.listOfEntities.get(2).setValue(yValue);
    }
}
