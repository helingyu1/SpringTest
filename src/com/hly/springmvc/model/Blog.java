package com.hly.springmvc.model;

/**
 * 微博实体类
 * @author helingyu
 *
 */
public class Blog implements Comparable<Blog>{
	private int b_id;				//微博id
	private String b_content;		//微博内容
	private int b_isTurn;			//是否为转发 0否1是
	private String b_time;		//发布时间
	private int b_turn;				//转发次数
	private int b_keep;				//收藏次数
	private int b_comment;			//评论次数
	private String b_uname;			//所属用户id
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_isTurn() {
		return b_isTurn;
	}
	public void setB_isTurn(int b_isTurn) {
		this.b_isTurn = b_isTurn;
	}
	public String getB_time() {
		return b_time;
	}
	public void setB_time(String b_time) {
		this.b_time = b_time;
	}
	public int getB_turn() {
		return b_turn;
	}
	public void setB_turn(int b_turn) {
		this.b_turn = b_turn;
	}
	public int getB_keep() {
		return b_keep;
	}
	public void setB_keep(int b_keep) {
		this.b_keep = b_keep;
	}
	public int getB_comment() {
		return b_comment;
	}
	public void setB_comment(int b_comment) {
		this.b_comment = b_comment;
	}
	public String getB_uname() {
		return b_uname;
	}
	public void setB_uname(String b_uname){
		this.b_uname = b_uname;
	}
	@Override
	public int compareTo(Blog b) {
		String date1 = this.b_time;
		String date2 = b.getB_time();
		return date1.compareTo(date2);
	}
	
}
