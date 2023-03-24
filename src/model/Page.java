package model;

import java.util.ArrayList;

import model.users.User;

public class Page {
	private String title;
	private String description;
	public ArrayList<User> followers;
	public ArrayList<Post> postsInPage;
	
	public Page() {
		setTitle(" ");
		setDescription(" ");
		ArrayList<User> followers = new ArrayList<User>();
		ArrayList<Post> postsInPage  = new ArrayList<Post>();
	}
	
	public Page(String title, String description) {
		setTitle(title);
		setDescription(description);
		ArrayList<User> followers = new ArrayList<User>();
		ArrayList<Post> postsInPage  = new ArrayList<Post>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return title + ", " + description;
	}
	
}
