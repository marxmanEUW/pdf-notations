package model;

import factories.PdfObjectFactory;

import java.awt.Point;
import java.util.ArrayList;

public class PdfObject {

    private String pdfAbsolutePath;
    private String jsonAbsolutePath;

    private ArrayList<Notation> listOfNotations;
    private int selectedNotationIndex;


    // @todo testing
    private int counter;


    /*
     * #########################################################################
     * #                    Konstruktor                                        #
     * #########################################################################
     */
    public PdfObject(String pdfAbsolutePath)
    {
        this.pdfAbsolutePath = pdfAbsolutePath;
        this.jsonAbsolutePath = PdfObjectFactory.getAbsolutePathToJsonFile(pdfAbsolutePath);

        this.listOfNotations = new ArrayList<>();
        this.selectedNotationIndex = -1;
        this.counter = 0;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    public String getPdfAbsolutePath()
    {
        return this.pdfAbsolutePath;
    }

    /*
     * @author  yxyxD
     */
    public String getJsonAbsolutePath()
    {
        return jsonAbsolutePath;
    }

    /*
     * @author  marxmanEUW
     */
    public ArrayList<Notation> getListOfNotations()
    {
        return this.listOfNotations;
    }




    public ArrayList<Point> getListOfPoints()
    {
        ArrayList<Point> listOfPoints = new ArrayList<>();
        for (Notation notation : this.listOfNotations)
        {
            listOfPoints.add(new Point(notation.getX(), notation.getY()));
        }
        return listOfPoints;
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
    /*
     * @author  yxyxD
     */
    public void setJsonAbsolutePath(String jsonAbsolutePath)
    {
        this.jsonAbsolutePath = jsonAbsolutePath;
    }

    public void setSelectedNotationIndex(int selectedNotationIndex)
    {
        this.selectedNotationIndex = selectedNotationIndex;
    }


    /*
     * #########################################################################
     * #                    Public Methods                                     #
     * #########################################################################
     */

    public void addNotationAtXY(int x, int y)
    {
        Notation newNotation = new Notation(counter++,"Punkt", x, y);
        this.listOfNotations.add(newNotation);
    }
}
