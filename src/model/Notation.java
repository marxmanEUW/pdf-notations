package model;

import java.awt.*;

public class Notation {

    public static final int INFORMATION_COUNT = 3;

    private int id;
    private String name;
    private Point coordinates;
    private String description;
    // @todo timestamp


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */

    public Notation(Integer id, String name, int x, int y, String description)
    {
        this.id = id;
        this.name = name;
        this.coordinates = new Point(x, y);
        this.description = description;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Point getCoordinates()
    {
        return this.coordinates;
    }

    public int getX()
    {
        return this.coordinates.x;
    }

    public int getY()
    {
        return this.coordinates.y;
    }

    public String getDescription()
    {
        return description;
    }

    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCoordinates(Point coordinates)
    {
        this.coordinates = coordinates;
    }

    public void setX(int x)
    {
        this.coordinates.x = x;
    }

    public void setY(int y)
    {
        this.coordinates.y = y;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
