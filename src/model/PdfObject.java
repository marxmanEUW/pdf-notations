package model;

import constants.Environment;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class PdfObject {

    private String pdfAbsolutePath;
    private String jsonAbsolutePath;

    private HashMap<Integer, Notation> listOfNotations;
    private int selectedNotationId;


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

        this.listOfNotations = new HashMap<>();
        this.selectedNotationId = Environment.SELECTED_NOTATION_NULL_VALUE;
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
        if (this.selectedNotationId !=
            Environment.SELECTED_NOTATION_NULL_VALUE)
        {
            return this.listOfNotations.get(selectedNotationId);
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
    public int getSelectedNotationId()
    {
        return selectedNotationId;
    }

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-02-12 (marxmanEUW)  created
     * @brief   Returns the ListOfNotations of the PdfObject as ArrayList.
     */
    public ArrayList<Notation> getListOfNotationsAsList()
    {
        return new ArrayList<>(this.listOfNotations.values());
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
    public void setSelectedNotationId(int selectedNotationId)
    {
        this.selectedNotationId = selectedNotationId;
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
        this.listOfNotations.remove(this.selectedNotationId);
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
