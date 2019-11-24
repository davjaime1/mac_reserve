package mac_reserve.model;

import java.io.Serializable;

public class Facility implements Serializable
{
    private static final long serialVersionUID = -5533857792763363793L;
    private String name;
    private String type;
    private String interval;
    private String duration;
    private String venue;
    private String deposit;
    private String day;
    private String from;
    private String to;
    private String date;
    private String avaliability;
    private String status;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getInterval()
    {
        return interval;
    }
    
    public void setInterval(String interval)
    {
        this.interval = interval;
    }
    
    public String getDuration()
    {
        return duration;
    }
    
    public void setDuration(String duration)
    {
        this.duration = duration;
    }
    
    public String getVenue()
    {
        return venue;
    }
    
    public void setVenue(String venue)
    {
        this.venue = venue;
    }
    
    public String getDeposit()
    {
        return deposit;
    }
    
    public void setDeposit(String deposit)
    {
        this.deposit = deposit;
    }
    
    public String getDay()
    {
        return day;
    }
    
    public void setDay(String day)
    {
        this.day = day;
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
    
    public String getAvaliability()
    {
    	return avaliability;
    }
    
    public void setAvaliability(String ava)
    {
    	avaliability = ava;
    }
    
    public String getStatus()
    {
    	return status;
    }
    
    public void setStatus(String stat)
    {
    	status = stat;
    }
}
