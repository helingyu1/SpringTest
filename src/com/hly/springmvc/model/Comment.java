package com.hly.springmvc.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;


@Repository
public class Comment {
	private String content;     //评论内容
	private Timestamp time;		//评论时间
	private int b_id;			//所属微博id
	private String nick;		//评论人昵称
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public String toString(){
		return "评论时间："+this.time+",评论人："+this.nick+",评论内容："+this.content;
	}
}
