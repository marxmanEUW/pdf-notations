package model;

public class Entity {

    public static final String TYPE_STRING = "String";
    public static final String TYPE_INTEGER = "Integer";
    public static final String TYPE_DOUBLE = "Double";

    private String valueName;
    private String valueType;
    private String stringValue;
    private Integer intValue;
    private Double doubleValue;


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
    public Object getValue()
    {
        switch (this.valueType)
        {
            case TYPE_STRING:
                return this.stringValue;
            case TYPE_INTEGER:
                return this.intValue;
            case TYPE_DOUBLE:
                return this.doubleValue;
            default:
                return null;
        }
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
    public void setValue(Object value)
    {
        String tempStringValue = String.valueOf(value);

        switch (this.valueType)
        {
            case TYPE_STRING:
                this.stringValue = tempStringValue;
                break;
            case TYPE_INTEGER:
                this.intValue = Integer.parseInt(tempStringValue);
                break;
            case TYPE_DOUBLE:
                this.doubleValue = Double.parseDouble(tempStringValue);
                break;
        }
    }
}
