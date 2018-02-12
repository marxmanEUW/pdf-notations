package model.entity;

public class StringEntityCon implements EntityConInterface {

    private String valueName;
    private Class valueClass;
    private String value;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public StringEntityCon(String valueName)
    {
        this.valueName = valueName;
        this.valueClass = String.class;
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    @Override
    public void setValue(Object value)
    {
        this.value = String.valueOf(value);
    }


    public void setValue(String value)
    {
        this.value = value;
    }

    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    @Override
    public String getValueName()
    {
        return this.valueName;
    }


    @Override
    public Class getValueClass()
    {
        return this.valueClass;
    }


    @Override
    public String getValue()
    {
        return this.value;
    }
}
