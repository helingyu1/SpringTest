package com.hly.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hly.springmvc.dao.impl.Test;
import com.hly.springmvc.model.OptionResult;
import com.hly.springmvc.model.ResponseData;
import com.hly.springmvc.model.User;
import com.hly.springmvc.service.BlogOptService;
import com.hly.springmvc.service.FollowInfoService;
import com.hly.springmvc.service.UserInfoService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	@Autowired
	UserInfoService userService;
	@Autowired
	BlogOptService blogService;
	@Autowired
	FollowInfoService followService;

	@Autowired
	Test test;


	@RequestMapping("/searchUser")
	public String handleSearchUser(HttpServletRequest request, Model model) {
		System.out.println("~~~~~~~~~~~~~~~~新方法哦");
		User user = userService.getUserByNick(request.getParameter("text1"));
		if (user == null) {
			model.addAttribute("message", "不存在该用户");
			return "homepage";
		} else {
			// 为了关注该用户
			request.getSession().setAttribute("target", user);
			model.addAttribute("user", user);
			return "show_userinfo";
		}
	}

	@RequestMapping("/addFocus")
	public String addFocus(HttpServletRequest request) {
		System.out.println("新方法哦。。。。。");
		followService.addFocus(
				(String) request.getSession().getAttribute("nickname"),
				(User) request.getSession().getAttribute("target"));

		return "homepage";
	}

	@RequestMapping(value = "showFocus.do")
	public String showFocus(HttpServletRequest request, Model model) {
		String nick = (String) request.getSession().getAttribute("nickname");
		List<User> list = followService.searchFocus(nick);
		model.addAttribute("list", list);
		return "showfocus";

	}

	@RequestMapping("/showFans")
	public String showFans(HttpServletRequest request, Model model) {
		String nick = (String) request.getSession().getAttribute("nickname");
		List<User> list = followService.searchFans(nick);
		model.addAttribute("list", list);
		return "showfans";
	}

	@RequestMapping("/test")
	public String test(HttpServletRequest request, Model model) {
		System.out.println("ssssssssss");
		return "homepage";
	}

	@RequestMapping("/{name}")
	public String showUniqueUser(@PathVariable String name, Model model) {
		User user = new User();
		user = userService.getUserByName(name);
		model.addAttribute("user", user);
		return "show_userinfo";
	}

	@RequestMapping(value = "mentionlist.do")
	public @ResponseBody
	List<User> getMentionList(@RequestBody User user) {
		System.out.println("进来这个函数了");
		String nick = user.getU_nick();
		System.out.println("发送请求的用户是：" + user.getU_nick());
		List<User> list = new ArrayList<User>();
		list = followService.searchFans(nick);
		return list;
	}

	/**
	 * 处理登录请求
	 * @param user 登录用户实体
	 * @return
	 */
	@RequestMapping(value = "logon.do")
	@ResponseBody
	public ResponseData handleUserLogon(@RequestBody User user) {
		ResponseData res = new ResponseData();
		OptionResult ret = userService.validateUser(user);
		if("0000".equals(ret.getCode())){
			res.setState(true);
			res.setMessage(ret.getMsg());
		}else{
			res.setState(false);
			res.setMessage(ret.getMsg());
		}
		return res;
	}

	/**
	 * 处理注册请求
	 * @param user 注册用户实体
	 * @return
	 */
	@RequestMapping(value = "register.do")
	@ResponseBody
	public ResponseData handleUserRegister(@RequestBody User user) {
		System.out.println("【注册方法】进来了");
		ResponseData res = new ResponseData();
		OptionResult ret = userService.addUser(user);
		if("0000".equals(ret.getCode())){
			res.setState(true);
			res.setMessage(ret.getMsg());
		}else{
			res.setState(false);
		}
		return res;
	}
}
