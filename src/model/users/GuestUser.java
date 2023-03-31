package model.users;

import java.util.ArrayList;

import model.Page;
import model.Post;
import service.MainService;

public class GuestUser {
	private long generatedId;
	
	private static long idCounter = 0;
	
	public GuestUser() {
		setGeneratedId();
	}

	public long getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId() {
		generatedId = idCounter;
		idCounter++;
	}
	
	public String toString() {
		return "Guest User Nr. " + generatedId;
	}
	
	public ArrayList<User> findUsersBySurnameOrUsername(String input) {
		ArrayList<User> result = new ArrayList<>();
		
		for(User user: MainService.allRegisteredUsers) {
		
			if(user.getName().contains(input) || user.getSurname().contains(input) || user.getUsername().contains(input)) {
				result.add(user);
			}
		}
		return result;
	}
	
	public ArrayList<Page> findPagesByTitleOrDescripion(String input){
		ArrayList<Page> result = new ArrayList<>();
		
		for(User user: MainService.allRegisteredUsers) {
			
			if(user instanceof BusinessUser) {
				BusinessUser buser = (BusinessUser) user;
				for(Page page: buser.getAllPages()) {
					if(page.getTitle().toLowerCase().contains(input) || page.getDescription().toLowerCase().contains(input)){
						result.add(page);
					}
				}
			}
		}
		
		return result;
	}
	
	public ArrayList<Post> findPublicPosts(String input){
		ArrayList<Post> result = new ArrayList<>();
		
		for(User user: MainService.allRegisteredUsers) {
					
					if(user instanceof BusinessUser) {
						BusinessUser buser = (BusinessUser) user;
						for(Page page: buser.getAllPages()) {
							for(Post post: page.getPostsInPage())
							if(post.getMsg().toLowerCase().contains(input)){
								result.add(post);
							}
						}
					}
					
					if(user instanceof PrivateUser) {
						PrivateUser puser = (PrivateUser) user;
						for(Post post: puser.getAllPublicPosts())
							if(post.getMsg().toLowerCase().contains(input)){
								result.add(post);
							}
					}
				}
				
		return result;
	}
}
