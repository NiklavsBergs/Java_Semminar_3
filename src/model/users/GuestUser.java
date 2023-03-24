package model.users;

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
	
}
