package model;

import java.time.LocalDateTime;

public class Post {
	private String msg;
	private LocalDateTime date;
	private int countOfLikes;
	
	public Post() {
		setMsg(" ");
		setDate(LocalDateTime.now());
		setCountOfLikes(0);
	}
	
	public Post(String msg) {
		setMsg(msg);
		setDate(LocalDateTime.now());
		setCountOfLikes(0);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getCountOfLikes() {
		return countOfLikes;
	}

	public void setCountOfLikes(int countOfLikes) {
		this.countOfLikes = countOfLikes;
	}
	
	public String toString() {
		return msg + ", " + date + ", " + countOfLikes;
	}
}
