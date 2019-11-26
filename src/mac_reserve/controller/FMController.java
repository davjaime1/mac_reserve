package mac_reserve.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

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
@WebServlet("/FMController")
public class FMController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
    
    private void userParam(HttpServletRequest request, UserModel user)
    {
        user.setUser(request.getParameter("idusername"), request.getParameter("idutaID"), request.getParameter("idfirstname"), request.getParameter("idlastname"), request.getParameter("idpassword"), request.getParameter("idrole"), request.getParameter("idaddress"), request.getParameter("idstate"), request.getParameter("idcity"), request.getParameter("idzip"), request.getParameter("idphone"), request.getParameter("idemail"), request.getParameter("noshow"), request.getParameter("violations"), request.getParameter("status"));
    }
    
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
     }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action"), url="";
        session.removeAttribute("errorMsgs");
        
        if (action.equalsIgnoreCase("viewSearchForUser"))
        {
        	ArrayList<Role> roleInDB = new ArrayList<Role>();
            roleInDB = RoleDAO.listRoles();
            session.setAttribute("ROLE", roleInDB);
            
        	url = "/FMSearchForUser.jsp";
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
            	url = "/FMViewUser.jsp";
            }
            else
            {
            	url = "/FMViewOthers.jsp";
            }
            getServletContext().getRequestDispatcher(url).forward(request, response);
        	
        }
        else if(action.equalsIgnoreCase("viewFacilityReportList"))
        {
        	//Need to get list of types
        	ArrayList<String> types = new ArrayList<String>();
        	types = FM_UtilityDAO.getTypes();
        	session.setAttribute("TYPES", types);
        	url = "/FMFacilityList.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else // redirect all other gets to post
        {
            doPost(request, response);
        }
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {       
        String action = request.getParameter("action"), url = "";
        HttpSession session = request.getSession();
        
        // int selectedCompanyIndex;
        session.removeAttribute("errorMsgs");
        
        if (action.equalsIgnoreCase("viewProfile"))
        {
            String username = (String) session.getAttribute("username");
            //System.out.println(username);
            
            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserModel currentUser = new UserModel();
            currentUser.setUser(fetch_profile.get(0).getUsername(), fetch_profile.get(0).getId(), fetch_profile.get(0).getFirstName(), fetch_profile.get(0).getLastName(), fetch_profile.get(0).getPassword(), fetch_profile.get(0).getRole(), fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(), fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail(), fetch_profile.get(0).getNoshow(), fetch_profile.get(0).getViolations(), fetch_profile.get(0).getStatus());
            
            session.setAttribute("USERS", currentUser);
            url = "/FMViewProfile.jsp";
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
                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail(), fetch_profile.get(0).getNoshow(), fetch_profile.get(0).getViolations(), fetch_profile.get(0).getStatus());
            stateInDB = FM_UtilityDAO.listStates();
            session.setAttribute("STATE", stateInDB);
            
            session.setAttribute("USERS", currentUser);
            url = "/FMUpdateProfile.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("viewUserReservations"))
        {
        	String currentUser = request.getParameter("currentUser");
        	session.setAttribute("currentUser", currentUser);
        	session.setAttribute("CURRENT", currentUser);
        	ArrayList<Facility> list = new ArrayList<Facility>();
        	list = UserModelDAO.listMyReservations(currentUser);
        	session.setAttribute("RESERVATIONS", list);
        	url = "/FMListAllReservations.jsp";
        	getServletContext().getRequestDispatcher(url).forward(request, response);
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
			//Display current date
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        	Date date = new Date();
        	String dates = formatter.format(date);
        	session.setAttribute("DATE", dates);
        	url = "/FMSearchAvailableFacilities.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("listAvailableReservations"))
        {
        	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        	Date date = new Date();
        	String cDate = formatter.format(date);
      
        	LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            localDateTime = localDateTime.plusDays(1);
            String nDate = dateFormat8.format(localDateTime);
            localDateTime = localDateTime.plusDays(1);
            String nDate2 = dateFormat8.format(localDateTime);
            localDateTime = localDateTime.plusDays(1);
            String nDate3 = dateFormat8.format(localDateTime);
            localDateTime = localDateTime.plusDays(1);
            String nDate4 = dateFormat8.format(localDateTime);
            localDateTime = localDateTime.plusDays(1);
            String nDate5 = dateFormat8.format(localDateTime);
            localDateTime = localDateTime.plusDays(1);
            String nDate6 = dateFormat8.format(localDateTime);
            
            boolean error = true;
        	
            //Decide between next day or next week
            if(request.getParameter("idfacilitytype").equals("OVBC") || request.getParameter("idfacilitytype").equals("OBBC"))
            {
            	if (!(request.getParameter("iddate").equals(cDate) || request.getParameter("iddate").equals(nDate) || request.getParameter("iddate").equals(nDate2)|| request.getParameter("iddate").equals(nDate3)|| request.getParameter("iddate").equals(nDate4)|| request.getParameter("iddate").equals(nDate5)|| request.getParameter("iddate").equals(nDate6))) {
            		String errorMsgs =  request.getParameter("idfacilitytype") +" may only be reserved within a week in advance";
    				session.setAttribute("errorMsgs",errorMsgs);
    				url="/FMSearchAvailableFacilities.jsp";
    				error = false;
    			}
            }
            else
            {
            	if (!(request.getParameter("iddate").equals(cDate) || request.getParameter("iddate").equals(nDate))) {
    				String errorMsgs =  request.getParameter("idfacilitytype") +" may only be reserved a day in advanced";
    				session.setAttribute("errorMsgs",errorMsgs);
    				url="/FMSearchAvailableFacilities.jsp";
    				error = false;
    			}	
            }
        	
            if(error) {
            SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
            Date myDate = parseDate(request.getParameter("iddate"));
            String dayOfWeek = simpleDateformat.format(myDate);
        	//System.out.println(request.getParameter("idfacilitytype"));
        	//System.out.println(request.getParameter("iddate"));
        	//System.out.println(request.getParameter("idtimes"));
        	//Now we need to query based on these fields
        	ArrayList<Facility> aFacilityList = new ArrayList<Facility>();
        	session.setAttribute("facilitytype", request.getParameter("idfacilitytype"));
        	session.setAttribute("date", request.getParameter("iddate"));
        	session.setAttribute("times", request.getParameter("idtimes"));
        	aFacilityList = UserModelDAO.listAvailableReservations(request.getParameter("idfacilitytype"), request.getParameter("iddate"), request.getParameter("idtimes"), dayOfWeek);
        	session.setAttribute("AVAILABLE", aFacilityList);
        	
			//Get All Reserved Facilities List
			String username = (String) session.getAttribute("username");
        	ArrayList<Facility> ReservationList = new ArrayList<Facility>();
        	ReservationList = UserModelDAO.listReservations();
        	
        	//Now we need to remove the current reservations from the possible reservations
        	//aFacilityList will be the list with the remaining possible reservations
        	UserModelDAO.AvailableReservations(aFacilityList, ReservationList);
        	
        	session.setAttribute("FACILITYs", aFacilityList);
        	url = "/FMListAvailableReservations.jsp";
            }
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
                getServletContext().getRequestDispatcher("/FMUpdateProfile.jsp").forward(request, response);
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
	                    fetch_profile.get(0).getZip(), fetch_profile.get(0).getPhone(), fetch_profile.get(0).getEmail(), fetch_profile.get(0).getNoshow(), fetch_profile.get(0).getViolations(), fetch_profile.get(0).getStatus());
	            
	            session.setAttribute("USERS", currentUser);
	            url = "/FMViewProfile.jsp";
	            getServletContext().getRequestDispatcher(url).forward(request, response);
            }	
        }
        else if(action.equalsIgnoreCase("searchForUser"))
        {
        	String searchUsername = request.getParameter("idusername");
        	String searchRole = request.getParameter("idrole");
        	
        	//Need to search query based on the username and role
        	ArrayList<UserModel> results = new ArrayList<UserModel>();
        	results = FM_UtilityDAO.searchUsers(searchUsername, "Null" ,searchRole);
        	session.setAttribute("USERS", results);
        	
        	url = "/FMListUserResults.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("viewTypeDetails"))
        {
        	ArrayList<Facility> results = new ArrayList<Facility>();
        	results = FM_UtilityDAO.getFacilities(request.getParameter("type"));
        	session.setAttribute("NAMES", results);
        	url = "/FMViewTypeDetails.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("changeFacilityAvailability"))
        {
        	String name = request.getParameter("name");
        	String ava = request.getParameter("ava");
        	FM_UtilityDAO.setAvaliability(name, ava);
        	ArrayList<Facility> results = new ArrayList<Facility>();
        	results = FM_UtilityDAO.getFacilities(request.getParameter("type"));
        	session.setAttribute("NAMES", results);
        	url = "/FMViewTypeDetails.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("reportUser"))
        {
        	//Now we need to create the form with all the details, and a description box
        	Facility fac = new Facility();
        	fac.setName(request.getParameter("name"));
        	fac.setDate(request.getParameter("date"));
        	fac.setFrom(request.getParameter("from"));
        	fac.setTo(request.getParameter("to"));
        	fac.setDate(request.getParameter("date"));
        	session.setAttribute("FAC", fac);
        	
        	url = "/FMReportViolation.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("submitViolation"))
        {
        	//We need to add this violation to the database
        	String desc = request.getParameter("descriptionTextArea");
        	String type = request.getParameter("report");
        	
        	if(type.equals("violation"))
        	{
            	FM_UtilityDAO.addViolation(request.getParameter("currentUser"),request.getParameter("name"),request.getParameter("date"),request.getParameter("from"),request.getParameter("to"), desc);
        	}
        	else
        	{
            	FM_UtilityDAO.addNoShow(request.getParameter("currentUser"),request.getParameter("name"),request.getParameter("date"),request.getParameter("from"),request.getParameter("to"), desc);

        	}
        	String currentUser = (String)session.getAttribute("currentUser");
        	ArrayList<Facility> list = new ArrayList<Facility>();
        	list = UserModelDAO.listMyReservations(currentUser);
        	session.setAttribute("RESERVATIONS", list);
        	url = "/FMListAllReservations.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("processPayment"))
        {
        	FM_UtilityDAO.processPayment(request.getParameter("name"), request.getParameter("date"), request.getParameter("from"), request.getParameter("to"));
        	String currentUser = (String)session.getAttribute("currentUser");
        	//session.removeAttribute("currentUser");
        	//session.setAttribute("CURRENT", currentUser);
        	ArrayList<Facility> list = new ArrayList<Facility>();
        	list = UserModelDAO.listMyReservations(currentUser);
        	session.setAttribute("RESERVATIONS", list);
        	url = "/FMListAllReservations.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equalsIgnoreCase("cancelReservation"))
        {
        	String username = (String)session.getAttribute("currentUser");
       	
        	//Query and delete reservation
        	UserModelDAO.cancelReservation(request.getParameter("date"), request.getParameter("name"), request.getParameter("from"), request.getParameter("to"));
        	
        	//Display My Reservations
        	ArrayList<Facility> ReservationList = new ArrayList<Facility>();
        	ReservationList = UserModelDAO.listMyReservations(username);
        	session.setAttribute("RESERVATIONS", ReservationList);
        	url = "/FMListAllReservations.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }
}