<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search For Reservations</title>

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
	            <li><a href="/mac_reserve/UserController?action=viewSearchAvailableFacilities" target="_top" style="color:white"><span>Search Available Facilities</span></a></li>
	            <li><a href="/mac_reserve/UserController?action=viewMyReservations" target="_top" style="color:white"><span>My Reserved Facilities</span></a></li>
	            <li><a href="/mac_reserve/UserController?action=viewNoShow" target="_top" style="color:white"><span>View My No Shows</span></a></li>
	            <li><a href="/mac_reserve/UserController?action=viewViolation" target="_top" style="color:white"><span>View My Violations</span></a></li>
	        </ul>
        </nav>
        <!-- Here goes the page the function stuff for each page (This is the homepage so nothing goes here) -->
        <article>
        	<table class="center">
				<tr>
					<td>
						<input name="errMsg"  value="<c:out value='${errorMsg}'/>" type="text"  style ="background-color:#f68026;; color: white; margin-left:5px;border: none; width: 350px" disabled="disabled"> 
						<form name="userForm" action="/mac_reserve/UserController?action=listAvailableReservations&idmodify=${0}" method="post">
			        	<table class="center"> 
			        		<tr>
			    				<td> Facility Type: </td>
							    <td> 
							    <select name="idfacilitytype">
							          <c:forEach items="${FACILITY}" var="item" varStatus="status">
							            <option value="${item.type}">${item.type}</option>
							          </c:forEach>
							    </select>
							    </td>
			    			</tr>
			    				<td>Date: </td>
			    				<td>
				    				<input type="date" id="iddate" name="iddate"
				    				value= "${DATE}">
							    </td>
			    			<tr>
						   		<td> Times: </td>
							    <td> 
							    <select name="idtimes">
							          <c:forEach items="${TIMES}" var="item" varStatus="status">
							            <option value="${item}">${item}</option>
							          </c:forEach>
							    </select>
							    </td>
						    </tr>
			        	</table>
			        	<input name="action" value="searchUser" type="hidden">
		    			<input style="width:163px; margin-left:104px" type="submit" value="Search for Reservations">
		    			</form>
			        </td>	
			        <tr> <td style="padding:0px"><input name="statusError"  value="<c:out value='${errorMsgs.statusError}'/>" type="text"  style ="background-color: #f68026; color: #0948b1; border: none;margin-left:100;width:350px"   disabled="disabled" maxlength="120"> </td>		        
			    </tr>			    
			</table>
        </article>
    </section>

</body>

</html>