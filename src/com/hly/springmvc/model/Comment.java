package com.hly.springmvc.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;


@Repository
public class Comment {
	private String content;     //��������
	private Timestamp time;		//����ʱ��
	private int b_id;			//����΢��id
	private String nick;		//�������ǳ�
	
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
		return "����ʱ�䣺"+this.time+",�����ˣ�"+this.nick+",�������ݣ�"+this.content;
	}
}
