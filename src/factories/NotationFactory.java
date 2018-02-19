package factories;

import model.*;
import model.entity.*;

import java.util.ArrayList;

public abstract class NotationFactory {

    public static Notation getEmptyNotation(ArrayList<String[]> listOfEntityNamesAndTypes)
    {
        ArrayList<EntityCon> listOfEntities = new ArrayList<>();

        for (String[] entityNameAndType : listOfEntityNamesAndTypes)
        {
            switch (entityNameAndType[0])
            {
                case Entity.TYPE_STRING:
                    StringEntityCon newStringEntity = new StringEntityCon(entityNameAndType[1]);
                    //Entity<String> newStringEntity = new Entity<>(entityNameAndType[1]);
                    listOfEntities.add(newStringEntity);
                    break;
                case Entity.TYPE_INTEGER:
                    IntegerEntityCon newIntegerEntity = new IntegerEntityCon(entityNameAndType[1]);
                    //Entity<Integer> newIntegerEntity = new Entity<>(entityNameAndType[1]);
                    listOfEntities.add(newIntegerEntity);
                    break;
                case Entity.TYPE_DOUBLE:
                    DoubleEntityCon newDoubleEntity = new DoubleEntityCon(entityNameAndType[1]);
                    //Entity<Double> newDoubleEntity = new Entity<>(entityNameAndType[1]);
                    listOfEntities.add(newDoubleEntity);
                    break;
            }
        }

        Notation emptyNotation = new Notation(listOfEntities);
        return emptyNotation;
    }
}
