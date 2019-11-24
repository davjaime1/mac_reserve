package mac_reserve.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_reserve.model.Facility;
import mac_reserve.model.NoShows;
import mac_reserve.model.UserModel;
import mac_reserve.model.Violations;
import mac_reserve.util.SQLConnection;

public class UserModelDAO {
	private static SQLConnection DBMgr = SQLConnection.getInstance();
	private static void StoreListinDB (UserModel user,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertuser = queryString + " VALUES ('"  
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
					+ user.getEmail() + "','"
					+ user.getNoshow() + "','"
					+ user.getViolations() + "','"
					+ user.getStatus() + "')";
			stmt.executeUpdate(insertuser);	
			conn.commit(); 
		} catch (SQLException e) {};
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
				res.setNoshow(resultSet.getString("noshows"));
				res.setViolations(resultSet.getString("violations"));
				res.setStatus(resultSet.getString("status"));
				fetch_profile.add(res);		
				
				
			}
		} catch (SQLException e) {}
		return fetch_profile;
	}
	
	
	public static void insertUser(UserModel user) {  
		StoreListinDB(user,"INSERT INTO users (username,id,firstname,lastname,password,role,address,city,state,zip,phone,email,noshows,violations,status) ");
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
    
    public static ArrayList<Facility> listAvailableReservations(String type, String date, String time, String week)
    {
    	ArrayList<Facility> facilities = new ArrayList<Facility>();
    	if(time.equals("All Times"))
    		time = "";
    	String queryString="";
        if(week.equals("Saturday") || week.equals("Sunday"))
        {
        	queryString = "SELECT f.facilityname, f.facilitytype, f.venue, f.day, f.from, f.to FROM facilitiesoptions f LEFT JOIN facilities g ON g.name = f.facilityname WHERE f.facilitytype=\"" + type + "\" AND f.from LIKE '%" + time + "' AND day='E' AND g.availiability = 'Available'"; 

        }
        else
        {
        	queryString = "SELECT f.facilityname, f.facilitytype, f.venue, f.day, f.from, f.to FROM facilitiesoptions f LEFT JOIN facilities g ON g.name = f.facilityname WHERE f.facilitytype=\"" + type + "\" AND f.from LIKE '%" + time + "' AND day='D' AND g.availiability = 'Available'"; 

        }
    	
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet list = stmt.executeQuery(queryString);
            list.next();
            Facility users = new Facility();
            users.setType(list.getString("facilitytype"));
            users.setName(list.getString("facilityname"));
            users.setVenue(list.getString("venue"));
            if(list.getString("day").equals("D"))
            {
            	users.setDay("Weekday Hours");
            }
            else
            {
            	users.setDay("Weekend Hours");
            }
            users.setDate(date);
            users.setFrom(list.getString("from"));
            users.setTo(list.getString("to"));
            String dep = getDeposit(list.getString("facilitytype"));
            users.setDeposit(dep);
            facilities.add(users);
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
                user.setDeposit(dep);
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
        
    	String queryString = "SELECT * FROM facilityreservation f WHERE f.reservedUser=\"" + username + "\" ORDER BY f.date, f.from"; 
    	
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
                user.setStatus(list.getString("status"));
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
                user.setDeposit(list.getString("Deposit"));
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
            list.next();
            Facility user1 = new Facility();
            user1.setType(list.getString("facilitytype"));
            user1.setName(list.getString("facilityname"));
            user1.setVenue(list.getString("venue"));
            user1.setDate(list.getString("date"));
            user1.setStatus(list.getString("status"));
            if(list.getString("day").equals("D"))
            {
            	user1.setDay("Weekday Hours");
            }
            else
            {
            	user1.setDay("Weekend Hours");
            }
            user1.setFrom(list.getString("from"));
            user1.setTo(list.getString("to"));
            String dep = getDeposit(list.getString("facilitytype"));
            user1.setDeposit(dep);
            facilities.add(user1);
            while (list.next())
            {
                Facility user = new Facility();
                user.setType(list.getString("facilitytype"));
                user.setName(list.getString("facilityname"));
                user.setVenue(list.getString("venue"));
                user.setDate(list.getString("date"));
                user.setStatus(list.getString("status"));
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
                user.setDeposit(dep);
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
					if(i == 0)
					{
						aFacilityList.remove(i);
						possSize--;
					}
					else
					{
						aFacilityList.remove(i);
						i--;
						possSize--;
					}
				}
			}
		}
    }
    
    public static void addReservation(Facility res, String user)
    {

    	String queryString = "INSERT INTO `facilityreservation` VALUES (\"" + res.getName() + "\",\"" + res.getType() +"\",\"" + res.getVenue() + "\",\"" + user + "\",\"" + res.getDate() + "\",\"" + res.getDay() + "\",\"" + res.getFrom() + "\",\"" + res.getTo() + "\",\"" + res.getDeposit() + "\", \"" + res.getStatus() + "\");";
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
    
    public static String getDeposit(String type)
    {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        String queryString = "SELECT deposit FROM facilities WHERE facilitytype=\"" + type + "\"";
        String deposit="";
        try
        {
            stmt = conn.createStatement();
            ResultSet list = stmt.executeQuery(queryString);
            list.next();
            deposit = list.getString("deposit");
        }
        catch (SQLException e)
        {
            System.out.println("Error in UserDAO\n" + e.getMessage());
        }
        return deposit;
    }
    
    public static void cancelReservation(String date, String name, String from, String to)
    {
		Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM facilityreservation  WHERE facilityname = \"" + name + "\" AND date = \""+ date +"\" AND `from` = \"" + from + "\" AND `to` = \""+ to + "\"");
            conn.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Could remove reservation from database\n" + e.getMessage());
        }
    }
    
    public static ArrayList<NoShows> getNoShows(String username)
    {
    	ArrayList<NoShows> noshows = new ArrayList<NoShows>();
        
    	String queryString = "SELECT * FROM noshows order by date, noshows.from"; 
    	
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet list = stmt.executeQuery(queryString);
            while (list.next())
            {
                NoShows obj = new NoShows();
                obj.setUsername(list.getString("username"));
                obj.setName(list.getString("names"));
                obj.setDate(list.getString("date"));
                obj.setFrom(list.getString("from"));
                obj.setTo(list.getString("to"));
                obj.setDescription(list.getString("description"));
                noshows.add(obj);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Could not get no shows");
        }
        
        return noshows;
    }
    
    public static ArrayList<Violations> getViolations(String username)
    {
    	ArrayList<Violations> noshows = new ArrayList<Violations>();
        
    	String queryString = "SELECT * FROM violations ORDER BY date, violations.from"; 
    	
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet list = stmt.executeQuery(queryString);
            while (list.next())
            {
                Violations obj = new Violations();
                obj.setUsername(list.getString("username"));
                obj.setName(list.getString("name"));
                obj.setDate(list.getString("date"));
                obj.setFrom(list.getString("from"));
                obj.setTo(list.getString("to"));
                obj.setDescription(list.getString("description"));
                noshows.add(obj);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Could not get violations");
        }
        
        return noshows;
    }
}
