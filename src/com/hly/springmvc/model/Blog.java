package com.hly.springmvc.model;

/**
 * ΢��ʵ����
 * @author helingyu
 *
 */
public class Blog implements Comparable<Blog>{
	private int b_id;				//΢��id
	private String b_content;		//΢������
	private int b_isTurn;			//�Ƿ�Ϊת�� 0��1��
	private String b_time;		//����ʱ��
	private int b_turn;				//ת������
	private int b_keep;				//�ղش���
	private int b_comment;			//���۴���
	private String b_uname;			//�����û�id
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
