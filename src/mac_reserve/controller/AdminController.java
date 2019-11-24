package mac_reserve.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_reserve.data.FM_UtilityDAO;
import mac_reserve.data.RoleDAO;
import mac_reserve.data.UserModelDAO;
import mac_reserve.data.AdminDAO;
import mac_reserve.model.Role;
import mac_reserve.model.State;
import mac_reserve.model.UserErrorMsgs;
import mac_reserve.model.UserModel;
import mac_reserve.model.User;


/**
 * Servlet implementation class userController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    private void userParam(HttpServletRequest request, UserModel user)
    {
        user.setUser(request.getParameter("idusername"), request.getParameter("idutaID"), request.getParameter("idfirstname"), request.getParameter("idlastname"), request.getParameter("idpassword"), request.getParameter("idrole"), request.getParameter("idaddress"), request.getParameter("idstate"), request.getParameter("idcity"), request.getParameter("idzip"), request.getParameter("idphone"), request.getParameter("idemail"), request.getParameter("noshow"), request.getParameter("violations"), request.getParameter("status"));
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action"), url ="";
        session.removeAttribute("errorMsgs");
        
        if (action.equalsIgnoreCase("viewSearchForUser"))
        {
        	ArrayList<Role> roleInDB = new ArrayList<Role>();
            roleInDB = RoleDAO.listRoles();
            session.setAttribute("ROLE", roleInDB);
            
        	url = "/AdminSearchForUser.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("viewSpecificUser"))
        {
        	String username = request.getParameter("username");
        	String role = request.getParameter("role");
        	
        	ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserModel user = new UserModel();
            user.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail(), fetch_profile.get(0).getNoshow(), fetch_profile.get(0).getViolations(), fetch_profile.get(0).getStatus());
            
            session.setAttribute("USERS", user);
            if(role.equals("U"))
            {
            	url = "/AdminViewUser.jsp";
            }
            else
            {
            	url = "/AdminViewOthers.jsp";
            }
            getServletContext().getRequestDispatcher(url).forward(request, response);
        	
        }
        else // redirect all other gets to post
            doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        // doGet(request, response);
        
        String action = request.getParameter("action"), url = "";
        HttpSession session = request.getSession();
        
        // int selectedCompanyIndex;
        session.removeAttribute("errorMsgs");
        
        if (action.equalsIgnoreCase("viewProfile"))
        {
            String username = (String) session.getAttribute("username");
            
            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserModel currentUser = new UserModel();
            currentUser.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail(), fetch_profile.get(0).getNoshow(), fetch_profile.get(0).getViolations(), fetch_profile.get(0).getStatus());
            
            session.setAttribute("USERS", currentUser);
            url = "/AdminViewProfile.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("viewUpdateProfile"))
        {
        	String username = (String) session.getAttribute("username");
            
            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            ArrayList<State> stateInDB = new ArrayList<State>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserModel currentUser = new UserModel();
            currentUser.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail(), fetch_profile.get(0).getNoshow(), fetch_profile.get(0).getViolations(), fetch_profile.get(0).getStatus());
            
            stateInDB = FM_UtilityDAO.listStates();
            session.setAttribute("STATE", stateInDB);
            
            session.setAttribute("USERS", currentUser);
            url = "/AdminUpdateProfile.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("updateProfile"))
        {
        	//To DO: Add the Make the changes in DB
        	UserModel user = new UserModel();
            UserErrorMsgs CerrorMsgs = new UserErrorMsgs();
            userParam(request, user);
            user.validateUser(action, CerrorMsgs);
            session.setAttribute("USERS", user);
            
            session.setAttribute("USERS", user);
            if (!CerrorMsgs.getErrorMsg().equals(""))
            {
                // if error messages
                session.setAttribute("errorMsgs", CerrorMsgs);
                getServletContext().getRequestDispatcher("/AdminUpdateProfile.jsp").forward(request, response);
            }
            else
            {
                // if no error messages
                UserModelDAO.updateUser(user);
				session.setAttribute("USERS", user);
				
				//Takes you back to the view profile, to view the changes
	        	String username = (String) session.getAttribute("username");
	            
	            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
	            fetch_profile = UserModelDAO.returnProfile(username);
	            UserModel currentUser = new UserModel();
	            currentUser.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
	                    fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
	                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail(), fetch_profile.get(0).getNoshow(), fetch_profile.get(0).getViolations(), fetch_profile.get(0).getStatus());
	            
	            session.setAttribute("USERS", currentUser);
	            url = "/AdminViewProfile.jsp";
	            getServletContext().getRequestDispatcher(url).forward(request, response);
            }	
        }
        else if(action.equalsIgnoreCase("searchForUser"))
        {
        	String username = (String) session.getAttribute("username");
        	String searchUsername = request.getParameter("idusername");
        	String searchRole = request.getParameter("idrole");
        	
        	//Need to search query based on the username and role
        	ArrayList<UserModel> results = new ArrayList<UserModel>();
        	results = FM_UtilityDAO.searchUsers(searchUsername, username, searchRole);
        	session.setAttribute("USERS", results);
        	
        	url = "/AdminListUserResults.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("userStatus"))
        {
        	String username = request.getParameter("username");
        	String status = request.getParameter("status");
        	AdminDAO.UserStatus(username, status);
        	ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserModel user = new UserModel();
            user.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail(), fetch_profile.get(0).getNoshow(), fetch_profile.get(0).getViolations(), fetch_profile.get(0).getStatus());
            
            session.setAttribute("USERS", user);

            url = "/AdminViewUser.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("changeRole"))
        {
        	//Gotta get the roles list
        	ArrayList<Role> roleInDB = new ArrayList<Role>();
            roleInDB = RoleDAO.listRoles();
            session.setAttribute("ROLE", roleInDB);
        	url = "/AdminChangeRole.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("updateRole"))
        {
        	String role = request.getParameter("idrole");
        	String username = request.getParameter("idusername");
        	//Need to update the user's role now
        	AdminDAO.updateRole(username, role);
        	//Then redirect to homepage
        	ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserModel user = new UserModel();
            user.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail(), fetch_profile.get(0).getNoshow(), fetch_profile.get(0).getViolations(), fetch_profile.get(0).getStatus());
            
            session.setAttribute("USERS", user);
            if(role.equals("U"))
            {
            	url = "/AdminViewUser.jsp";
            }
            else
            {
            	url = "/AdminViewOthers.jsp";
            }
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }
}