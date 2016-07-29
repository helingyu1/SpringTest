package com.hly.springmvc.service;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hly.springmvc.dao.impl.CommentOptImpl;

/**
 * 微博评论操作
 * @author helingyu
 *
 */
@Service
public class CommentOptService {

	Logger logger = Logger.getLogger(CommentOptService.class);
	@Autowired
	CommentOptImpl cmtDao;
	public void publishCmt(String comment,int b_id,String nick){
		logger.debug("开始发布评论~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		cmtDao.insertCmt(comment,b_id, nick);
		logger.debug("评论发布完毕~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
