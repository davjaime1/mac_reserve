package mac_reserve.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_reserve.model.Facility;
import mac_reserve.model.User;
import mac_reserve.util.SQLConnection;

public class AdminDAO
{
    
    private static SQLConnection DBMgr = SQLConnection.getInstance();
    
    
    public static void UserStatus(String username, String status)
	{
		String change = "";
		if(status.equals("Unrevoked"))
		{
			change = "Revoked";
		}
		else
		{
			change = "Unrevoked";
		}
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		String queryString = "UPDATE `users` SET status = '" +change+"' WHERE username = '" + username +"'";
		try {
            stmt = conn.createStatement();
            stmt.executeUpdate(queryString);
            conn.commit();
		} catch (SQLException e) {System.out.println("Whoops");}
	}
    
    public static void updateRole(String username, String role)
    {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		String queryString = "UPDATE `users` SET role = '" +role+"' WHERE username = '" + username +"'";
		try {
            stmt = conn.createStatement();
            stmt.executeUpdate(queryString);
            conn.commit();
		} catch (SQLException e) {System.out.println("Whoops");}
    }
}
