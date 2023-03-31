package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.users.User;

public class Post {
	private String msg;
	private LocalDateTime date;
	private ArrayList<User> usersLiked = new ArrayList<User>();
	
	public Post() {
		setMsg(" ");
		setDate();
	}
	
	public Post(String msg) {
		setMsg(msg);
		setDate();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		if(msg != null && msg.length() > 0) {
			this.msg = msg;
		}
		else {
			msg = "----";
		}
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate() {
		this.date = LocalDateTime.now();
	}

	public int getCountOfLikes() {
		return usersLiked.size();
	}

	public void increaseLikes(User user) {
		if(!usersLiked.contains(user)) {
			usersLiked.add(user);
		}
	}
	
	public String toString() {
		return msg + ", " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm")) + ", (" + getCountOfLikes() + ")";
	}
}
