<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Search Results</title>
	<link rel="stylesheet" href="css/commonUI.css" type="text/css"/>
	
</head>

<body style="background-color: #0948b1;">
	<header class="mac">
        <h1>MAC Reserve System</h1>
    </header>
    
	<div style="float:right">
		<form name="form1" method="post" action="index.jsp">
	  		<label>
	  			<input name="submit2" type="submit" class="submit" id="submit2" value="Logout">
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
			        	<table class="center" border="1"> 
			        		<tr>
					            <td style="text-decoration: underline">Username</td>
					            <td style="text-decoration: underline">ID</td>
					            <td style="text-decoration: underline">First Name</td>
					            <td style="text-decoration: underline">Last Name</td>
					            <td style="text-decoration: underline">Role</td>
					        </tr>
					
					        <c:forEach items="${USERS}" var="user">
					            <tr>
					                <td>
					                    <c:out value="${user.username}" />
					                </td>
					                <td>
					                    <c:out value="${user.id}" />
					                </td>
					                <td>
					                    <c:out value="${user.firstName}" />
					                </td>
					                <td>
					                    <c:out value="${user.lastName}" />
					                </td>
					                <td>
					                    <c:out value="${user.role}" />
					                </td>
					                <td>
					                    <a href="/mac_reserve/FMController?action=viewSpecificUser&username=${user.username}&role=${user.role}">View</a>
					                </td>
					            </tr>
					        </c:forEach>
			        	</table>
			        </td>
			    </tr>
			</table>        
        </article>
    </section>
    
    
</body>

</html>