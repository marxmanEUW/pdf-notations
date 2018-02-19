package model.entity;

public class StringEntityCon extends EntityCon {

    private String stringValue;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public StringEntityCon(String valueName)
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
        this.stringValue = String.valueOf(value);
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public String getValue()
    {
        return this.stringValue;
    }
}
