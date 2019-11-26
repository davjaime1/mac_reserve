<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register form</title>
<link rel="stylesheet" href="css/register.css" type="text/css"/> 
</head>

<body style="background-color: #0948b1;">
	<header class="mac">
        <h1>MAC Reserve System</h1>
    </header>
    
	<header>
        <h1 style="color:white">Registration</h1>
    </header>
    
	<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: #0948b1; color: white; border: none; margin-left:630px; width:165px" disabled="disabled">
	<table class = "center">
  		<tr>
   			<td>
    			<form name="companyForm" action="/mac_reserve/UserController?action=registerUser" method="post">
    			<table>
    				<tr>
    					<td style="color:white"> User Name (*): </td>
    					<td> <input name="idusername" value="<c:out value='${user.username}'/>"  type="text" maxlength="16"> </td>
  						<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.userNameError}'/>" type="text"  style ="background-color: #f68026; color: white; border: none; width: 120px"  disabled="disabled" maxlength="60"> </td>
    				</tr>
    
					<tr>
   						<td style="color:white"> UTA ID (*): </td>
				    	<td> <input name="idutaID" value="<c:out value='${user.id}'/>" type="text" maxlength="16"> </td>
				  		<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.utaidError}'/>" type="text"  style ="background-color: #f68026; color: white; border: none; width: 120px"  disabled="disabled" maxlength="60"> </td>
				    </tr>
    
    				<tr>
				    	<td style="color:white"> First Name (*): </td>
				    	<td> <input name="idfirstname" value="<c:out value='${user.firstName}'/>" type="text" maxlength="16"> </td>
				  		<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.firstnameError}'/>" type="text"  style ="background-color: #f68026; color: white; border: none; width: 120px"  disabled="disabled" maxlength="60"> </td>
				    </tr>
    
    
				    <tr>
					    <td style="color:white"> Last Name (*): </td>
					    <td> <input name="idlastname" value="<c:out value='${user.lastName}'/>" type="text" maxlength="16"> </td>
					  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.lastnameError}'/>" type="text"  style ="background-color: #f68026; color: white; border: none; width: 120px"  disabled="disabled" maxlength="60"> </td>
					</tr>
				    
				    <tr>
				    	<td style="color:white"> Password(*): </td>
				    	<td> <input name="idpassword" value="<c:out value='${user.password}'/>" type="text" maxlength="16"> </td>
				  		<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: #f68026; color: white; border: none; width: 120px"  disabled="disabled" maxlength="60"> </td>
				    </tr>
				    
				    <tr>
				    	<td style="color:white"> Address (*): </td>
				    	<td> <input name="idaddress" value="<c:out value='${user.address}'/>" type="text" maxlength="200"> </td>
				  		<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.addressError}'/>" type="text"  style ="background-color: #f68026; color: white; border: none; width: 120px"  disabled="disabled" maxlength="60"> </td>
				    </tr>
				    
				    <tr>
				    	<td style="color:white"> City (*): </td>
				    	<td> <input name="idcity" value="<c:out value='${user.city}'/>" type="text" maxlength="16"> </td>
				  		<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.cityError}'/>" type="text"  style ="background-color: #f68026; color: white; border: none; width: 120px"  disabled="disabled" maxlength="60"> </td>
				    </tr>
				    
				    <tr>
					    <td style="color:white"> State (*): </td>
					    <td> 
					    	<select name="idstate">
					        	<c:forEach items="${STATE}" var="item" varStatus="status">
					            	<option value="${item.id}">${item.name}</option>
					          	</c:forEach>
					    	</select>
					    </td>
				    </tr>
				    
				    <tr>
				    	<td style="color:white"> Zip (*): </td>
				    	<td> <input name="idzip" value="<c:out value='${user.zip}'/>" type="text" maxlength="16"> </td>
				  		<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.zipError}'/>" type="text"  style ="background-color: #f68026; color: white; border: none; width: 120px"  disabled="disabled" maxlength="60"> </td>
				    </tr>
				    
				    <tr>
				        <td style="color:white"> Phone (*): </td>
				    	<td> <input name="idphone" value="<c:out value='${user.phone}'/>" type="text" maxlength="16"> </td>
				  		<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.phoneError}'/>" type="text"  style ="background-color: #f68026; color: white; border: none; width: 120px"  disabled="disabled" maxlength="60"> </td>
				    </tr>
				    
				    <tr>
				        <td style="color:white"> E-mail (*): </td>
				    	<td> <input name="idemail" value="<c:out value='${user.email}'/>" type="text" maxlength="45"> </td>
				  		<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.emailError}'/>" type="text"  style ="background-color: #f68026; color: white; border: none; width: 120px"  disabled="disabled" maxlength="60"> </td>
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

    				<tr>
    					<td colspan="2" style="color:white">(*) Mandatory field</td>
    				</tr>
    				<tr style="height:30px"></tr>
    			</table>
    			
    			<input name="action" value="registerUser" type="hidden">
    			<input style="color:blue;background-color: orange; width:163px; margin-left:104px" type="submit" value="Register System User" onclick="return confirm('Register new profile?');">
    			</form>
			</td>
		</tr>
		<tr>
			
	    </tr>
	</table>
	<p style="color:white;margin-left:580px">Already Have an Account?<a href="/mac_reserve/index.jsp"  target="_top" style="color:white;"> Login Here</a></p>
</body>
</html>