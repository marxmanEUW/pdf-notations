package main;

import model.PdfObject;
import model.entity.EntityConInterface;
import model.entity.StringEntityCon;

import java.util.ArrayList;

public class TestLauncher {

    public static void main(String[] args)
    {
        ArrayList<EntityConInterface> testList = new ArrayList<>();

        StringEntityCon e1 = new StringEntityCon("Name der Notation");

        testList.add(e1);

        testList.get(0).setValue(1);

        System.out.println(testList.get(0).getValue());
        System.out.println(testList.get(0).getValue().getClass());
    }
}
