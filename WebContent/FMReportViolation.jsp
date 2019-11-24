<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report Violation</title>

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
        <!-- Here goes the page the function stuff for each page (This is the homepage so nothing goes here) -->
        <article style="height: auto">
        	<table class="center">
				<tr>
					<td>
						<form name="userForm" action="/mac_reserve/FMController?action=submitViolation&currentUser=${CURRENT}&name=${FAC.name}&date=${FAC.date}&from=${FAC.from}&to=${FAC.to}" method="post">
			        	<table class="center"> 
			    			<tr>
			    				<td> Username: </td>
			    				<td> <c:out value="${CURRENT}" /> </td>
			    			</tr>
							
							<tr>
			    				<td> Facility Name: </td>
			    				<td> <c:out value="${FAC.name}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Date: </td>
			    				<td> <c:out value="${FAC.date}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> From: </td>
			    				<td> <c:out value="${FAC.from}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> To: </td>
			    				<td> <c:out value="${FAC.to}" /> </td>
			    			</tr>
			    			
			    			<tr>
			    				<td> Description: </td>
			    				<td><textarea name=descriptionTextArea maxlength="120" wrap="soft" rows=4></textarea></td>
			    			</tr>
			    			
							<tr>
			    				<td><input type="radio" name="report" value="violation" checked="checked"> Violation<br> </td>
	  							<td><input type="radio" name="report" value="noshow"> No Show<br> </td>
			    			</tr>
				    			
			    			<tr>
			   				</tr>
			    		</table>
						<input name="action" value="searchUser" type="hidden">
		    			<input style="color:blue;background-color: orange; width:163px; margin-left:104px" type="submit" value="Submit" onclick="return confirm('Please confirm your report submission');">
		    			</form>
				</tr>
			</table>
        </article>
    </section>

</body>

</html>