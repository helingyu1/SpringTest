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
	
	//添加新用户
	public OptionResult addUser(User user){
		OptionResult ret = new OptionResult();
		logger.debug("开始添加新用户 --------------------------------");
		String rtn = userInfoDao.addUser(user);
		if("true".equals(rtn)){
			ret.setCode("0000");
			ret.setMsg(user.getU_nick());
		}else{
			ret.setCode("0001");
			ret.setMsg(rtn);
		}
		logger.debug("添加新用户成功---------------------------------");
		return ret;
	}
	
	/**
	 * 
	 * @param user
	 * @return 成功返回昵称，失败返回提示信息
	 */
	@SuppressWarnings("unchecked")
	public OptionResult validateUser(User user){
		OptionResult ret = new OptionResult();
		logger.debug("开始验证用户登录信息---------------------------------");
		List<Map<String,Object>> list = userInfoDao.searchUser(user.getU_name());
		if(list.size()==0){
			logger.debug("该用户名不存在，请核对。");
			ret.setCode("0001");
			ret.setMsg("该用户名不存在，请核对。");
		}else{
			if(!user.getU_pwd().equals(list.get(0).get("u_pwd"))){
				logger.debug("密码不正确，请用户核对！");
				ret.setCode("0002");
				ret.setMsg("密码不正确，请用户核对！");
				
			}else{
				ret.setCode("0000");
				ret.setMsg((String)list.get(0).get("u_name"));
			}
		}
		logger.debug("验证用户结束---------------------------------");
		return ret;
	}
	//查找微博用户by nickname
	public User getUserByNick(String nick){
		logger.debug("开始根据【昵称】查找用户-------------------------------------");
		User user = new User();
		Map<String,Object> map = userInfoDao.hasUser(nick,"nick");
		if(map==null || map.size()==0){
			logger.debug("该用户不存在");
			return null;
		}else{
			logger.debug("查找到该用户，正在组装用户信息------------------------");
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
		logger.debug("开始根据【用户名】查找用户-------------------------------------");
		User user = new User();
		Map<String,Object> map = userInfoDao.hasUser(name,"name");
		if(map==null || map.size()==0){
			logger.debug("该用户不存在");
			return null;
		}else{
			logger.debug("查找到该用户，正在组装用户信息------------------------");
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
