package model.entity;

public class DoubleEntityCon extends EntityCon {

    private Double doubleValue;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public DoubleEntityCon(String valueName)
    {
        super(valueName);
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    public void setValue(Object value)
    {
        this.doubleValue = Double.valueOf(String.valueOf(value));
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public Double getValue()
    {
        return this.doubleValue;
    }
}
