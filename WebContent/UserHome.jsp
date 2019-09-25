<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Home</title>
    <style>
.submit {
  background-color: red;
  border: none;
  color: white;
  padding: 6px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
</head>

<body>
	  <div style="float:right">
	  <form align="right" name="form1" method="post" action="index.jsp">
  	  <label>
  	  <input name="submit2" type="submit" class="submit"id="submit2" value="Logout">
  	  </label>
	  </form>
	  </div>
    <header>
        <h2 style="color:blue">User Home</h2>
    </header>

    <section>

        <ul>
            <li><a href="/mac_reserver/UserController?action=viewProfile" target="_top"><span>View Profile</span></a></li>
            <li><a href="/mac_reserver/UserController?action=serachAvailableFacilities" target="_top"><span>Search Available Facilities</span></a></li>
            <li><a href="/mac_reserver/UserController?action=viewMyReservations" target="_top"><span>My Reserved Facilities</span></a></li>
            <li><a href="/mac_reserver/UserController?action=viewNoShow" target="_top"><span>View My No Shows</span></a></li>
            <li><a href="/mac_reserver/UserController?action=viewViolation" target="_top"><span>View My Violations</span></a></li>
        </ul>

    </section>

</body>

</html>