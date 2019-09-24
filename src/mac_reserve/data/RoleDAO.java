package mac_reserve.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_reserve.model.Role;
import mac_reserve.util.SQLConnection;

public class RoleDAO
{
    private static SQLConnection DBMgr = SQLConnection.getInstance();
    
    
    private static ArrayList<Role> getMatchingRoleList(String query)
    {
        ArrayList<Role> roleListInDB = new ArrayList<Role>();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet roleSet = stmt.executeQuery(query);
            while (roleSet.next())
            {
                Role role = new Role();
                role.setId(roleSet.getString("id"));
                role.setName(roleSet.getString("name"));
                
                roleListInDB.add(role);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error in RoleDAO\n" + e.getMessage());
        }
        
        return roleListInDB;
    }
    
    
    public static ArrayList<Role> listRoleWithId(String id)
    {
        return getMatchingRoleList(String.format(
                "SELECT * from roles WHERE id='%s'", id));
    }
    
    public static ArrayList<Role> listRoles()
    {
        return getMatchingRoleList("SELECT * FROM roles ORDER BY id");
    }
}
