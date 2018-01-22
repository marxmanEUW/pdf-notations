package model;


import view.MainFrame;

import java.awt.Point;
import java.util.ArrayList;

/*
 * @todo !obsolete Klasse
 */
public class ProjectCon {

    // @todo private String pdfFilePath
    private String name;
    private ArrayList<NotationCon> listOfNotationCons;
    private int selectedNotationIndex;


    /*
     * #########################################################################
     * #                    Konstruktor                                        #
     * #########################################################################
     */

    public ProjectCon()
    {
        this.listOfNotationCons = new ArrayList<>();
        this.selectedNotationIndex = -1;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */

    public ArrayList<Point> getListOfPoints()
    {
        ArrayList<Point> listOfPoints = new ArrayList<>();
        for (NotationCon notationCon : this.listOfNotationCons)
        {
            listOfPoints.add(new Point(notationCon.getX(), notationCon.getY()));
        }
        return listOfPoints;
    }

    public ArrayList<NotationCon> getListOfNotationCons() {
        return this.listOfNotationCons;
    }

    public int getListOfNotationConsSize(){
        return this.listOfNotationCons.size();
    }

    public NotationCon getSelectedNotation() {
        return this.listOfNotationCons.get(selectedNotationIndex);
    }

    public int getSelectedNotationIndex() {
        return selectedNotationIndex;
    }

    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */

    public void setSelectedNotationIndex(int selectedNotationIndex) {
        this.selectedNotationIndex = selectedNotationIndex;
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
        NotationCon newNotationCon = new NotationCon(1,"Punkt", x, y);
        this.listOfNotationCons.add(newNotationCon);

        /*
         * @todo marxmanEUW
         */
        //this.mainFrame.updateNotationList();
    }

    /*
     * @todo marxmanEUW
     */
    public void updateNotationEntityTable()
    {
        //this.mainFrame.updateNotationEntityTable();
    }
}
