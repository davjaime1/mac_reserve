<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile</title>

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
        <h1 style="color:white">Admin Home</h1>
    </header>

    <section>
    	<nav>
	        <ul>
	            	<li><a href="/mac_reserve/AdminController?action=viewProfile"  target="_top" style="color:white"><span>View Profile</span></a></li>
	      			<li><a href="/mac_reserve/AdminController?action=viewSearchForUser"  target="_top" style="color:white"><span>Search for User</span></a></li>
	      	</ul>
        </nav>
        <!-- Here goes the page the function stuff for each page -->
        <article style="height: auto">
        	<table class="center">
				<tr>
					<td>
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
			    				<td> Password: </td>
			    				<td> <c:out value="${USERS.password}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Role: </td>
			    				<td> <c:out value="${USERS.role}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> First Name: </td>
			    				<td> <c:out value="${USERS.firstName}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Last Name: </td>
			    				<td> <c:out value="${USERS.lastName}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Address: </td>
			    				<td> <c:out value="${USERS.address}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> City: </td>
			    				<td> <c:out value="${USERS.city}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> State: </td>
			    				<td> <c:out value="${USERS.state}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Zip Code: </td>
			    				<td> <c:out value="${USERS.zip}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Phone: </td>
			    				<td> <c:out value="${USERS.phone}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Email: </td>
			    				<td> <c:out value="${USERS.email}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> No Shows: </td>
			    				<td> <c:out value="${USERS.noshow}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Violations: </td>
			    				<td> <c:out value="${USERS.violations}" /> </td>
			    			</tr>
			    		
			    			<tr>
			    				<td> Status: </td>
			    				<td> <c:out value="${USERS.status}" /> </td>
			    			</tr>
			
			    			<tr>
			   				</tr>
			    		</table>
			    		<table>
				    		<form name="companyForm" action="/mac_reserve/AdminController?action=userStatus&username=${USERS.username}&status=${USERS.status}" method="post">
				    		<input name="action" value="registerUser" type="hidden">
			    			<input style="width:163px; margin-left:14px" type="submit" value="Revoke/Unrevoke" onclick="return confirm('Change ${USERS.username}\'s privileges?');">
			    			</form>
			    			<form name="companyForm" action="/mac_reserve/AdminController?action=changeRole&username=${USERS.username}" method="post">
			    			<input name="action" value="registerUser" type="hidden">
		    				<input style="width:163px; margin-left:80px" type="submit" value="Change User Role">
	    					</form>
		    			</table>
					</td>
				</tr>
			</table>
        </article>
    </section>

</body>

</html>