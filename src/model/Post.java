package model;

import java.time.LocalDateTime;

public class Post {
	private String msg;
	private LocalDateTime date;
	private int countOfLikes;
	
	public Post() {
		setMsg(" ");
		setDate();
		countOfLikes = 0;
	}
	
	public Post(String msg) {
		setMsg(msg);
		setDate();
		countOfLikes = 0;
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
		return countOfLikes;
	}

	public void likePost() {
		countOfLikes++;
	}
	
	public String toString() {
		return msg + ", " + date + ", " + countOfLikes;
	}
}
