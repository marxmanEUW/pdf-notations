package model.entity;

public class IntegerEntityCon implements EntityConInterface{

    private String valueName;
    private Class valueClass;
    private Integer value;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public IntegerEntityCon(String valueName)
    {
        this.valueName = valueName;
        this.valueClass = Integer.class;
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    @Override
    public void setValue(Object value)
    {
        this.value = Integer.valueOf(String.valueOf(value));
    }


    public void setValue(Integer value)
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
    public Integer getValue()
    {
        return this.value;
    }
}
