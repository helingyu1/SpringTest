package com.hly.springmvc.dao;

import java.util.List;
import java.util.Map;

import com.hly.springmvc.model.User;

public interface IUserInfoDao {

	public String addUser(User user);
	
	public List<Map<String,Object>> searchUser(String name); 
	
	public Map<String,Object> hasUser(String name,String type);
	
}
