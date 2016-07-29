package com.hly.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hly.springmvc.dao.ITimeLineDao;

@Repository
public class ITimelineDaoImpl implements ITimeLineDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> searchBlogs() {
		String sql = "select * from blog_info";
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}
	
}
