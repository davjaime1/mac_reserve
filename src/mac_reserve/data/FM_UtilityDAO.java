package mac_reserve.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import mac_reserve.model.Facility;
import mac_reserve.model.State;
import mac_reserve.model.UserModel;
import mac_reserve.util.SQLConnection;

public class FM_UtilityDAO {

	public static Date mysqlDate(String dateString) {
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

			Date date = new Date(System.currentTimeMillis());
			try {
				java.util.Date utiDate = format.parse(dateString);
				date = new java.sql.Date(utiDate.getTime());
				//System.out.println(date);  
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return date;		
	}

	
	public static ArrayList<State>  listStates()  {  
		return ReturnMatchingStates(" SELECT * from states ORDER BY id");
	}


	private static ArrayList<State> ReturnMatchingStates(String queryString) {
		// TODO Auto-generated method stub
		ArrayList<State> urgencyListInDB = new ArrayList<State>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet urgencyList = stmt.executeQuery(queryString);
			while ( urgencyList.next()) {
				State urgency = new State(); 
				urgency.setId( urgencyList.getString("id"));
				urgency.setName( urgencyList.getString("name"));

				urgencyListInDB.add(urgency);	
			}
		} catch (SQLException e) {}
		return urgencyListInDB;
	}
	
	private static ArrayList<UserModel> ReturnMatchingUsers(String queryString) {
		ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
			
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		
		try {
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(queryString);
			while (resultSet.next()) {
				UserModel res=new UserModel();
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
	
	public static ArrayList<UserModel> searchUsers(String username, String role)
	{
		return ReturnMatchingUsers("SELECT * FROM users where username LIKE '%"+ username +"' AND role ='"+ role +"' ORDER BY username");
	}
	
	public static ArrayList<String> getTypes() {
		ArrayList<String> type = new ArrayList<String>();
			
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		String queryString = "SELECT id FROM facilitytypes";
		try {
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(queryString);
			while (resultSet.next()) {
				type.add(resultSet.getString("id"));		
			}
		} catch (SQLException e) {}
		
		return type;
	}
	
	public static ArrayList<Facility> getFacilities(String type) {
		ArrayList<Facility> list = new ArrayList<Facility>();
			
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		String queryString = "SELECT * FROM facilities WHERE facilitytype=\""+type+"\"";
		try {
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(queryString);
			while (resultSet.next()) {
				Facility res=new Facility();
				res.setName(resultSet.getString("name"));
				res.setType(resultSet.getString("facilitytype"));
				res.setInterval(resultSet.getString("interval"));
				res.setDuration(resultSet.getString("duration"));
				res.setVenue(resultSet.getString("venue"));
				res.setDeposit(resultSet.getString("deposit"));
				res.setAvaliability(resultSet.getString("availiability"));
				list.add(res);		
			}
		} catch (SQLException e) {System.out.println("Whoops");}
		
		return list;
	}
	
	public static void setAvaliability(String name, String ava)
	{
		String change = "";
		if(ava.equals("Available"))
		{
			change = "Unavailable";
		}
		else
		{
			change = "Available";
		}
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		String queryString = "UPDATE `facilities` SET availiability = '" +change+"' WHERE name = '" + name +"'";
		try {
            stmt = conn.createStatement();
            stmt.executeUpdate(queryString);
            conn.commit();
		} catch (SQLException e) {System.out.println("Whoops");}
	}
}
