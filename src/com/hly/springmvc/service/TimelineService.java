package com.hly.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hly.springmvc.dao.IBlogOptDao;
import com.hly.springmvc.dao.IFollowInfoDao;
import com.hly.springmvc.model.Blog;

@Service
public class TimelineService {
	@Autowired
	IBlogOptDao blogDao;
	@Autowired
	IFollowInfoDao followDao;
	
	Logger logger = Logger.getLogger(TimelineService.class);
	
	public List<Blog> getFeeds(String username){
		List<Blog> ret = new ArrayList<Blog>();
		//1.第一步先查出关注人列表
		List<Map<String,Object>> userList = followDao.searchFocusForNames(username);
		//2.第二步查出所有关注人的feed
		for(int i=0;i<userList.size();i++){
			String temp = (String)userList.get(i).get("target");
			ret = blogDao.getBlogsByTime(ret, temp, "");
		}
		//3.对所有feed进行排序返回	
		
		return ret;		
	}
}
