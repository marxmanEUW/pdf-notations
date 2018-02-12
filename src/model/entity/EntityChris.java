package model.entity;

public class EntityChris {

    private String name;
    private String stringValue;
    private Integer intValue;
    private Double doubleValue;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public EntityChris(String name, String stringValue)
    {
        this.name = name;
        this.stringValue = stringValue;
    }


    public EntityChris(String name, Integer intValue)
    {
        this.name = name;
        this.intValue = intValue;
    }


    public EntityChris(String name, Double doubleValue)
    {
        this.name = name;
        this.doubleValue = doubleValue;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public Object getValue()
    {
        if (this.stringValue != null)
        {
            return this.stringValue;
        }
        else if (this.intValue != null)
        {
            return this.intValue;
        }
        else if (this.doubleValue != null)
        {
            return this.doubleValue;
        }
        else
        {
            return null;
        }
    }

    public String getName()
    {
        return name;
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    public void setValue(String stringValue)
    {
        if(this.stringValue != null)
        {
            this.stringValue = stringValue;
        }
    }


    public void setValue(Integer intValue)
    {
        if(this.intValue != null)
        {
            this.intValue = intValue;
        }
    }


    public void setValue(Double doubleValue)
    {
        if(this.doubleValue != null)
        {
            this.doubleValue = doubleValue;
        }
    }
}
