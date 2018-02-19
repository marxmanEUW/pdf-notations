package model.entity;

public class IntegerEntityCon extends EntityCon{

    private Integer integerValue;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public IntegerEntityCon(String valueName)
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
        this.integerValue = Integer.valueOf(String.valueOf(value));
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public Integer getValue()
    {
        return this.integerValue;
    }
}
