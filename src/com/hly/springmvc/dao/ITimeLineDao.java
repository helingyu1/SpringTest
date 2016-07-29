package com.hly.springmvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface ITimeLineDao {
	public List<Map<String,Object>> searchBlogs();
}
