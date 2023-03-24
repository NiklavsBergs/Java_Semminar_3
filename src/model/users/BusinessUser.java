package model.users;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;

public class BusinessUser extends User{
	private ArrayList<Page> allPages = new ArrayList<Page>();
	
	BusinessUser(){
		super();
	}
	
	BusinessUser(String username, String name, String surname,  String password){
		super(username, name, surname, password);
	}
	
	public void addPage(Page page) {
		if(page!=null && !allPages.contains(page)) {
			allPages.add(page);
		}
	}
	
	public void removePage(Page page) {
		if(page!=null && allPages.contains(page)) {
			allPages.remove(page);
		}
	}
	
	public String toString() {
		return "" + super.toString();
	}

	@Override
	public Post createPost(Post post, PostType type) {
		if(post != null) {
			return post;
		}
		else {
			return new Post ();
		}
	}

	public ArrayList<Page> getAllPages() {
		return allPages;
	}
	
	public void createPostInPage(Page page, Post post) {
		if(page != null && post != null && !page.getPostsInPage().contains(post)) {
			page.getPostsInPage().add(post);
		}
	}
	
}
