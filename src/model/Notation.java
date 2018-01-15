package model;

import java.awt.*;

public class Notation {

    private Integer id;
    private String name;
    private Point coordinates;
    // @todo timestamp


    /// Getter

    public int getX()
    {
        return this.coordinates.x;
    }

    public int getY()
    {
        return this.coordinates.y;
    }


    /// Constructor

    public Notation(Integer id, String name, Point coordinates)
    {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

}
