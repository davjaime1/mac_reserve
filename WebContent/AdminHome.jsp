<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
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
	  <div style="float:right">
	  <form align="right" name="form1" method="post" action="index.jsp">
  	  <label>
  	  <input name="submit2" type="submit" class="submit" id="submit2" value="Logout">
  	  </label>
	  </form>
	  </div>
	  
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <header>
        <h2 style="color:blue">Admin Home</h2>
    </header>
</head>

<body>
    <ul>
      <li><a href="/mac_reserve/AdminController?action=viewProfile"  target="_top"><span>View Profile</span></a></li>
      <li><a href="/mac_reserve/AdminController?action=searchUser"  target="_top"><span>Search for User</span></a></li>
    </ul>
</body>

</html>