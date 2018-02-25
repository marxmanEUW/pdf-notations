package main;


import model.Entity;

import java.util.ArrayList;

public class TestLauncher {

    public static void main(String[] args)
    {

        ArrayList<Entity> testList = new ArrayList<>();

        Entity e1 = new Entity("Name der Notation", Entity.TYPE_DOUBLE);

        testList.add(e1);

        testList.get(0).setValue(2);

        System.out.println(testList.get(0).getValue());
        System.out.println(testList.get(0).getValue().getClass());
        System.out.println(testList.get(0).getValueName());

    }
}
