package model;

public class Page {
	private String title;
	private String description;
	ArrayList<User> folowers;
	ArrayList<Post> postsInPage;
	
	public Page() {
		setTitle(" ");
		setDescription(" ");
	}
	
	public Page(String title, String description, ArrayList<User> folowers, ArrayList<Post> postsInPage) {
		setTitle(title);
		setDescription(description);
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
