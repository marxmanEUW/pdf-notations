package model;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Project {

    // @todo private String pdfFilePath
    private String name;
    private ArrayList<Notation> listOfNotations;


    /// Getter

    public ArrayList<Point> getListOfPoints()
    {
        ArrayList<Point> listOfPoints = new ArrayList<>();
        for (Notation notation : listOfNotations)
        {
            listOfPoints.add(new Point(notation.getX(), notation.getY()));
        }
        return listOfPoints;
    }


    /// Constructor

    public Project()
    {
        this.listOfNotations = new ArrayList<>();
    }


    /// public methods

    public void addNotation(int x, int y)
    {
        Notation newNotation = new Notation(1,"Punkt", x, y);
        this.listOfNotations.add(newNotation);
    }
}
