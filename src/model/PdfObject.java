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
        //this.jsonAbsolutePath = PdfObjectFactory.getAbsolutePathToJsonFile(pdfAbsolutePath);

        this.listOfNotations = new HashMap<>();
        this.selectedNotationIndex = PdfObject.SELECTED_NOTATION_NULL_VALUE;

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
     */
    public HashMap<Integer, Notation> getListOfNotations()
    {
        return this.listOfNotations;
    }


    public int getListOfNotationsSize()
    {
        return this.listOfNotations.size();
    }

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


    public int getSelectedNotationIndex()
    {
        return this.selectedNotationIndex;
    }


    public int getEntityCount()
    {
        return this.listOfEntityNamesAndTypes.size();
    }

    public ArrayList<Notation> getListOfNotationsAsList()
    {
        ArrayList<Notation> listOfNotationsAsList = new ArrayList<>();
        listOfNotationsAsList.addAll(this.listOfNotations.values());
        return listOfNotationsAsList;
    }

    public ArrayList<String[]> getListOfEntityNamesAndTypes()
    {
        return listOfEntityNamesAndTypes;
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
    public void addNotation(Notation notation, Point coordinates)
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


    private void addEntityNameAndType(String[] entity)
    {
        this.listOfEntityNamesAndTypes.add(entity);
    }
}
