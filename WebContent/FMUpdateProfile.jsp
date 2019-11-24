<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>

<link rel="stylesheet" href="css/commonUI.css" type="text/css"/>   

</head>

<body style="background-color: #0948b1;">
	<header class="mac">
        <h1>MAC Reserve System</h1>
    </header>
    
	<div style="float:right">
		<form name="form1" method="post" action="index.jsp">
  	  		<label>
  	  			<input name="submit2" type="submit" class="submit"id="submit2" value="Logout">
  	  		</label>
	  	</form>
	</div>
	
    <header>
        <h1 style="color:white">Facility Manager Home</h1>
    </header>

    <section>
    	<nav>
	        <ul>
            	<li><a href="/mac_reserve/FMController?action=viewProfile"  target="_top" style="color:white"><span>View Profile</span></a></li>
          		<li><a href="/mac_reserve/FMController?action=viewSearchAvailableFacilities"  target="_top" style="color:white"><span>Search Available Facilities</span></a></li>
          		<li><a href="/mac_reserve/FMController?action=viewFacilityReportList"  target="_top" style="color:white"><span>View Facility Details</span></a></li>          		
          		<li><a href="/mac_reserve/FMController?action=viewSearchForUser"  target="_top" style="color:white"><span>Search for User</span></a></li>
        	</ul>
        </nav>
        <!-- Here goes the page the function stuff for each page -->
        <article>
        	<table class="center">
				<tr>
					<td>
						<form name="companyForm" action="/mac_reserve/FMController?action=updateProfile&idusername=${USERS.username}&idutaID=${USERS.id}&idrole=${USERS.role}" method="post">
			        	<table class="center"> 
			    			<tr>
			    				<td> Username: </td>
			    				<td> <c:out value="${USERS.username}" /> </td>
			    			</tr>
							
							<tr>
			    				<td> UTA Id: </td>
			    				<td> <c:out value="${USERS.id}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Role: </td>
			    				<td> <c:out value="${USERS.role}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Password: </td>
			    				<td><input name="idpassword" value="<c:out value='${USERS.password}'/>" type="text" maxlength="45"></td>
			    				<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color:#f68026;; color: white; border: none; width: 109px"  disabled="disabled" maxlength="60"> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> First Name: </td>
			    				<td><input name="idfirstname" value="<c:out value='${USERS.firstName}'/>" type="text" maxlength="45"></td>
			    				  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.firstnameError}'/>" type="text"  style ="background-color: #f68026;; color: white; border: none; width: 109px"  disabled="disabled" maxlength="60"> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Last Name: </td>
			    				<td><input name="idlastname" value="<c:out value='${USERS.lastName}'/>" type="text" maxlength="45"></td>
			    				  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.lastnameError}'/>" type="text"  style ="background-color: #f68026;; color: white; border: none; width: 109px"  disabled="disabled" maxlength="60"> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Address: </td>
			    				<td><input name="idaddress" value="<c:out value='${USERS.address}'/>" type="text" maxlength="45"></td>
			    				<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.addressError}'/>" type="text"  style ="background-color: #f68026;; color: white; border: none; width: 109px"  disabled="disabled" maxlength="60"> </td>			    				
			    			</tr>
			    			
			    			<tr>
			    				<td> City: </td>
			    				<td><input name="idcity" value="<c:out value='${USERS.city}'/>" type="text" maxlength="45"></td>
			    				<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.cityError}'/>" type="text"  style ="background-color: #f68026;; color: white; border: none; width: 109px"  disabled="disabled" maxlength="60"> </td>			    				
			    			</tr>
			    			
			    			<tr>
			    				<td> State: </td>
			    				<td> 
							    <select name="idstate">
							          <c:forEach items="${STATE}" var="item" varStatus="status">
							            <option value="${item.id}">${item.name}</option>
							          </c:forEach>
							    </select>
							    </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Zip Code: </td>
			    				<td><input name="idzip" value="<c:out value='${USERS.zip}'/>" type="text" maxlength="45"></td>
			    				<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.zipError}'/>" type="text"  style ="background-color: #f68026;; color: white; border: none; width: 109px"  disabled="disabled" maxlength="60"> </td>			    				
			    			</tr>
			    			
			    			<tr>
			    				<td> Phone : </td>
			    				<td><input name="idphone" value="<c:out value='${USERS.phone}'/>" type="text" maxlength="45"></td>
			    				<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.phoneError}'/>" type="text"  style ="background-color: #f68026;; color: white; border: none; width: 109px"  disabled="disabled" maxlength="60"> </td>			    				
			    			</tr>
			    			
			    			<tr>
			    				<td> Email: </td>
			    				<td><input name="idemail" value="<c:out value='${USERS.email}'/>" type="text" maxlength="45"></td>
			    				<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.emailError}'/>" type="text"  style ="background-color: #f68026;; color: white; border: none; width: 109px"  disabled="disabled" maxlength="60"> </td>			    				
			    			</tr>
			
			    			<tr>
			   				</tr>
			    		</table>
			    		<tr>
							<td>
					    		<input name="action" value="registerUser" type="hidden">
		    					<input style="width:163px; margin-left:157px" type="submit" value="Update" onclick="return confirm('Are you sure you want to update?');">
		    					</form>
	    					</td>
						</tr>
					</td>
				</tr>
			</table>
        </article>
    </section>

</body>

</html>