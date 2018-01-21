package model;

import java.awt.*;

/*
 * @todo !obsolete Klasse
 */
public class NotationCon {

    public static final int INFORMATION_COUNT = 2;

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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
/// Constructor

    public NotationCon(Integer id, String name, int x, int y)
    {
        this.id = id;
        this.name = name;
        this.coordinates = new Point(x, y);
    }

}
