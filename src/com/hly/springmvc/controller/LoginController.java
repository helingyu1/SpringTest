package com.hly.springmvc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * µÇÂ¼controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user1/*")
public class LoginController {
	int flag = 1;
	@RequestMapping(value="login1.do")
	public @ResponseBody Map<String,Object> login(HttpServletRequest request,HttpServletResponse response) throws IOException{
		flag++;
		System.out.println(request.getParameter("name"));
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(request.getParameter("name").equals("123")){
			System.out.println("³Ç¶«");
			map.put("msg", System.currentTimeMillis());
			map.put("flag", flag);
		}else{
			System.out.println("Ê§°Ü");
			map.put("flag", flag);
		}
		return map;
	}
	
}
