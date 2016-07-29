package com.hly.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import nl.justobjects.pushlet.util.Sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hly.springmvc.dao.IFollowInfoDao;
import com.hly.springmvc.model.User;

@Repository

public class FollowInfoDaoImpl implements IFollowInfoDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 添加关注
	 * @param username 关注人
	 * @param target 被关注人
	 */
	@Override
	public String addFocus(String username, User target) {
		String ret = "true";
		String sql = "insert into follow_info (target,fans) values(?,?)";
		jdbcTemplate.update(sql, new Object[]{target.getU_nick(),username});
		return ret;
	}
	
	//取消关注
	@Override
	public String deleteFocus(String username, User target) {
		String ret = "true";
		String sql = "delete from follow_info(target,fans) values(?,?)";
		jdbcTemplate.update(sql, new Object[]{target.getU_nick(),username});
		return ret;
	}

	//查看关注列表
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,Object>> searchFocus(String username) {
		List<Map<String,Object>> list = null;
		String sql = "select * from follow_info where fans=?";
		list = jdbcTemplate.queryForList(sql, new Object[]{username});
		System.out.println("一共关注了多少人：：：：：："+list.size());
		return list;
	}

	/**
	 * 查询用户粉丝列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,Object>> searchFans(String username) {
		List<Map<String,Object>> list = null;
		String sql = "select * from follow_info where target=?";
		list = jdbcTemplate.queryForList(sql, new Object[]{username});
		System.out.println("一共有多少人关注我：：：：：：："+list.size());
		return list;
	}
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchFocusForNames(String username){
		List<Map<String,Object>> list = null;
		System.out.println(username);
		String sql = "select target from follow_info where fans=?";
		list = jdbcTemplate.queryForList(sql,new Object[]{username});
		System.out.println("查出了："+list.size()+"个人");
		return list;
	}

}
