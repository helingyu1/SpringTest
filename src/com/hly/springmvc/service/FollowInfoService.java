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
	 * �û�����¹�ע
	 * 	 
	 */
	public String addFocus(String username,User target){
		logger.debug("��ʼ����¹�ע---------------------------");
		String ret = "true";
		followInfoDaoImpl.addFocus(username, target);
		logger.debug("�¹�ע������---------------------------");
		return ret;
	}
	/**
	 * �û��鿴��ע�б�
	 * @param username ����������û��ǳ�
	 *  
	 */
	public List<User> searchFocus(String username){
		List<User> rtnList = new ArrayList<User>();
		logger.debug("��ʼ���������û���ע�б�-------------------");
		List<Map<String,Object>> list = followInfoDaoImpl.searchFocus(username);
		for(Map<String,Object> per : list){
			User user = new User();
			user.setU_nick((String)per.get("target"));
			rtnList.add(user);
		}		
		return rtnList;
	}
	/**
	 * �û��鿴��˿�б�
	 */
	public List<User> searchFans(String username){
		logger.debug("��ʼ���������û���˿�б�-------------------");
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
			logger.debug("��ʼ���������û���˿�б�(ֻ�����ǳ�)-------------------");
			List<String> rtnList = new ArrayList<String>();
			List<Map<String,Object>> list = followInfoDaoImpl.searchFans(username);
			for(Map<String,Object> per : list){
				rtnList.add((String)per.get("fans"));
			}
			return rtnList;
	}
}
