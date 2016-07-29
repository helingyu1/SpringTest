package com.hly.springmvc.dao;

import java.util.List;
import java.util.Map;

import com.hly.springmvc.model.User;

public interface IFollowInfoDao {
	
	/**
	 * ��ӹ�ע
	 */
	public String addFocus(String username,User target);
	/**
	 * ȡ����ע
	 */
	public String deleteFocus(String username,User target);
	/**
	 * �鿴��ע�б�
	 */
	public List<Map<String,Object>> searchFocus(String username);
	/**
	 * �鿴��ע�б�(�������ǳ�)
	 * @param nick
	 * @return
	 */
	public List<Map<String,Object>> searchFocusForNames(String username);
	/**
	 * �鿴��˿�б�
	 */
	public List<Map<String,Object>> searchFans(String username);
}
