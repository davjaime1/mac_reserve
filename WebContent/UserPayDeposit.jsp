<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Deposit</title>

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
						<input name="errMsg"  value="<c:out value='${errorMsgs}'/>" type="text"  style ="background-color:#f68026;; color: white; border: none; width: 400px" disabled="disabled"> 
						<form name="userForm" action="/mac_reserve/UserController?action=listAvailableReservations" method="post">
			        	<table class="center"> 
			        		<tr>
			    				<td> Card Company: </td>
							    <td> 
							    <select name="cars">
								  <option value="volvo">American Express</option>
								  <option value="saab">MasterCard</option>
								  <option value="mercedes">Visa</option>
								</select>
							    </td>
			    			</tr>

							<tr>
	    					<td style="color:white"> Card Number : </td>
	    					<td> <input name="idusername" value="<c:out value='${user.username}'/>"  type="text" maxlength="16"> </td>
	    				</tr>
	    
						<tr>
	   						<td style="color:white"> Sceurity Code : </td>
					    	<td> <input name="idutaID" value="" type="text" maxlength="16"> </td>
					    </tr>
	    
	    				<tr>
					    	<td style="color:white"> Exp Date (*): </td>
					    	<td> <input name="idfirstname" value="10-22-2019" type="text" maxlength="16"> </td>
					    </tr>
					    
			        	</table>
			        	<input name="action" value="searchUser" type="hidden">
		    			<input style="color:blue;background-color: orange; width:163px; margin-left:104px" type="submit" value="Pay Deposit">
		    			</form>
			        </td>
			    </tr>
			</table>
        </article>
    </section>

</body>

</html>