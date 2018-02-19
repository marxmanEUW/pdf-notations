package main;

import model.entity.*;

import java.util.ArrayList;

public class TestLauncher {

    public static void main(String[] args)
    {
        ArrayList<EntityCon> testList = new ArrayList<>();

        StringEntityCon e1 = new StringEntityCon("Name der Notation");

        testList.add(e1);

        testList.get(0).setValue(1);

        System.out.println(testList.get(0).getValue());
        System.out.println(testList.get(0).getValue().getClass());
        System.out.println(testList.get(0).getValueName());
    }
}
