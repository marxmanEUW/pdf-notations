package model;

public class Entity {

    public static final String TYPE_STRING = "String";
    public static final String TYPE_INTEGER = "Integer";
    public static final String TYPE_DOUBLE = "Double";

    private String valueName;
    private String valueType;
    private String value;

    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public Entity(String valueName, String valueType)
    {
        this.valueName = valueName;
        this.valueType = valueType;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public String getValue()
    {
        return this.value;
    }

    public String getValueName()
    {
        return valueName;
    }

    public String getValueType()
    {
        return valueType;
    }

    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    public void setValue(String value)
    {
        this.value = value;
    }
}
