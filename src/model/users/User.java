package model.users;

import model.Page;

public abstract class User extends GuestUser{
	String username;
	String name;
	String surname;
	String encodedPassword;
	
	public User() {
		super();
		setUsername("Unknown");
		setName("Unknown");
		setSurname("Unknown");
		setPassword("Password");
	}
	
	public User(String username, String name, String surname, String password) {
		super();
		setName(name);
		setSurname(surname);
		setUsername(username);
		setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username != null && username.matches("[a-z0-9.]{8,20}")) {
			this.username = username;
		}
		else {
			this.username = "Default.username";
		}
		
	}

	public String getPassword() {
		return encodedPassword;
	}

	public void setPassword(String password) {
		if (password != null && encodedPassword.matches("[A-Za-z0-9]{8,20}")) {
			encodedPassword = password;
		}
		else {
			encodedPassword = "defaultpassword";
		}
	}
	public String toString() {
		return "User No." + getGeneratedId() + ": " + name + " " + surname + ", " + username;
	}
	
	public boolean login(String inputPassword){
		if (inputPassword == encodedPassword) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void followPage(Page page){
		page.followers.add(this);
	}
	
}
