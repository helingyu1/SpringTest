package com.hly.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class Test {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	public void test(){
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		
		//String u_nick = "u_nick";
		String sql = "select * from user_info where u_nick=u_nick";
		
		System.out.println("11111111");
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
		System.out.println("-$$$$$$$$$$$$$$$$$$$$sql:"+sql);
		System.out.println("-$$$$$$$$$$$$$$$$$$$$≤‚ ‘¥Û–°£∫"+list.size());
	}
}
