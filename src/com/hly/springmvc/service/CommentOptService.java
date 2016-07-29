package com.hly.springmvc.service;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hly.springmvc.dao.impl.CommentOptImpl;

/**
 * ΢�����۲���
 * @author helingyu
 *
 */
@Service
public class CommentOptService {

	Logger logger = Logger.getLogger(CommentOptService.class);
	@Autowired
	CommentOptImpl cmtDao;
	public void publishCmt(String comment,int b_id,String nick){
		logger.debug("��ʼ��������~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		cmtDao.insertCmt(comment,b_id, nick);
		logger.debug("���۷������~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
