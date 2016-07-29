package com.hly.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hly.springmvc.service.CommentOptService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentOptService cmtService;

	@RequestMapping("/{b_id}")
	public String handlePublishCmt(@PathVariable int b_id,HttpServletRequest request,Model model){
		String comment = request.getParameter("comment");
		String nick = (String)request.getSession().getAttribute("nickname");
		cmtService.publishCmt(comment, b_id, nick);		
		
		return "homepage";
	}
}
