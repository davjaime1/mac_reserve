package mac_reserve.model;

import mac_reserve.data.UserModelDAO;

public class UserModel {
	
	private String username;
	private String id;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	private String address;
	private String state;
	private String city;
	private String zip;
	private String email;
	private String phone;
	private String noshow = "0";
	private String violations = "0";
	private String status = "Unrevoked";
	
	public void setUser (String username, String id, String firstName, String lastName, String password, String role, String address,String state,String city,String zip, String phone, String email, String noshow, String violations, String status) {
		setUsername(username);
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setRole(role);
		setAddress(address);
		setState(state);
		setCity(city);
		setZip(zip);
		setPhone(phone);
		setEmail(email);
		setNoshow(noshow);
		setViolations(violations);
		setStatus(status);
	}
	
	
	public void setUsername(String username) {
		this.username=username;
	}
	public String getUsername() {
		return username;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	public String getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setPassword(String pasword) {
		this.password=pasword;
	}
	public String getPassword() {
		return password;
	}
	
	public void setRole(String role) {
		this.role=role;
	}
	public String getRole() {
		return role;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
		
	public void setState(String state) {
		this.state=state;
	}
	public String getState() {
		return state;
	}

	public void setCity(String city) {
		this.city=city;
	}
	public String getCity() {
		return city;
	}

	public void setZip(String zip) {
		this.zip=zip;
	}
	public String getZip() {
		return zip;
	}
	
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public String getPhone() {
		return phone;
	}

	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setNoshow(String noshow)
	{
		this.noshow = noshow;
	}
	
	public String getNoshow()
	{
		return noshow;
	}
	
	public void setViolations(String violations)
	{
		this.violations = violations;
	}
	
	public String getViolations()
	{
		return violations;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getStatus()
	{
		return status;
	}

	public void validateUser (String action, UserErrorMsgs errorMsgs) {
	
			errorMsgs.setUserNameError(validateUsername(action, this.getUsername()));
			errorMsgs.setUtaidError(validateId(this.getId()));
			errorMsgs.setFirstnameError(validateFirstName(this.getFirstName()));
			errorMsgs.setLastnameError(validateLastName(this.getLastName()));
			errorMsgs.setPasswordError(validatePassword(this.getPassword()));
			errorMsgs.setAddressError(validateAddress(this.getAddress()));
			errorMsgs.setCityError(validateCity(this.getCity()));
			errorMsgs.setZipError(validateZip(this.getZip()));
			errorMsgs.setPhoneError(validatePhone(this.getPhone()));
			errorMsgs.setEmailError(validateEmail(this.getEmail()));
//			System.out.println("Calling setErrorMsg() with first name error: "+errorMsgs.getusernameError());
			errorMsgs.setErrorMsg(action);
//			System.out.println("After setErrorMsg"+errorMsgs.getErrorMsg());
		

		
	}
	public void validateLogin (String action, String pssd, UserErrorMsgs errorMsgs) {
		errorMsgs.setPasswordError(matchPassword( pssd));
		errorMsgs.setErrorMsg(action);

	}

	private String matchPassword(String psswd) {
		String result="";
		if(!password.equals(psswd)) {
		
			result="Incorrect password";
			}else if(password==null || password.equals("")) {
		result="Password is empty";
		}
		return result;
	}

	private String validateUsername(String action, String username) {
		String result="";
		if(username==null || username.equals("")&& action.contains("registerUser")) {
			result="Username is empty";
		}
		else if (!UserModelDAO.userNameunique(username) && action.contains("registerUser")) {
			result="Username already exists";
		}
		else if(username==null || username.equals("")) {
			result="No user Found";
		}
	
	return result;
	}


	private String validateId(String id) {
		String regex="\\d{10}";
		String result="";
		if(!id.equals("") && id.matches(regex)) {
		
			result="";
	}else {
		result="Incorrect UTA ID";
		}
	return result;
	}
	
	private String validateFirstName(String firstName) {
	String result="";	
	String regex="^[a-zA-Z]*$";
	if(!firstName.equals("") && firstName.matches(regex)) {
//		result="Valid FirstName";
		result="";
	}else {
		result="Invalid First Name";
	}
	return result;
	}
	
	private String validateLastName(String lastName) {
		String result="";	
		String regex="^[a-zA-Z]*$";
		if(!lastName.equals("") && lastName.matches(regex)) {
		result="";
		}else {
			result="Invalid Last Name";
		}
		return result;
		}

	private String validatePassword(String password) {
		String result="";	
		if(!password.equals("") && password.length()>6) {
		result="";
		}else {
			result="Invalid Password";
		}
		return result;
		}
	
	private String validateAddress(String address) {
		String result="";
		if(address==null || address.equals("")) {
		result="Invalid Address";
	}
	return result;
	}

	
	
	
	private String validateCity(String city) {
		String result="";	
		String regex="^[a-zA-Z]*$";
		if(!city.equals("") && city.matches(regex)) {
		result="";
		}else {
			result="Invalid City Name";
		}
		return result;
		}
	
	private String validateZip(String zip) {
		String result="";	
		String regex="\\d{5}";
		if(!zip.equals("") && zip.matches(regex)) {
		result="";
		}else {
			result="Invalid Zip";
		}
		return result;
		}

	private String validatePhone(String phone) {
		String result="";	
		String regex="\\d{10}";
		if(!phone.equals("") && phone.matches(regex)) {
		result="";
		}else {
			result="Invalid Phone";
		}
		return result;
		}

	private String validateEmail(String email) {
		String result="";	
		String regex="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(!email.equals("") && email.matches(regex) && email.contains("uta.edu")) {
		result="";
		}else {
			result="Invalid Email";
		}
		return result;
		}


}
