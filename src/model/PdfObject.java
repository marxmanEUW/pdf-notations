package model;

import java.awt.Point;
import java.util.ArrayList;

public class PdfObject {

    private String sourcePath;

    private ArrayList<Notation> listOfNotations;
    private int selectedNotationIndex;


    // @todo testing
    private int counter;


    /*
     * #########################################################################
     * #                    Konstruktor                                        #
     * #########################################################################
     */
    public PdfObject(String sourcePath)
    {
        this.sourcePath = sourcePath;
        this.listOfNotations = new ArrayList<>();
        this.selectedNotationIndex = -1;
        this.counter = 0;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */

    public ArrayList<Point> getListOfPoints()
    {
        ArrayList<Point> listOfPoints = new ArrayList<>();
        for (Notation notation : this.listOfNotations)
        {
            listOfPoints.add(new Point(notation.getX(), notation.getY()));
        }
        return listOfPoints;
    }

    public ArrayList<Notation> getListOfNotations()
    {
        return this.listOfNotations;
    }

    public int getListOfNotationConsSize()
    {
        return this.listOfNotations.size();
    }

    public Notation getSelectedNotation()
    {
        return this.listOfNotations.get(selectedNotationIndex);
    }

    public int getSelectedNotationIndex()
    {
        return selectedNotationIndex;
    }

    /*
     * @author  yxyxD
     */
    public String getSourcePath()
    {
        return this.sourcePath;
    }


    /*
     * @author  marxmanEUW
     * @todo calculate scaled x and y when zoomed in
     */
    public ArrayList<Notation> isNotationNear(int x, int y, int radius)
    {
        ArrayList<Notation> returnArrayList = new ArrayList<>();
        double distance;

        for (Notation notation : this.getListOfNotations()) {
            distance = Math.sqrt((notation.getX() - x)^2 + (notation.getY() - y)^2);
            if(distance <= radius){
                returnArrayList.add(notation);
            }
        }
        
        return returnArrayList;
    }

    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */

    public void setSelectedNotationIndex(int selectedNotationIndex)
    {
        this.selectedNotationIndex = selectedNotationIndex;
    }

    /*
     * #########################################################################
     * #                    öffentliche Methoden                               #
     * #########################################################################
     */

    public void addNotationAtXY(int x, int y)
    {
        Notation newNotation = new Notation(counter++,"Punkt", x, y);
        this.listOfNotations.add(newNotation);
    }
}
