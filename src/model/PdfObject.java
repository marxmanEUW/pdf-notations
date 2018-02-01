package model;

import factories.PdfObjectFactory;

import java.awt.Point;
import java.util.ArrayList;

public class PdfObject {

    public static final int SELECTED_NOTATION_NULL_VALUE = -1;

    private String pdfAbsolutePath;
    private String jsonAbsolutePath;

    private ArrayList<Notation> listOfNotations;
    private int selectedNotationIndex;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public PdfObject(String pdfAbsolutePath)
    {
        this.pdfAbsolutePath = pdfAbsolutePath;
        //this.jsonAbsolutePath = PdfObjectFactory.getAbsolutePathToJsonFile(pdfAbsolutePath);

        this.listOfNotations = new ArrayList<>();
        this.selectedNotationIndex = PdfObject.SELECTED_NOTATION_NULL_VALUE;
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
        return this.jsonAbsolutePath;
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
            listOfPoints.add(notation.getCoordinates());
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
    /*
     * @author  yxyxD
     */
    public void addNewNotation(Point coordinates)
    {
        this.listOfNotations.add(new Notation(
            this.getIdForNextNotation(),
            coordinates
        ));
    }

    /*
     * @author  marxmanEUW
     */
    public void deleteSelectedNotation()
    {
        this.listOfNotations.remove(this.selectedNotationIndex);
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     */
    private int getIdForNextNotation()
    {
        int nextId = 0;
        for (Notation notation : this.listOfNotations)
        {
            int notationID = notation.getId();
            if (notationID >= nextId)
            {
                nextId = notationID + 1;
            }
        }

        return nextId;
    }
}
