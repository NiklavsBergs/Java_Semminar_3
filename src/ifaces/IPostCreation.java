package ifaces;

import model.Post;

public interface IPostCreation {
	public static void createPost(String msg){
		Post post = new Post(msg);
	}
}
