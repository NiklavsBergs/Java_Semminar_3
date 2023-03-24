package model.users;

import java.util.ArrayList;

import model.Post;

public class PrivateUser extends User{
	private ArrayList<Post> privatePosts;
	private ArrayList<Post> publicPosts;
	private ArrayList<User> followers;
	
	public PrivateUser() {
		super();
		ArrayList<Post> privatePosts = new ArrayList<Post>();
		ArrayList<Post> publicPosts = new ArrayList<Post>();
		ArrayList<User> followers = new ArrayList<User>();
	}
	
	public PrivateUser(String username, String name, String surname, String password) {
		super(username, name, surname, password);
		ArrayList<Post> privatePosts = new ArrayList<Post>();
		ArrayList<Post> publicPosts = new ArrayList<Post>();
		ArrayList<User> followers = new ArrayList<User>();
	}
	
	public void followPrivateUser(User user) {
		followers.add(user);
	}
}
