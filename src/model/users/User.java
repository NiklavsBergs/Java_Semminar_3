package model.users;

import model.Page;

public abstract class User extends GuestUser{
	String nameAndSurname;
	String username;
	String password;
	
	public User() {
		super();
		setNameAndSurname("Unknown");
		setUsername("Unknown");
		setPassword("Password");
	}
	
	public User(String nameAndSurname, String username, String password) {
		super();
		setNameAndSurname(nameAndSurname);
		setUsername(username);
		setPassword(password);
	}

	public String getNameAndSurname() {
		return nameAndSurname;
	}

	public void setNameAndSurname(String nameAndSurname) {
		this.nameAndSurname = nameAndSurname;
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
	public String toString() {
		return nameAndSurname + ", " + username;
	}
	
	public boolean login(String inputPassword){
		if (inputPassword == password) {
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
