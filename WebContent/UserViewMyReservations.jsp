<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Reservations</title>

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
								<th class="myTableHead" style="padding-right: 35px; text-align: left">Date</th> 
				                <th class="myTableHead" style="padding-right: 20px; text-align: left">From</th> 
				                <th class="myTableHead" style="padding-right: 20px; text-align: left">To</th>
				                <th class="myTableHead" style="padding-right: 15px; text-align: left">Deposit</th>  
				                <th class="myTableHead" style="padding-right: 15px; text-align: left">Status</th>
							</tr>

					 		<c:forEach items="${AVAILABLE}" var="item" varStatus="status">
								<tr class="myTableRow">			
								<td class="myTableCell" style="padding-right: 15px; font-size: 18px; "><c:out value="${item.type}" /></td>
								<td class="myTableCell" style="padding-right: 15px; font-size: 18px;"><c:out value="${item.name}" /></td>
								<td class="myTableCell" style="padding-right: 20px; font-size: 18px;"><c:out value="${item.venue}" /></td>
								<td class="myTableCell" style="padding-right: 10px; font-size: 18px;"><c:out value="${item.day}" /></td>
								<td class="myTableCell" style="padding-right: 25px; font-size: 18px;"><c:out value="${item.date}" /></td>
					            <td class="myTableCell" style="padding-right: 30px; font-size: 18px;"><c:out value="${item.from}" /></td>
					            <td class="myTableCell" style="padding-right: 30px; font-size: 18px;"><c:out value="${item.to}" /></td>
					            <td class="myTableCell" style="padding-right: 15px; font-size: 18px;"><c:out value="${item.deposit}" /></td>
					            <td class="myTableCell" style="padding-right: 15px; font-size: 18px;"><c:out value="${item.status}" /></td>
					            <td>
					                    <a href="/mac_reserve/UserController?action=listAvailableReservations&idfacilitytype=${item.type}&iddate=${item.date}&idtimes=${''}&name=${item.name}&from=${item.from}&to=${item.to}&idmodify=${1}" style="font-size: 20px;">Modify</a>
					             </td>
					             <td>
					                    <a href="/mac_reserve/UserController?action=cancelReservation&name=${item.name}&date=${item.date}&from=${item.from}&to=${item.to}" style="font-size: 20px;" onclick="return confirm('Are you sure you want to cancel your reservation? ...there are no refunds hehe :)');">Cancel</a>
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