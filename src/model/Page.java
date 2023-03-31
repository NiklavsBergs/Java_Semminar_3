package model;

import java.util.ArrayList;

import model.users.User;

public class Page {
	private String title;
	private String description;
	public ArrayList<User> followers = new ArrayList<User>();
	public ArrayList<Post> postsInPage = new ArrayList<Post>();
	
	public Page() {
		setTitle("--TITLE--");
		setDescription("--DESC--");
	}
	
	public Page(String title, String description) {
		setTitle(title);
		setDescription(description);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null && title.length() > 0 && title.length() < 30) {
			this.title = title;
		}
		else {
			this.title = "--TITLE--";
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description != null && description.length() > 0 && title.length() < 300) {
			this.description = description;
		}
		else {
			this.description = "--DESC--";
		}
	}
	
	public void addFollower(User follower) {
		if(follower !=null && !followers.contains(follower)) {
			followers.add(follower);
		}
	}
	
	public void removeFollower(User follower) {
		if(follower !=null && followers.contains(follower)) {
			followers.remove(follower);
		}
	}
	
	public void addPost(Post post) {
		if(post != null) {
			postsInPage.add(post);
		}
	}
	
	public void removePost(Post post) {
		if(post != null && postsInPage.contains(post)) {
			postsInPage.remove(post);
		}
	}

	public ArrayList<User> getFollowers() {
		return followers;
	}

	public ArrayList<Post> getPostsInPage() {
		return postsInPage;
	}

	public String toString() {
		return title + ", " + description + " " + postsInPage + " " + followers.size() + " Followers" + "\n";
	}
}
