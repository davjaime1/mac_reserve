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
        <h1 style="color:white">User Home</h1>
    </header>

    <section>
    	<nav>
        <ul>
            <li><a href="/mac_reserve/UserController?action=viewProfile" target="_top" style="color:white"><span>View Profile</span></a></li>
            <li><a href="/mac_reserve/UserController?action=serachAvailableFacilities" target="_top" style="color:white"><span>Search Available Facilities</span></a></li>
            <li><a href="/mac_reserve/UserController?action=viewMyReservations" target="_top" style="color:white"><span>My Reserved Facilities</span></a></li>
            <li><a href="/mac_reserve/UserController?action=viewNoShow" target="_top" style="color:white"><span>View My No Shows</span></a></li>
            <li><a href="/mac_reserve/UserController?action=viewViolation" target="_top" style="color:white"><span>View My Violations</span></a></li>
        </ul>
        </nav>
        <!-- Here goes the page the function stuff for each page -->
        <article>
        	<table class="center">
				<tr>
					<td>
						<form name="companyForm" action="/mac_reserve/AdminController?action=updateProfile" method="post">
			        	<table class="center"> 
			    			<tr>
			    				<td> Username: </td>
			    				<td><input name="idusername" value="<c:out value='${USERS.username}'/>" type="text" maxlength="45"></td>
			    			</tr>
							
							<tr>
			    				<td> UTA Id: </td>
			    				<td><input name="idusername" value="<c:out value='${USERS.id}'/>" type="text" maxlength="45"></td>
			    			</tr>
			    			
			    			<tr>
			    				<td> First Name: </td>
			    				<td><input name="idusername" value="<c:out value='${USERS.firstName}'/>" type="text" maxlength="45"></td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Last Name: </td>
			    				<td><input name="idusername" value="<c:out value='${USERS.lastName}'/>" type="text" maxlength="45"></td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Address: </td>
			    				<td><input name="idusername" value="<c:out value='${USERS.address}'/>" type="text" maxlength="45"></td>
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
			    				<td><input name="idusername" value="<c:out value='${USERS.zip}'/>" type="text" maxlength="45"></td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Phone : </td>
			    				<td><input name="idusername" value="<c:out value='${USERS.phone}'/>" type="text" maxlength="45"></td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Email: </td>
			    				<td><input name="idusername" value="<c:out value='${USERS.email}'/>" type="text" maxlength="45"></td>
			    			</tr>
			
			    			<tr>
			   				</tr>
			    		</table>
			    		<input name="action" value="registerUser" type="hidden">
    					<input style="width:163px; margin-left:92px" type="submit" value="Update User">
    					</form>
					</td>
				</tr>
			</table>
        </article>
    </section>

</body>

</html>