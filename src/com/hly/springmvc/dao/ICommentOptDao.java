package com.hly.springmvc.dao;

import java.sql.Timestamp;

import com.hly.springmvc.model.Comment;

public interface ICommentOptDao {
	/**
	 * ����������
	 * @param comment ��������
	 * @param time ����ʱ��
	 * @param b_id ����΢��id
	 * @param nick �������ǳ�
	 * @return
	 */
	public int insertCmt(String comment,int b_id,String nick);
}
