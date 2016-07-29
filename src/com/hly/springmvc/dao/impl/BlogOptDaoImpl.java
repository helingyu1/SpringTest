package com.hly.springmvc.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hly.springmvc.dao.IBlogOptDao;
import com.hly.springmvc.model.Blog;
import com.hly.springmvc.utils.DateUtils;

@Repository
public class BlogOptDaoImpl implements IBlogOptDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	//将新微博添加到数据库
	@Override
	public String addBlog(Blog blog) {
		String sql = "insert into blog_info(content,time,turn,uname)"+
					" values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{
				blog.getB_content(),
				DateUtils.dateToString(new Date()),
				0,
				blog.getB_uname()
		});
		return "true";
	}

	//
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> showBlog() {
		List<Map<String,Object>> rtnList = null;
		String sql = "select * from blog_info";
		rtnList = jdbcTemplate.queryForList(sql);
		return rtnList;
	}
	public List<Blog> getBlogsByTime(List<Blog> blogs,String target,String time){
		String sql = "select * from blog_info where Uname=? and time>?";
		System.out.println("target:"+target);
		List<Map<String,Object>> rtnList = jdbcTemplate.queryForList(sql, new Object[]{target,time});
		System.out.println("test size:"+rtnList.size());
		for(int i=0;i<rtnList.size();i++){
			Blog blog = new Blog();
			blog.setB_content((String)rtnList.get(i).get("content"));
			blog.setB_isTurn(1);
			blog.setB_time((String)rtnList.get(i).get("time"));
			blog.setB_turn((Integer)rtnList.get(i).get("turn"));
			blog.setB_keep((Integer)rtnList.get(i).get("keep"));
			blog.setB_comment((Integer)rtnList.get(i).get("comment"));
			blog.setB_uname((String)rtnList.get(i).get("Uname"));
			
			blogs.add(blog);
		}
		
		return blogs;
	}

}
