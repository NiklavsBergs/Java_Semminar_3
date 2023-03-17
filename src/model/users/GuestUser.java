package model.users;

public class GuestUser {
	private int generatedId;
	
	private int idCounter = 0;
	
	public GuestUser() {
		setGeneratedId();
	}

	public int getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId() {
		generatedId = idCounter;
		idCounter++;
	}
}
