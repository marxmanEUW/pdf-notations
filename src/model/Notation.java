package model;

import java.awt.*;

public class Notation {

    public static final int INFORMATION_COUNT = 2;

    private int id;
    private String name;
    private Point coordinates;
    // @todo timestamp


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */

    public Notation(Integer id, String name, int x, int y)
    {
        this.id = id;
        this.name = name;
        this.coordinates = new Point(x, y);
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */

    public int getX()
    {
        return this.coordinates.x;
    }

    public int getY()
    {
        return this.coordinates.y;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
