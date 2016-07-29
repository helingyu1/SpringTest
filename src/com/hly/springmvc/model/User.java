package com.hly.springmvc.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * �û�ʵ��bean
 * 
 * 
 * @author helingyu
 *
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	
	private int u_id;			//�û�id
	private String u_name;		//�û���
	private String u_pwd;		//�û�����
	private String u_nick;		//�û��ǳ�
	private int u_age;			//�û�����
	private String u_sex;		//�û��Ա�
	private String u_email;		//�û�����
	private String u_phone;		//�û��ֻ�
	
	public User(){
		
	}
	public User(String nick){
		this.u_nick = nick;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int u_age) {
		this.u_age = u_age;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_nick() {
		return u_nick;
	}
	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}
	
}
