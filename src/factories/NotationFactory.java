package factories;

import model.*;

import java.util.ArrayList;

public abstract class NotationFactory {

    public static Notation getEmptyNotation(ArrayList<String[]> listOfEntityNamesAndTypes)
    {
        ArrayList<Entity> listOfEntities = new ArrayList<>();

        for (String[] entityNameAndType : listOfEntityNamesAndTypes)
        {
            switch (entityNameAndType[1])
            {
                case Entity.TYPE_STRING:
                    Entity newStringEntity = new Entity(entityNameAndType[0], entityNameAndType[1]);
                    listOfEntities.add(newStringEntity);
                    break;
                case Entity.TYPE_INTEGER:
                    Entity newIntegerEntity = new Entity(entityNameAndType[0], entityNameAndType[1]);
                    listOfEntities.add(newIntegerEntity);
                    break;
                case Entity.TYPE_DOUBLE:
                    Entity newDoubleEntity = new Entity(entityNameAndType[0], entityNameAndType[1]);
                    listOfEntities.add(newDoubleEntity);
                    break;
            }
        }

        Notation emptyNotation = new Notation(listOfEntities);
        return emptyNotation;
    }
}
