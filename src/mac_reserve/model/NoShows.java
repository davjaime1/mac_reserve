package mac_reserve.model;

import java.io.Serializable;

public class NoShows implements Serializable
{
    private static final long serialVersionUID = -5533857792763363793L;
    private String username;
    private String name;
    private String from;
    private String to;
    private String date;
    private String description;

   
    public String getUserame()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getFrom()
    {
        return from;
    }
    
    public void setFrom(String from)
    {
        this.from = from;
    }
    
    public String getTo()
    {
        return to;
    }
    
    public void setTo(String to)
    {
        this.to = to;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public String getDescription()
    {
    	return description;
    }
    
    public void setDescription(String desc)
    {
    	description = desc;
    }
}
