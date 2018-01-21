package model;


import java.awt.Point;
import java.util.ArrayList;

/*
 * @todo !obsolete Klasse
 */
public class ProjectCon {

    // @todo private String pdfFilePath
    private String name;
    private ArrayList<NotationCon> listOfNotationCons;


    /// Getter

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

    /// Constructor

    public ProjectCon()
    {
        this.listOfNotationCons = new ArrayList<>();
    }


    /// public methods

    public void addNotation()
    {

    }

    public void addNotationAtXY(int x, int y)
    {
        NotationCon newNotationCon = new NotationCon(1,"Punkt", x, y);
        this.listOfNotationCons.add(newNotationCon);
    }
}
