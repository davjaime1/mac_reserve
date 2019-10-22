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
import mac_reserve.model.Facility;
import mac_reserve.model.Role;
import mac_reserve.model.State;
import mac_reserve.model.UserErrorMsgs;
import mac_reserve.model.UserModel;


/**
 * Servlet implementation class userController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    private void userParam(HttpServletRequest request, UserModel user)
    {
        user.setUser(request.getParameter("idusername"), request.getParameter("idutaID"), request.getParameter("idfirstname"), request.getParameter("idlastname"), request.getParameter("idpassword"), request.getParameter("idrole"), request.getParameter("idaddress"), request.getParameter("idstate"), request.getParameter("idcity"), request.getParameter("idzip"), request.getParameter("idphone"), request.getParameter("idemail"));
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        session.removeAttribute("errorMsgs");
        // List companies
        String url = "";
        // List companies
        if (action.equalsIgnoreCase("loginProfile"))
        {
            url = "/index.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if (action.equalsIgnoreCase("logOut"))
        {
            session.invalidate();
            url = "/index.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("viewMyReservations"))
        {
        	String username = (String) session.getAttribute("username");
        	ArrayList<Facility> ReservationList = new ArrayList<Facility>();
        	ReservationList = UserModelDAO.listMyReservations(username);
        	session.setAttribute("AVAILABLE", ReservationList);
        	url = "/UserViewMyReservations.jsp";
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
        
        if (action.equalsIgnoreCase("registerProfile"))
        {
            ArrayList<Role> roleInDB = new ArrayList<Role>();
            ArrayList<State> stateInDB = new ArrayList<State>();
            roleInDB = RoleDAO.listRoles();
            session.setAttribute("ROLE", roleInDB);
            stateInDB = FM_UtilityDAO.listStates();
            session.setAttribute("STATE", stateInDB);
            
            url = "/Register.jsp";
            getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
        }
        else if (action.equalsIgnoreCase("registerUser"))
        {
            UserModel user = new UserModel();
            UserErrorMsgs CerrorMsgs = new UserErrorMsgs();
            userParam(request, user);
            user.validateUser(action, CerrorMsgs);
            session.setAttribute("user", user);
            if (!CerrorMsgs.getErrorMsg().equals(""))
            {// if error messages
                session.setAttribute("errorMsgs", CerrorMsgs);
                url = "/Register.jsp";
                getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
            }
            else
            {// if no error messages
                UserModelDAO.insertUser(user);
                UserErrorMsgs facerrorMsgs = new UserErrorMsgs();
                facerrorMsgs.setErrorMsg("Facility Added SucessFully");
                
                url = "/index.jsp";
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
        else if (action.equalsIgnoreCase("viewProfile"))
        {
            String username = (String) session.getAttribute("username");
            //System.out.println(username);
            
            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserModel currentUser = new UserModel();
            currentUser.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail());
            
            session.setAttribute("USERS", currentUser);
            url = "/UserViewProfile.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("viewUpdateProfile"))
        {
        	String username = (String) session.getAttribute("username");
            //System.out.println(username);
            
            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            ArrayList<State> stateInDB = new ArrayList<State>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserModel currentUser = new UserModel();
            currentUser.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail());
            stateInDB = FM_UtilityDAO.listStates();
            session.setAttribute("STATE", stateInDB);
            
            session.setAttribute("USERS", currentUser);
            url = "/UserUpdateProfile.jsp";
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
                getServletContext().getRequestDispatcher("/UserUpdateProfile.jsp").forward(request, response);
            }
            else
            {
                // if no error messages
                UserModelDAO.updateUser(user);
				session.setAttribute("USERS", user);
				
				//Takes you back to the view profile, to view the changes
	        	String username = (String) session.getAttribute("username");
	            //System.out.println(username);
	            
	            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
	            fetch_profile = UserModelDAO.returnProfile(username);
	            UserModel currentUser = new UserModel();
	            currentUser.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
	                    fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
	                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail());
	            
	            session.setAttribute("USERS", currentUser);
	            url = "/UserViewProfile.jsp";
	            getServletContext().getRequestDispatcher(url).forward(request, response);
            }	
        }
        else if(action.equalsIgnoreCase("viewSearchAvailableFacilities"))
        {
        	//Get Possible Facilities list
        	ArrayList<Facility> facilityList = new ArrayList<Facility>();	
			facilityList = UserModelDAO.listFacilityTypes();
			session.setAttribute("FACILITY", facilityList);
			ArrayList<String> timeList = new ArrayList<String>();
			timeList = UserModelDAO.listTimes();        	
			session.setAttribute("TIMES", timeList);
        	url = "/UserSearchAvailableFacilities.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("listAvailableReservations"))
        {
        	//System.out.println(request.getParameter("idfacilitytype"));
        	//System.out.println(request.getParameter("iddate"));
        	//System.out.println(request.getParameter("idtimes"));
        	//Now we need to query based on these fields
        	ArrayList<Facility> aFacilityList = new ArrayList<Facility>();
        	aFacilityList = UserModelDAO.listAvailableReservations(request.getParameter("idfacilitytype"), request.getParameter("iddate"), request.getParameter("idtimes"));
        	session.setAttribute("AVAILABLE", aFacilityList);
        	
			//Get All Reserved Facilities List
			String username = (String) session.getAttribute("username");
        	ArrayList<Facility> ReservationList = new ArrayList<Facility>();
        	ReservationList = UserModelDAO.listReservations();
        	
        	//Now we need to remove the current reservations from the possible reservations
        	//aFacilityList will be the list with the remaining possible reservations
        	UserModelDAO.AvailableReservations(aFacilityList, ReservationList);
        	
        	session.setAttribute("FACILITYs", aFacilityList);
        	url = "/UserListAvailableReservations.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else
        {
            
            String username = request.getParameter("idusername");
            String password = request.getParameter("idpassword");
            
            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserErrorMsgs CerrorMsgs = new UserErrorMsgs();
            UserModel currentUser = new UserModel();
            if (fetch_profile.size() != 0)
            {
                currentUser.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
                        fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
                        fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail());
                currentUser.validateLogin(action, password, CerrorMsgs);
            }
            else
            {
                CerrorMsgs.setUserNameError("No user found");
                CerrorMsgs.setErrorMsg(action);
            }
            
            session.setAttribute("errorMsgs", CerrorMsgs);
            if (!CerrorMsgs.getErrorMsg().equals(""))
            {// if error messages
                currentUser.setUsername(username);
                currentUser.setPassword(password);
                session.setAttribute("USERS", currentUser);
                url = "/index.jsp";
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else
            {
                
                if (currentUser.getRole().equals("FM"))
                {
                    url = "/FM_Home.jsp";
                    session.setAttribute("username", username);
                    request.setAttribute("username", username);
                    request.getRequestDispatcher("/FM_Home.jsp").forward(request, response);
                }
                else if (currentUser.getRole().equals("U"))
                {
                    url = "/UserHome.jsp";
                    session.setAttribute("username", username);
                    request.setAttribute("username", username);
                    request.getRequestDispatcher("/UserHome.jsp").forward(request, response);
                }
                else if (currentUser.getRole().equals("A"))
                {
                    url = "/AdminHome.jsp";
                    session.setAttribute("username", username);
                    request.setAttribute("username", username);
                    request.getRequestDispatcher("/AdminHome.jsp").forward(request, response);
                }
                else
                {
                    url = "/Repairer_Home.jsp";
                    session.setAttribute("username", username);
                    request.setAttribute("username", username);
                    request.getRequestDispatcher("/Repairer_Home.jsp").forward(request, response);
                }
            }
            
            
        }
        
    }
}