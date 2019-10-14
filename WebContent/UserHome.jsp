<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>

<link rel="stylesheet" href="css/commonUI.css" type="text/css"/>   

</head>

<body style="background-color: #0948b1;">
	<header class="mac">
        <h1>MAC Reserve System</h1>
    </header>
    
	<div style="float:right">
		<form align="right" name="form1" method="post" action="index.jsp">
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
            <li><a href="/mac_reserver/UserController?action=viewProfile" target="_top" style="color:white"><span>View Profile</span></a></li>
            <li><a href="/mac_reserver/UserController?action=serachAvailableFacilities" target="_top" style="color:white"><span>Search Available Facilities</span></a></li>
            <li><a href="/mac_reserver/UserController?action=viewMyReservations" target="_top" style="color:white"><span>My Reserved Facilities</span></a></li>
            <li><a href="/mac_reserver/UserController?action=viewNoShow" target="_top" style="color:white"><span>View My No Shows</span></a></li>
            <li><a href="/mac_reserver/UserController?action=viewViolation" target="_top" style="color:white"><span>View My Violations</span></a></li>
        </ul>
        </nav>
        <!-- Here goes the page the function stuff for each page (This is the homepage so nothing goes here) -->
        <article></article>
    </section>

</body>

</html>