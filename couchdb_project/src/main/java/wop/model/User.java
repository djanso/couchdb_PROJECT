package wop.model;

import org.lightcouch.Document;

public class User extends Document
{
	public final static String FIRSTNAME = "firstname";
	public final static String LASTNAME = "lastname";
	public final static String USERNAME = "username";
	public final static String PASSWORD = "password";
	
	private String firstName;
    private String lastName;
    private String username;
    private String password;
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
