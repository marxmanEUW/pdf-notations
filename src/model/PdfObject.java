package model;

import constants.Environment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.HashMap;

public class PdfObject {

    private String pdfAbsolutePath;
    private String jsonAbsolutePath;

    private HashMap<Integer, Notation> listOfNotations;
    private int selectedNotationId;
    private ArrayList<String[]> listOfEntityNamesAndTypes;

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

        this.listOfEntityNamesAndTypes = new ArrayList<>();
        String[] entity1 = {"Id der Notation", Entity.TYPE_INTEGER};
        String[] entity2 = {"X Kooridnate der Notation", Entity.TYPE_INTEGER};
        String[] entity3 = {"Y Kooridnate der Notation", Entity.TYPE_INTEGER};
        String[] entity4 = {"Name der Notation", Entity.TYPE_STRING};
        String[] entity5 = {"Wert der Notation", Entity.TYPE_DOUBLE};

        this.addEntityNameAndType(entity1);
        this.addEntityNameAndType(entity2);
        this.addEntityNameAndType(entity3);
        this.addEntityNameAndType(entity4);
        this.addEntityNameAndType(entity5);
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
    public ArrayList<Point2D> getListOfPoints()
    {
        ArrayList<Point2D> listOfPoints = new ArrayList<>();
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
     */    public int getSelectedNotationId()
    {
        return selectedNotationId;
    }


    public int getEntityCount()
    {
        return this.listOfEntityNamesAndTypes.size();
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
     * @author  marxmanEUW
     * @changes
     *      2018-03-07 (marxmanEUW)  created
     * @brief   Returns EntityNameAndTypeList of the PdfObject.
     */
    public ArrayList<String[]> getListOfEntityNamesAndTypes()
    {
        return listOfEntityNamesAndTypes;
    }


    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-09 (marxmanEUW) created
     * @brief
     * @todo testing
     */
    public ObservableList<Entity> getSelectedNotationAsObservableList()
    {
        ObservableList<Entity> list;

        Notation selectedNotation = this.getSelectedNotation();

        if(selectedNotation == null)
        {
            list = null;
        }
        else
        {
            list = FXCollections.observableArrayList(selectedNotation.getListOfEntities());
        }

        return list;
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
    public void addNotation(Notation newNotation)
    {
        this.listOfNotations.put(newNotation.getId(), newNotation);
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
    public int getIdForNextNotation()
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

    /*
     * @author  marxmanEUW
     * @changes
     *      2018-03-07 (yxyxD)  marxmanEUW
     * @brief   Adds an EntityNameAndType Object to the PdfObject.
     */
    private void addEntityNameAndType(String[] entity)
    {
        this.listOfEntityNamesAndTypes.add(entity);
    }
}
