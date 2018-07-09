package model;

import javafx.geometry.Point2D;

import java.awt.*;
import java.util.ArrayList;

public class Notation {

    public static final String STANDARD_NAME = "Punkt";
    public static final Double STANDARD_DESCRIPTION = 42.0;

    private ArrayList<Entity> listOfEntities;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */

/*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Constructs a Notation which contains information about a point
     *          on the PdfArea
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

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the ID of the notation.
     */
    // @todo maybe set 0, 1 and 2 to global constants
    public int getId()
    {
        return Integer.valueOf(this.listOfEntities.get(0).getValue());
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the x-coordinate of the notation.
     */
    public int getX()
    {
        return Integer.valueOf(this.listOfEntities.get(1).getValue());
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the y-coordinate of the notation.
     */
    public int getY()
    {
        return Integer.valueOf(this.listOfEntities.get(2).getValue());
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the y-coordinate of the notation.
     */
    public Point2D getCoordinates()
    {
        return new Point2D(this.getX(), this.getY());
    }

    public Point getCoordinatesAsOldPoint()
    {
        return new Point(this.getX(), this.getY());
    }

    public ArrayList<Entity> getListOfEntities()
    {
        return listOfEntities;
    }

    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the value at entityIndex of the notation.
     */
    public void setValue(int entityIndex, String value)
    {
        this.listOfEntities.get(entityIndex).setValue(value);
    }

    public void setValue(int entityIndex, Integer value)
    {
        this.setValue(entityIndex, String.valueOf(value));
    }

    public void setValue(int entityIndex, Double value)
    {
        this.setValue(entityIndex, String.valueOf(value));
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the x-coordinate of the notation.
     */
    public void setX(int xValue)
    {
        this.listOfEntities.get(1).setValue(String.valueOf(xValue));
    }


    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the y-coordinate of the notation.
     */
    public void setY(int yValue)
    {
        this.listOfEntities.get(2).setValue(String.valueOf(yValue));
    }
}
