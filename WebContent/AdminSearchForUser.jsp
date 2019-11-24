<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search For User</title>
	<link rel="stylesheet" href="css/commonUI.css" type="text/css"/>
	
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
    	<h1 style="color:white">Admin Home</h1>
    </header>
    
    <section>
    	<nav>
	        <ul>
	            <li><a href="/mac_reserve/AdminController?action=viewProfile"  target="_top" style="color:white"><span>View Profile</span></a></li>
	      		<li><a href="/mac_reserve/AdminController?action=viewSearchForUser"  target="_top" style="color:white"><span>Search for User</span></a></li>
	        </ul>
        </nav>
        <!-- Here goes the page the function stuff for each page-->
        <article>
        	<table class="center">
				<tr>
					<td>
						<form name="userForm" action="/mac_reserve/AdminController?action=searchForUser" method="post">
			        	<table class="center"> 
			        		<tr>
			    				<td> Username: </td>
			    				<td><input name="idusername" value="" type="text" maxlength="45"></td>
			    			</tr>
			    			
			    			<tr>
						   		<td style="color:white"> Role: </td>
						     	<td> 
						    		<select name="idrole">
						          		<c:forEach items="${ROLE}" var="item" varStatus="status">
						            		<option value="${item.id}">${item.name}</option>
						          		</c:forEach>
						    		</select>
						    	</td>
						    </tr>
			        	</table>
			        	<input name="action" value="searchUser" type="hidden">
		    			<input style="width:163px; margin-left:92px" type="submit" value="Search for Users">
		    			</form>
			        </td>
			    </tr>
			</table>        
        </article>
    </section>
    
    
</body>

</html>