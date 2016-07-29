package com.hly.springmvc.dao.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hly.springmvc.dao.ICommentOptDao;
import com.hly.springmvc.utils.DateUtils;


@Repository
public class CommentOptImpl implements ICommentOptDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public int insertCmt(String comment,int b_id, String nick) {
		String sql = "insert into comment_info (content,time,b_id,u_nick) values(?,?,?,?)";
		Timestamp time = DateUtils.dateToTimestamp(new Date());
		jdbcTemplate.update(sql, new Object[]{comment,time,b_id,nick});
		return 0;
	}

}
