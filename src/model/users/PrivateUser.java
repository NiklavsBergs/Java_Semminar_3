package model.users;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;

public class PrivateUser extends User{
	private ArrayList<Post> allPrivatePosts = new ArrayList<>();
	private ArrayList<Post> allPublicPosts = new ArrayList<>();
	private ArrayList<PrivateUser> followers = new ArrayList<>();
	
	public PrivateUser() {
		super();
	}
	
	public PrivateUser(String username, String name, String surname, String password) {
		super(username, name, surname, password);
	}
	
	public void followPrivateUser(PrivateUser user) {
		followers.add(user);
	}

	@Override
	public Post createPost(Post post, PostType type) {
		if(type.equals(PostType.privatePost) && !allPrivatePosts.contains(post)) {
			allPrivatePosts.add(post);
			return post;
		}
		else if (type.equals(PostType.publicPost)) {
			allPublicPosts.add(post);
			return post;
		}
		return null;
	}
	
	public ArrayList<Post> getAllPublicPosts() {
		return allPublicPosts;
	}
	
	public ArrayList<PrivateUser> getAllFolowers() {
		return followers;
	}
	
	//TODO add/remove follower
}
