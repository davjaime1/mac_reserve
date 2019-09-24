<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	  <div style="float:right">
	  <form align="right" name="form1" method="post" action="index.jsp">
  	  <label>
  	  <input name="submit2" type="submit" id="submit2" value="Logout">
  	  </label>
	  </form>
	  </div>
	  
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <div class="logo"><h1><a href="<c:url value='/' />">Mac Reserve</a></h1></div>
    <header>
        <h2>Admin Home</h2>
    </header>
</head>

<body>
    <ul>
      <li><a href="/mac_reserve/AdminController?action=viewProfile"  target="_top"><span>View Profile</span></a></li>
      <li><a href="/mac_reserve/AdminController?action=searchUser"  target="_top"><span>Search for User</span></a></li>
    </ul>
</body>

</html>