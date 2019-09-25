<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Log In</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
	<header>
        <h2 style="color:blue">MAC Reserve System</h2>
    </header>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: orange; border: none; width:200px" disabled="disabled">
<table>
<tr>
	<td>
	<form action="/mac_reserve/UserController?action=loginUser" method="post">
	<table style="width: 1200px; ">
	<tr>
	<tr>
  	<td> User name: </td>
 	<td> <input name="idusername" value="<c:out value='${USERS.username}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="marnumberError"  value="<c:out value='${errorMsgs.userNameError}'/>" type="text"  style ="background-color: white; color: orange; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
	</tr>
 
    <tr>
    <td> Password: </td>
    <td> <input name="idpassword" value="<c:out value='${USERS.password}'/>" type="text" maxlength="16"> </td>
 	<td> <input name="facilityname"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: orange; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>

    </tr>

</table>
  <input style="color:blue;background-color: orange" type="submit" value="Submit" >
	</form>      
</td>
  <tr>
<td><a href="/mac_reserve/UserController?action=registerProfile"  target="_top"> Register Here </a>
    </tr>
</table>

</body>
</html>