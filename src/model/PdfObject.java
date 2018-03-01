package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class PdfObject {

    public static final int SELECTED_NOTATION_NULL_VALUE = -1;

    private String pdfAbsolutePath;
    private String jsonAbsolutePath;

    private HashMap<Integer, Notation> listOfNotations;
    private int selectedNotationIndex;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Constructs a PdfObject.
     */
    public PdfObject(String pdfAbsolutePath)
    {
        this.pdfAbsolutePath = pdfAbsolutePath;
        //this.jsonAbsolutePath = PdfObjectFactory.getAbsolutePathToJsonFile(pdfAbsolutePath);

        this.listOfNotations = new HashMap<>();
        this.selectedNotationIndex = PdfObject.SELECTED_NOTATION_NULL_VALUE;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the absolute path to the pdf-file.
     */
    public String getPdfAbsolutePath()
    {
        return this.pdfAbsolutePath;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   returns the absolute path to the json-file.
     */
    public String getJsonAbsolutePath()
    {
        return this.jsonAbsolutePath;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the ListOfNotations of the PdfObject.
     */
    public HashMap<Integer, Notation> getListOfNotations()
    {
        return this.listOfNotations;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the ListOfPoints of the PdfObject.
     */
    public ArrayList<Point> getListOfPoints()
    {
        ArrayList<Point> listOfPoints = new ArrayList<>();
        this.listOfNotations.forEach(
            (key, value) -> listOfPoints.add(value.getCoordinates())
        );
        return listOfPoints;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the selected notation of the PdfObject.
     *          Returns null if no notation was selected.
     */
    public Notation getSelectedNotation()
    {
        if (this.selectedNotationIndex != SELECTED_NOTATION_NULL_VALUE)
        {
            return this.listOfNotations.get(selectedNotationIndex);
        }
        else
        {
            return null;
        }
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the ID/index of the selected notation of the PdfObject.
     */
    public int getSelectedNotationIndex()
    {
        return selectedNotationIndex;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the ListOfNotations of the PdfObject as ArrayList.
     */
    public ArrayList<Notation> getListOfNotationsAsList()
    {
        ArrayList<Notation> listOfNotationsAsList = new ArrayList<>();
        listOfNotationsAsList.addAll(this.listOfNotations.values());
        return listOfNotationsAsList;
    }

    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Sets the absolute path to the pdfnot-file.
     */
    public void setJsonAbsolutePath(String jsonAbsolutePath)
    {
        this.jsonAbsolutePath = jsonAbsolutePath;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Sets the SelectedNotationIndex of the PdfObject.
     */
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Adds a new notation to the pdf-file.
     */
    public void addNewNotation(Point coordinates)
    {
        int nextId = this.getIdForNextNotation();

        Notation newNotation = new Notation(
            nextId,
            coordinates
        );

        this.listOfNotations.put(nextId, newNotation);
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Deletes the selected notation.
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
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Returns the ID for the next notation to be created.
     */
    private int getIdForNextNotation()
    {
        int nextId = 0;

        for (Notation notation : this.listOfNotations.values())
        {
            int notationId = notation.getId();
            if (notationId >= nextId)
            {
                nextId = notationId + 1;
            }
        }

        return nextId;
    }
}
