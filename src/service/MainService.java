package service;

import java.util.ArrayList;
import java.util.Collection;

import model.Page;
import model.Post;
import model.PostType;
import model.users.BusinessUser;
import model.users.GuestUser;
import model.users.PrivateUser;
import model.users.User;

public class MainService {
	public static ArrayList<User> allRegisteredUsers = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			GuestUser guest1 = new GuestUser();
			GuestUser guest2 = new GuestUser();
			PrivateUser private1 = new PrivateUser("janisa", "Jānis", "Ābols", "parole1");
			allRegisteredUsers.add(private1);
			PrivateUser private2 = new PrivateUser("karlisb", "Kārlis", "Baigais", "parole2");
			allRegisteredUsers.add(private2);
			BusinessUser business1 = new BusinessUser("andrisl", "Andris", "Lielais", "parole11");
			allRegisteredUsers.add(business1);
			BusinessUser business2 = new BusinessUser("alfredss", "Alfrēds", "Sirmais", "parole22");
			allRegisteredUsers.add(business2);
			
			private1.createPost(new Post("Publiskā ziņa"), PostType.publicPost);
			private1.createPost(new Post("Privātā ziņa"), PostType.privatePost);
			
			private2.createPost(new Post("Otrā publiskā ziņa"), PostType.publicPost);
			private2.createPost(new Post("Otrā privātā ziņa"), PostType.privatePost);
			
			Page swedbankVentspils = new Page("Swedbank", "Lapa ziņām un jaunumiem no Swedbank Ventspils");
			Page swedbankLiepaja = new Page("Swedbank", "Lapa ziņām un jaunumiem no Swedbank Liepāja");
			business1.addPage(swedbankVentspils);
			business1.addPage(swedbankLiepaja);
			business1.createPostInPage(swedbankVentspils, new Post("Kredīti par brīvu"));
			business1.createPostInPage(swedbankVentspils, new Post("Sāc savu pensiju plānu!"));
			business1.createPostInPage(swedbankLiepaja, new Post("Te ari kredīti par brīvu!"));
			
			private1.followPage(swedbankVentspils);
			
			System.out.println(guest1);
			System.out.println(guest2);
	
			System.out.println(business2);
			System.out.println(business1.getAllPages().get(0));
			
			for(Post temp: private1.getAllPublicPosts()) {
				System.out.println(temp);
			}
			
			business1.getAllPages().get(0).getPostsInPage().get(0).increaseLikes(private1);
			business1.getAllPages().get(0).getPostsInPage().get(0).increaseLikes(private1);
			business1.getAllPages().get(0).getPostsInPage().get(0).increaseLikes(private2);
			business1.getAllPages().get(0).getPostsInPage().get(0).increaseLikes(private2);
			
			for(Post temp: business1.getAllPages().get(0).getPostsInPage()) {
				System.out.println(temp);
			}
			
			System.out.println(private2.login());
			System.out.println(business1.login());
		
			private2.followPrivateUser(private1);
			
			System.out.println("private1 Followers: ");
			System.out.println(private2.getAllFolowers());
			
			System.out.println("-----Search-----");
			System.out.println("---Users---");
			System.out.println(private2.findUsersBySurnameOrUsername("Kārlis"));
			System.out.println("---Pages---");
			System.out.println(private2.findPagesByTitleOrDescripion("swedbank"));
			System.out.println("---Posts---");
			System.out.println(private2.findPublicPosts("kredīti"));
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
