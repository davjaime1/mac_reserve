<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Log In</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/index.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #0948b1;">
	<header class="mac">
        <h1>MAC Reserve System</h1>
    </header>

	<table class="center">
		<tr>
			<td>
				<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: #0948b1; color: orange; border: none; margin-left:83px; width:230px" disabled="disabled"><br>	
				<form action="/mac_reserve/UserController?action=loginUser" method="post">
					<table>
						<tr>
						  	<th style="color:white">Username:</th>
						 	<td> <input name="idusername" type="text" maxlength="45" >  </td>
						</tr>
						<tr>
							<td></td>
				    		<td> <input name="marnumberError"  value="<c:out value='${errorMsgs.userNameError}'/>" type="text"  style ="background-color: #0948b1; color: orange; border: none;margin-left:100"   disabled="disabled" maxlength="60"> </td>
						</tr>
					    <tr>
					    	<th style="color:white">Password:</th>
					    	<td> <input name="idpassword" type="text" maxlength="16"> </td>
					    </tr>
					    <tr>
					    	<td></td>
					 		<td> <input name="facilityname"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: #0948b1; color: orange; border: none;"   disabled="disabled" maxlength="60"> </td>
					    </tr>
					</table>
					<div class="bcente">
				  	<input style="color:blue;background-color: orange;width:163px ;margin-left: 80px;" type="submit" value="Login" >
				  	</div>
				</form>      
			</td>
		  	<tr>
				<td><a href="/mac_reserve/UserController?action=registerProfile"  target="_top" style="margin-left: 118px;color:white;"> Register Here </a>
	    </tr>
	</table>

</body>
</html>