package mac_reserve.model;

import java.io.Serializable;

public class User implements Serializable
{
    private static final long serialVersionUID = 3191499073057932666L;
    
    private String username;
    private String id;
    private String firstname;
    private String lastname;
    private String password;
    private String role;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public void setFirstname(String s)
    {
        firstname = s;
    }
    
    public String getFirstname()
    {
        return firstname;
    }
    
    public void setLastname(String s)
    {
        lastname = s;
    }
    
    public String getLastname()
    {
        return lastname;
    }
    
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setRole(String s)
    {
        role = s;
    }
    
    public String getRole()
    {
        return role;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
