package mac_reserve.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_reserve.model.Facility;
import mac_reserve.model.User;
import mac_reserve.util.SQLConnection;

public class UserDAO
{
    
    private static SQLConnection DBMgr = SQLConnection.getInstance();
    
    
    private static ArrayList<User> getUserListFromQuery(String queryString)
    {
        ArrayList<User> userListInDB = new ArrayList<User>();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet userList = stmt.executeQuery(queryString);
            while (userList.next())
            {
                User user = new User();
                user.setUsername(userList.getString("username"));
                user.setId(userList.getString("id"));
                user.setFirstname(userList.getString("firstname"));
                user.setLastname(userList.getString("lastname"));
                user.setPassword(userList.getString("password"));
                user.setRole(userList.getString("role"));
                user.setAddress(userList.getString("address"));
                user.setCity(userList.getString("city"));
                user.setState(userList.getString("state"));
                user.setZip(userList.getString("zip"));
                user.setPhone(userList.getString("phone"));
                user.setEmail(userList.getString("email"));
                
                userListInDB.add(user);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error in UserDAO\n" + e.getMessage());
        }
        
        return userListInDB;
    }
    
    public static ArrayList<User> listUserWithUsername(String us)
    {
        return getUserListFromQuery(String.format("SELECT * FROM users WHERE username='%s'", us));
    }
    
    public static ArrayList<User> listUsersWithRole(String rs)
    {
        return getUserListFromQuery(String.format("SELECT * FROM users WHERE role='%s' ORDER BY username", rs));
    }
    
    public static ArrayList<User> listUsers()
    {
        return getUserListFromQuery("SELECT * FROM users ORDER BY username");
    }
    
    public static void updateUser(User u)
    {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            stmt.executeUpdate(String.format(
                    "UPDATE users " +
                            "SET "
                            + "id='%s',"
                            + "firstname='%s',"
                            + "lastname='%s',"
                            + "password='%s',"
                            + "role='%s',"
                            + "address='%s',"
                            + "city='%s',"
                            + "state='%s',"
                            + "zip='%s',"
                            + "phone='%s',"
                            + "email='%s' "
                            + "WHERE username='%s'",
                    u.getId(),
                    u.getFirstname(),
                    u.getLastname(),
                    u.getPassword(),
                    u.getRole(),
                    u.getAddress(),
                    u.getCity(),
                    u.getState(),
                    u.getZip(),
                    u.getPhone(),
                    u.getEmail(),
                    u.getUsername()));
            
            conn.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Error in UserDAO updating user\n" + e.getMessage());
        }
    }
}
