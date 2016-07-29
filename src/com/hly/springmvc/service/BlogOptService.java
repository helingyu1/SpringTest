package com.hly.springmvc.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hly.springmvc.dao.impl.BlogOptDaoImpl;
import com.hly.springmvc.model.Blog;

@Service
public class BlogOptService {
	
	Logger logger = Logger.getLogger(BlogOptService.class);
	
	@Autowired
	BlogOptDaoImpl blogDaoImpl;
	
	/**
	 * 发布新微博
	 * @param blog
	 * @return
	 */
	public String publishBlog(Blog blog){
		logger.debug("开始发布新微博-------------------------");
		String ret = "true";
		ret = blogDaoImpl.addBlog(blog);
		logger.debug("完成发布新微博-------------------------");
		return ret;
	}
	/**
	 * 刷新关注人微博
	 * @return
	 */
	public List<Blog> showFocusBlogs(){
		logger.debug("开始更新微博首页--------------------------");
		List<Blog> rtnList = new ArrayList<Blog>();
		List<Map<String,Object>> list = blogDaoImpl.showBlog();
		for(Map<String,Object> per : list){
			Blog blog = new Blog();
			blog.setB_id((Integer)per.get("ID"));
			blog.setB_content((String)per.get("content"));
			blog.setB_comment((Integer)per.get("comment"));
			//blog.setB_isTurn((Integer)per.get("isTurn"));//暂时不用
			blog.setB_keep((Integer)per.get("keep"));
			blog.setB_time((String)per.get("time"));
			blog.setB_turn((Integer)per.get("turn"));
			blog.setB_uname((String)per.get("Uname"));
			rtnList.add(blog);
		}
		Collections.sort(rtnList);
		System.out.println(rtnList.size());
		logger.debug("微博首页更新完毕--------------------------");
		return rtnList;
		
	}
}
