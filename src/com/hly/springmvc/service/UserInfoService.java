package com.hly.springmvc.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hly.springmvc.dao.impl.UserInfoDaoImpl;
import com.hly.springmvc.model.OptionResult;
import com.hly.springmvc.model.User;

@Service
public class UserInfoService {
	
	@Autowired
	UserInfoDaoImpl userInfoDao;
	Logger logger = Logger.getLogger(UserInfoService.class);
	
	//������û�
	public OptionResult addUser(User user){
		OptionResult ret = new OptionResult();
		logger.debug("��ʼ������û� --------------------------------");
		String rtn = userInfoDao.addUser(user);
		if("true".equals(rtn)){
			ret.setCode("0000");
			ret.setMsg(user.getU_nick());
		}else{
			ret.setCode("0001");
			ret.setMsg(rtn);
		}
		logger.debug("������û��ɹ�---------------------------------");
		return ret;
	}
	
	/**
	 * 
	 * @param user
	 * @return �ɹ������ǳƣ�ʧ�ܷ�����ʾ��Ϣ
	 */
	@SuppressWarnings("unchecked")
	public OptionResult validateUser(User user){
		OptionResult ret = new OptionResult();
		logger.debug("��ʼ��֤�û���¼��Ϣ---------------------------------");
		List<Map<String,Object>> list = userInfoDao.searchUser(user.getU_name());
		if(list.size()==0){
			logger.debug("���û��������ڣ���˶ԡ�");
			ret.setCode("0001");
			ret.setMsg("���û��������ڣ���˶ԡ�");
		}else{
			if(!user.getU_pwd().equals(list.get(0).get("u_pwd"))){
				logger.debug("���벻��ȷ�����û��˶ԣ�");
				ret.setCode("0002");
				ret.setMsg("���벻��ȷ�����û��˶ԣ�");
				
			}else{
				ret.setCode("0000");
				ret.setMsg((String)list.get(0).get("u_name"));
			}
		}
		logger.debug("��֤�û�����---------------------------------");
		return ret;
	}
	//����΢���û�by nickname
	public User getUserByNick(String nick){
		logger.debug("��ʼ���ݡ��ǳơ������û�-------------------------------------");
		User user = new User();
		Map<String,Object> map = userInfoDao.hasUser(nick,"nick");
		if(map==null || map.size()==0){
			logger.debug("���û�������");
			return null;
		}else{
			logger.debug("���ҵ����û���������װ�û���Ϣ------------------------");
			user.setU_age((Integer)map.get("u_age"));
			user.setU_email((String)map.get("u_email"));
			user.setU_sex((String)map.get("u_sex"));
			user.setU_phone((String)map.get("u_phone"));
			user.setU_name((String)map.get("u_name"));
			user.setU_nick((String)map.get("u_nick"));
			return user;
		}
	}
	public User getUserByName(String name){
		logger.debug("��ʼ���ݡ��û����������û�-------------------------------------");
		User user = new User();
		Map<String,Object> map = userInfoDao.hasUser(name,"name");
		if(map==null || map.size()==0){
			logger.debug("���û�������");
			return null;
		}else{
			logger.debug("���ҵ����û���������װ�û���Ϣ------------------------");
			user.setU_age((Integer)map.get("u_age"));
			user.setU_email((String)map.get("u_email"));
			user.setU_sex((String)map.get("u_sex"));
			user.setU_phone((String)map.get("u_phone"));
			user.setU_name((String)map.get("u_name"));
			user.setU_nick((String)map.get("u_nick"));
			return user;
		}
	}
}
