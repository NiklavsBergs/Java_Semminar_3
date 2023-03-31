package model.users;

import java.security.MessageDigest;

import model.Page;
import model.Post;
import model.PostType;
import service.MainService;

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
		if (username != null && username.matches("[a-z0-9.]{4,20}")) {
			this.username = username;
		}
		else {
			this.username = "Default.username";
		}
		
	}

	public String getPassword() {
		return encodedPassword;
	}

	public void setPassword(String inputPassword) {
		if (inputPassword != null && inputPassword.matches("[A-Za-z0-9]{8,20}")) {
			try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(inputPassword.getBytes());
			encodedPassword = new String(md.digest());
			}
			catch(Exception e) {
				encodedPassword = "defaultpassword";
			}
		}
		else {
			encodedPassword = "defaultpassword";
		}
	}
	public String toString() {
		return "User No." + getGeneratedId() + ": " + name + " " + surname + ", " + username;
	}
	
	public boolean login(){
		for(User temp: MainService.allRegisteredUsers) {
			if(temp.getUsername().equals(username) && temp.getPassword().equals(encodedPassword)) {
				return true;
			}
		}
		return false;
	}
	
	public void followPage(Page page) throws Exception{
		if(page == null) {
			throw (new Exception("Page not found"));
		}
		else {
			page.addFollower(this);
		}
	}
	
	public void unfollowPage(Page page) throws Exception{
		if(page == null) {
			throw (new Exception("Page not found"));
		}
		else {
			page.removeFollower(this);
		}
	}
	
	public abstract Post createPost(Post post, PostType type);
	
}
