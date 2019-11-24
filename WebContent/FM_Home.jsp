<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Facility Manager Homepage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/commonUI.css" rel="stylesheet" type="text/css" />
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
        <!-- Here goes the page the function stuff for each page (This is the homepage so nothing goes here) -->
        <article></article>
    </section>
   
</body>
</html>