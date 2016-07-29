package com.hly.springmvc.dao;

import java.util.List;
import java.util.Map;

import com.hly.springmvc.model.Blog;

public interface IBlogOptDao {

	/**
	 * �û�����΢��
	 */
	public String addBlog(Blog blog);
	/**
	 * ��ѯ��ע��΢��
	 */
	public List<Map<String,Object>> showBlog();
	
	public List<Blog> getBlogsByTime(List<Blog> blogs,String target,String time);
	
}
