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
		System.out.println("~~~~~~~~~~~~~~~~�·���Ŷ");
		User user = userService.getUserByNick(request.getParameter("text1"));
		if (user == null) {
			model.addAttribute("message", "�����ڸ��û�");
			return "homepage";
		} else {
			// Ϊ�˹�ע���û�
			request.getSession().setAttribute("target", user);
			model.addAttribute("user", user);
			return "show_userinfo";
		}
	}

	@RequestMapping("/addFocus")
	public String addFocus(HttpServletRequest request) {
		System.out.println("�·���Ŷ����������");
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
		System.out.println("�������������");
		String nick = user.getU_nick();
		System.out.println("����������û��ǣ�" + user.getU_nick());
		List<User> list = new ArrayList<User>();
		list = followService.searchFans(nick);
		return list;
	}

	/**
	 * �����¼����
	 * @param user ��¼�û�ʵ��
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
	 * ����ע������
	 * @param user ע���û�ʵ��
	 * @return
	 */
	@RequestMapping(value = "register.do")
	@ResponseBody
	public ResponseData handleUserRegister(@RequestBody User user) {
		System.out.println("��ע�᷽����������");
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
