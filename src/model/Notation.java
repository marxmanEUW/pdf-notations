package model;

import constants.Environment;

import java.awt.*;

public class Notation {

    private int id;
    private String name;
    private Point coordinates;
    private String description;


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
    public Notation(Integer id, Point coordinates)
    {
        this.id = id;
        this.name = Environment.STANDARD_NAME + "_" + Integer.toString(id);
        this.coordinates = coordinates;
        this.description = Environment.STANDARD_DESCRIPTION;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the ID of the notation.
     */
    public int getId() {
        return id;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the name of the notation.
     */
    public String getName() {
        return name;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the coordinates of the notation.
     */
    public Point getCoordinates()
    {
        return this.coordinates;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the x-coordinate of the notation.
     */
    public int getX()
    {
        return this.coordinates.x;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the y-coordinate of the notation.
     */
    public int getY()
    {
        return this.coordinates.y;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the description of the notation.
     */
    public String getDescription()
    {
        return description;
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
     * @brief   Sets the name of the notation.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the x-coordinate of the notation.
     */
    public void setX(int x)
    {
        this.coordinates.x = x;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the y-coordinate of the notation.
     */
    public void setY(int y)
    {
        this.coordinates.y = y;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the description of the notation.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
}
