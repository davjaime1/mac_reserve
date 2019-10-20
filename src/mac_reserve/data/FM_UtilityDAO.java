package mac_reserve.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import mac_reserve.model.State;
import mac_reserve.model.UserModel;
import mac_reserve.util.SQLConnection;

import java.sql.Date;

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
		return ReturnMatchingUsers("SELECT * FROM users where username LIKE '%"+ username +"' AND role ='"+ role +"'");
	}
}
