package com.hly.springmvc.dao;

import java.sql.Timestamp;

import com.hly.springmvc.model.Comment;

public interface ICommentOptDao {
	/**
	 * 插入新评论
	 * @param comment 评论内容
	 * @param time 评论时间
	 * @param b_id 所属微博id
	 * @param nick 评论人昵称
	 * @return
	 */
	public int insertCmt(String comment,int b_id,String nick);
}
