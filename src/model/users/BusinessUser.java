package model.users;

import java.util.ArrayList;

import model.Page;

public class BusinessUser extends User{
	private ArrayList<Page> listOfPages;
	
	BusinessUser(){
		super();
		ArrayList<Page> listOfPages = new ArrayList<Page>();
	}
	
	BusinessUser(String nameAndSurname, String username, String password){
		super(nameAndSurname, username, password);
		ArrayList<Page> listOfPages = new ArrayList<Page>();
	}
	
	public void createPage(String title, String description) {
		listOfPages.add(new Page(title, description));
	}
	
	public String toString() {
		return "" + super.toString();
	}
}
