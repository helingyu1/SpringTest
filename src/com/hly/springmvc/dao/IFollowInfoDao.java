package com.hly.springmvc.dao;

import java.util.List;
import java.util.Map;

import com.hly.springmvc.model.User;

public interface IFollowInfoDao {
	
	/**
	 * 添加关注
	 */
	public String addFocus(String username,User target);
	/**
	 * 取消关注
	 */
	public String deleteFocus(String username,User target);
	/**
	 * 查看关注列表
	 */
	public List<Map<String,Object>> searchFocus(String username);
	/**
	 * 查看关注列表(仅返回昵称)
	 * @param nick
	 * @return
	 */
	public List<Map<String,Object>> searchFocusForNames(String username);
	/**
	 * 查看粉丝列表
	 */
	public List<Map<String,Object>> searchFans(String username);
}
