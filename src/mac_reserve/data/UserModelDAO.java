package mac_reserve.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_reserve.model.Facility;
import mac_reserve.model.User;
import mac_reserve.model.UserModel;
import mac_reserve.util.SQLConnection;

public class UserModelDAO {
	private static SQLConnection DBMgr = SQLConnection.getInstance();
	private static void StoreListinDB (UserModel user,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = queryString + " VALUES ('"  
					+ user.getUsername()  + "','"	
					+ user.getId()  + "','"	
					+ user.getFirstName() + "','"
					+ user.getLastName() + "','"
					+ user.getPassword() + "','"
					+ user.getRole() + "','"
					+ user.getAddress() + "','"
					+ user.getCity() + "','"
					+ user.getState() + "','"
					+ user.getZip() + "','"
					+ user.getPhone() + "','"
					+ user.getEmail() + "')";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}
	
	public static ArrayList<UserModel> returnProfile (String username) 
	{
	 ArrayList<UserModel> fetch_profile= new ArrayList<UserModel>();
	 	
	 UserModel res=new UserModel();	
     Statement stmt = null;
     Connection conn = SQLConnection.getDBConnection();

     String queryString = "SELECT * from users where username = '"+username +"'";
	 
		try {
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(queryString);

			while (resultSet.next()) {
				
		
				
				res.setUsername(resultSet.getString("username"));
				res.setId(resultSet.getString("id"));
				res.setFirstName(resultSet.getString("firstname"));
				res.setLastName(resultSet.getString("lastname"));
				res.setPassword(resultSet.getString("password"));
				res.setRole(resultSet.getString("role"));
				res.setAddress(resultSet.getString("address"));
				res.setState(resultSet.getString("state"));
				res.setCity(resultSet.getString("city"));
				res.setZip(resultSet.getString("zip"));
				res.setPhone(resultSet.getString("phone"));
				res.setEmail(resultSet.getString("email"));
				fetch_profile.add(res);		
				
				
			}
		} catch (SQLException e) {}
		return fetch_profile;
	}
	
	
	public static void insertUser(UserModel user) {  
		StoreListinDB(user,"INSERT INTO users (username,id,firstname,lastname,password,role,address,city,state,zip,phone,email) ");
	} 
    
	public static Boolean userNameunique(String name)  {  
		return (returnProfile(name).isEmpty());
	}
	
    public static void updateUser(UserModel user)
    {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = "UPDATE users SET firstname = '"+ user.getFirstName()
					+ "',"+ "lastname = '"+ user.getLastName() 
					+ "',"+ "password = '"+ user.getPassword() 
					+ "',"+ "address = '"+ user.getAddress()
					+ "',"+ "city = '"+ user.getCity()
					+ "',"+ "state = '"+ user.getState() 
					+ "', " + "zip = '"+ user.getZip() 
					+ "', " + "phone = '"+ user.getPhone() 
					+ "', " + "role = '"+ user.getRole()
					+ "', " +" email = '"+ user.getEmail()  + "' WHERE username = '" + user.getUsername()+ "'";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
    }
    
    public static ArrayList<Facility> listFacilityTypes()
    {
    	ArrayList<Facility> facilities = new ArrayList<Facility>();
        
    	String queryString = "SELECT * FROM facilitytypes"; 
    	
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet list = stmt.executeQuery(queryString);
            while (list.next())
            {
                Facility user = new Facility();
                user.setType(list.getString("id"));
                user.setName(list.getString("name"));
                facilities.add(user);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error in UserDAO\n" + e.getMessage());
        }
        
        return facilities;
    }
    
