package model;

import factories.PdfObjectFactory;

import java.awt.Point;
import java.util.ArrayList;

public class PdfObject {

    public static final int SELECTED_NOTAION_NULL_VALUE = -1;

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
        this.selectedNotationIndex = PdfObject.SELECTED_NOTAION_NULL_VALUE;
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

    public int getListOfNotationsSize()
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
