package model;

import java.awt.*;

/*
 * @todo !obsolete Klasse
 */
public class NotationCon {

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

    public NotationCon(Integer id, String name, int x, int y)
    {
        this.id = id;
        this.name = name;
        this.coordinates = new Point(x, y);
    }

}
