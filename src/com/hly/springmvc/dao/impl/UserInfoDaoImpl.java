package com.hly.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hly.springmvc.dao.IUserInfoDao;
import com.hly.springmvc.model.User;

@Repository
public class UserInfoDaoImpl implements IUserInfoDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	Logger logger = Logger.getLogger(UserInfoDaoImpl.class);
	
	/**
	 * 向数据库中添加新用户
	 */
	@Override
	public String addUser(User user) {
		
		String ret = "true";
		String sql = "insert into user_info(u_name,u_pwd,u_email,u_phone,u_age,u_sex,u_nick)"+
		" values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{
				user.getU_name(),
				user.getU_pwd(),
				"default@qq.com",
				//user.getU_email(),
				"18210324754",
				//user.getU_phone(),
				25,
				//user.getU_age(),
				"男",
				user.getU_nick()
				//user.getU_sex()
		});
		return ret;
	}

	/**
	 * 验证用户登录
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,Object>> searchUser(String name) {
		String sql = "select u_name,u_nick,u_pwd from user_info where u_name=?";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, new Object[]{name});
		return list;
	}

	/**
	 * 查找用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Object> hasUser(String name,String type) {
		String sql;
		if("nick".equals(type))
			sql = "select * from user_info where u_nick=?";
		else
			sql = "select * from user_info where u_name=?";
		Map<String,Object> map = null;
		try{
			map = jdbcTemplate.queryForMap(sql, new Object[]{name});
		}catch(EmptyResultDataAccessException e){
			
		}
		return map;
	}
	
}
