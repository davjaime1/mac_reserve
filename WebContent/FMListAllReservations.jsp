<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Reservations</title>

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
          		<li><a href="/mac_reserve/FMController?action=facilityAvailability" target="_top" style="color:white"><span>Modify Facility Availability</span></a></li>
        	</ul>
        </nav>
        <!-- Here goes the page the function stuff for each page (This is the homepage so nothing goes here) -->
        <article style="height: auto; ">
        	<table class="center" border="1">
				<tr>
					<td style="font-size: 22px;">
			        	<table class="center" border="1"> 
			        		<tr>
								<th class="myTableHead" style="padding-right: 15px; text-align: left">Type</th> 
								<th class="myTableHead" style="padding-right: 15px; text-align: left">Name</th>
								<th class="myTableHead" style="padding-right: 15px; text-align: left">Venue</th>
								<th class="myTableHead" style="padding-right: 20px; text-align: left">Hours</th> 
								<th class="myTableHead" style="padding-right: 20px; text-align: left">Date</th> 
				                <th class="myTableHead" style="padding-right: 30px; text-align: left">From</th> 
				                <th class="myTableHead" style="padding-right: 20px; text-align: left">To</th>
				                <th class="myTableHead" style="padding-right: 15px; text-align: left">Deposit</th>  
				                <th class="myTableHead" style="padding-right: 15px; text-align: left">Status</th> 
							</tr>

					 		<c:forEach items="${RESERVATIONS}" var="item" varStatus="status">
								<tr class="myTableRow">			
								<td class="myTableCell" style="padding-right: 15px; font-size: 18px; "><c:out value="${item.type}" /></td>
								<td class="myTableCell" style="padding-right: 15px; font-size: 18px;"><c:out value="${item.name}" /></td>
								<td class="myTableCell" style="padding-right: 20px; font-size: 18px;"><c:out value="${item.venue}" /></td>
								<td class="myTableCell" style="padding-right: 10px; font-size: 18px;"><c:out value="${item.day}" /></td>
								<td class="myTableCell" style="padding-right: 25px; font-size: 18px;"><c:out value="${item.date}" /></td>
					            <td class="myTableCell" style="padding-right: 15px; font-size: 18px;"><c:out value="${item.from}" /></td>
					            <td class="myTableCell" style="padding-right: 15px; font-size: 18px;"><c:out value="${item.to}" /></td>
					            <td class="myTableCell" style="padding-right: 15px; font-size: 18px;"><c:out value="${item.deposit}" /></td>
					            <td>
					            	<a href="/mac_reserve/FMController?action=processPayment&name=${item.name}&date=${item.date}&from=${item.from}&to=${item.to}" style="font-size: 20px;">${item.status}</a>
					            </td>
					            <td>
					            	<a href="/mac_reserve/UserController?action=cancelReservation&name=${item.name}&date=${item.date}&from=${item.from}&to=${item.to}" style="font-size: 20px;">Cancel</a>
					            </td>
					            <td>
					            	<a href="/mac_reserve/FMController?action=reportUser&name=${item.name}&date=${item.date}&from=${item.from}&to=${item.to}" style="font-size: 20px;">Report</a>
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