    public static ArrayList<String> listTimes()
    {
    	ArrayList<String> time = new ArrayList<String>();
        
    	String queryString = "SELECT f.from FROM facilitiesoptions f WHERE facilityname = 'BMC1' AND day ='D'"; 
    	
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet list = stmt.executeQuery(queryString);
            while (list.next())
            {
                
                time.add(list.getString("from"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error in UserDAO\n" + e.getMessage());
        }
        time.add(0, "All Times");
        return time;
    }
    
    public static ArrayList<Facility> listAvailableReservations(String type, String date, String time)
    {
    	ArrayList<Facility> facilities = new ArrayList<Facility>();
    	if(time.equals("All Times"))
    		time = "";
        
    	String queryString = "SELECT * FROM facilitiesoptions f WHERE f.facilitytype=\"" + type + "\" AND f.from LIKE '%" + time + "'"; 
    	
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet list = stmt.executeQuery(queryString);
            while (list.next())
            {
                Facility user = new Facility();
                user.setType(list.getString("facilitytype"));
                user.setName(list.getString("facilityname"));
                user.setVenue(list.getString("venue"));
                if(list.getString("day").equals("D"))
                {
                	user.setDay("Weekday Hours");
                }
                else
                {
                	user.setDay("Weekend Hours");
                }
                user.setDate(date);
                user.setFrom(list.getString("from"));
                user.setTo(list.getString("to"));
                facilities.add(user);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error in UserDAO\n" + e.getMessage());
        }
        
        return facilities;
    }
    
    public static ArrayList<Facility> listMyReservations(String username)
    {
    	ArrayList<Facility> facilities = new ArrayList<Facility>();
        
    	String queryString = "SELECT * FROM facilityreservation f WHERE f.reservedUser=\"" + username + "\""; 
    	
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet list = stmt.executeQuery(queryString);
            while (list.next())
            {
                Facility user = new Facility();
                user.setType(list.getString("facilitytype"));
                user.setName(list.getString("facilityname"));
                user.setVenue(list.getString("venue"));
                user.setDate(list.getString("date"));
                if(list.getString("day").equals("D"))
                {
                	user.setDay("Weekday Hours");
                }
                else
                {
                	user.setDay("Weekend Hours");
                }
                user.setFrom(list.getString("from"));
                user.setTo(list.getString("to"));
                facilities.add(user);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error in UserDAO\n" + e.getMessage());
        }
        
        return facilities;
    }
 
    public static ArrayList<Facility> listReservations()
    {
    	ArrayList<Facility> facilities = new ArrayList<Facility>();
        
    	String queryString = "SELECT * FROM facilityreservation"; 
    	
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet list = stmt.executeQuery(queryString);
            while (list.next())
            {
                Facility user = new Facility();
                user.setType(list.getString("facilitytype"));
                user.setName(list.getString("facilityname"));
                user.setVenue(list.getString("venue"));
                user.setDate(list.getString("date"));
                if(list.getString("day").equals("D"))
                {
                	user.setDay("Weekday Hours");
                }
                else
                {
                	user.setDay("Weekend Hours");
                }
                user.setFrom(list.getString("from"));
                user.setTo(list.getString("to"));
                facilities.add(user);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error in UserDAO\n" + e.getMessage());
        }
        
        return facilities;
    }
    
    public static void AvailableReservations(ArrayList<Facility> aFacilityList, ArrayList<Facility> ReservationList)
    {
		int possSize = aFacilityList.size();
		int inDBSize = ReservationList.size();
		for(int i = 0; i < possSize; i++)
		{
			for(int j = 0; j < inDBSize; j++)
			{
				if(aFacilityList.get(i).getName().equals(ReservationList.get(j).getName()) && aFacilityList.get(i).getDate().equals(ReservationList.get(j).getDate()) && aFacilityList.get(i).getFrom().equals(ReservationList.get(j).getFrom()))
				{
					aFacilityList.remove(i);
					i--;
					possSize--;
				}
			}
		}
    }
    
    public static void addReservation(Facility res, String user)
    {

    	String queryString = "INSERT INTO `facilityreservation` VALUES (\"" + res.getName() + "\",\"" + res.getType() +"\",\"" + res.getVenue() + "\",\"" + user + "\",\"" + res.getDate() + "\",\"" + res.getDay() + "\",\"" + res.getFrom() + "\",\"" + res.getTo() + "\");";
    	Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            
            stmt.executeUpdate(queryString);
            conn.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Could not insert Reservation into database\n" + e.getMessage());
        }
    }
}
