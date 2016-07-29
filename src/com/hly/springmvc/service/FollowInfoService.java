package com.hly.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hly.springmvc.dao.impl.FollowInfoDaoImpl;
import com.hly.springmvc.model.User;

@Service
public class FollowInfoService {
	@Autowired
	FollowInfoDaoImpl followInfoDaoImpl;
	
	Logger logger = Logger.getLogger(FollowInfoService.class);
	
	/**
	 * 用户添加新关注
	 * 	 
	 */
	public String addFocus(String username,User target){
		logger.debug("开始添加新关注---------------------------");
		String ret = "true";
		followInfoDaoImpl.addFocus(username, target);
		logger.debug("新关注添加完成---------------------------");
		return ret;
	}
	/**
	 * 用户查看关注列表
	 * @param username 发出请求的用户昵称
	 *  
	 */
	public List<User> searchFocus(String username){
		List<User> rtnList = new ArrayList<User>();
		logger.debug("开始处理：搜索用户关注列表-------------------");
		List<Map<String,Object>> list = followInfoDaoImpl.searchFocus(username);
		for(Map<String,Object> per : list){
			User user = new User();
			user.setU_nick((String)per.get("target"));
			rtnList.add(user);
		}		
		return rtnList;
	}
	/**
	 * 用户查看粉丝列表
	 */
	public List<User> searchFans(String username){
		logger.debug("开始处理：搜索用户粉丝列表-------------------");
		List<User> rtnList = new ArrayList<User>();
		List<Map<String,Object>> list = followInfoDaoImpl.searchFans(username);
		for(Map<String,Object> per : list){
			User user = new User();
			user.setU_nick((String)per.get("fans"));
			rtnList.add(user);
		}
		return rtnList;
	}
		public List<String> searchFansNames(String username){
			logger.debug("开始处理：搜索用户粉丝列表(只返回昵称)-------------------");
			List<String> rtnList = new ArrayList<String>();
			List<Map<String,Object>> list = followInfoDaoImpl.searchFans(username);
			for(Map<String,Object> per : list){
				rtnList.add((String)per.get("fans"));
			}
			return rtnList;
	}
}
