package model;

import model.entity.Entity;

import java.util.ArrayList;

public class PdfObject {

    public static final int SELECTED_NOTATION_NULL_VALUE = -1;

    private String pdfAbsolutePath;
    private String jsonAbsolutePath;

    private ArrayList<Notation> listOfNotations;
    private int selectedNotationIndex;
    private ArrayList<String[]> listOfEntityNamesAndTypes;

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

        this.listOfEntityNamesAndTypes = new ArrayList<>();
        String[] entity1 = {Entity.TYPE_INTEGER,"Id der Notation"};
        String[] entity2 = {Entity.TYPE_STRING,"Name der Notation"};
        String[] entity3 = {Entity.TYPE_INTEGER,"X Kooridnate der Notation"};
        String[] entity4 = {Entity.TYPE_INTEGER,"Y Kooridnate der Notation"};
        String[] entity5 = {Entity.TYPE_DOUBLE,"Wert der Notation"};

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


    public Notation getSelectedNotation()
    {
        return this.listOfNotations.get(selectedNotationIndex);
    }


    public int getSelectedNotationIndex()
    {
        return this.selectedNotationIndex;
    }


    public int getEntityCount()
    {
        return this.listOfEntityNamesAndTypes.size();
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
     * @author  marxmanEUW
     */
    public void addNotation(Notation notation)
    {
        this.listOfNotations.add(notation);
    }


    /*
     * @author  marxmanEUW
     */
    public void deleteSelectedNotation()
    {
        this.listOfNotations.remove(this.selectedNotationIndex);
    }


    /*
     * @author  yxyxD
     */
    public int getIdForNextNotation()
    {
        int nextId = 0;
        for (Notation notation : this.listOfNotations)
        {
            int notationID = (int) notation.getValue(0);
            if (notationID >= nextId)
            {
                nextId = notationID + 1;
            }
        }

        return nextId;
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    private void addEntityNameAndType(String[] entity)
    {
        this.listOfEntityNamesAndTypes.add(entity);
    }
}
