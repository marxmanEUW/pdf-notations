package model.entity;

public class EntityCon {

    private String valueName;
    private Object value;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public EntityCon(String valueName)
    {
        this.valueName = valueName;
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    public void setValue(Object value)
    {
        this.value = value;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public String getValueName()
    {
        return this.valueName;
    }


    public Object getValue()
    {
        return this.value;
    }
}
