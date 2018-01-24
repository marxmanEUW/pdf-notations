package model;

import java.awt.Point;
import java.util.ArrayList;

public class PdfObject {

    private String sourePath;

    private ArrayList<Notation> listOfNotations;
    private int selectedNotationIndex;


    // @todo testing
    private int counter;


    /*
     * #########################################################################
     * #                    Konstruktor                                        #
     * #########################################################################
     */
    public PdfObject()
    {
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
    public String getSourePath()
    {
        return this.sourePath;
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
     * @author  yxyxD
     */
    public void setSourePath(String sourePath)
    {
        this.sourePath = sourePath;
    }

    /*
     * #########################################################################
     * #                    öffentliche Methoden                               #
     * #########################################################################
     */

    // wird aufgerufen, wenn in MenuBar der Button "Notation hinzufügen" gedrückt wird
    public void addNotation()
    {
        // @todo implementieren
    }

    public void addNotationAtXY(int x, int y)
    {
        Notation newNotation = new Notation(counter++,"Punkt", x, y);
        this.listOfNotations.add(newNotation);
    }
}
