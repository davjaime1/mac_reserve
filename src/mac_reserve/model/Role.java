package mac_reserve.model;

import java.io.Serializable;

public class Role implements Serializable
{
    private static final long serialVersionUID = 3191499073057932666L;
    private String id;
    private String name;
    
    public void setId(String s)
    {
        id = s;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setName(String s)
    {
        name = s;
    }
    
    public String getName()
    {
        return name;
    }
}
