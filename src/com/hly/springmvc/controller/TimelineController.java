package com.hly.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hly.springmvc.model.Blog;
import com.hly.springmvc.model.User;
import com.hly.springmvc.service.TimelineService;

/**
 * 时间轴相关控制器
 * @author helingyu
 *
 */
@Controller
@RequestMapping("/timeline/*")
public class TimelineController {
	@Autowired
	TimelineService service;
	
	@ResponseBody
	@RequestMapping("/showFocusTL.do")
	public List<Blog> handleFocusTL(@RequestBody User user){
		System.out.println("feeds controller");
		System.out.println("username:"+user.getU_name());
		List<Blog> rtnList = service.getFeeds(user.getU_name());
		return rtnList;
	}
}
