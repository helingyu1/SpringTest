package com.hly.springmvc.dao;

import java.util.List;
import java.util.Map;

import com.hly.springmvc.model.Blog;

public interface IBlogOptDao {

	/**
	 * 用户发布微博
	 */
	public String addBlog(Blog blog);
	/**
	 * 查询关注人微博
	 */
	public List<Map<String,Object>> showBlog();
	
	public List<Blog> getBlogsByTime(List<Blog> blogs,String target,String time);
	
}
