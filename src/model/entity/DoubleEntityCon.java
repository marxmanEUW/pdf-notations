package model.entity;

public class DoubleEntityCon implements EntityConInterface {

    private String valueName;
    private Class valueClass;
    private Double value;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public DoubleEntityCon(String valueName)
    {
        this.valueName = valueName;
        this.valueClass = Double.class;
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    @Override
    public void setValue(Object value)
    {
        this.value = Double.valueOf(String.valueOf(value));
    }


    public void setValue(Double value)
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
    public Double getValue()
    {
        return this.value;
    }
}
