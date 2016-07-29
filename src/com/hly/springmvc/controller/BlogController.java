package com.hly.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hly.springmvc.model.Blog;
import com.hly.springmvc.model.ResponseData;
import com.hly.springmvc.service.BlogOptService;

@Controller
@RequestMapping("/blog/*")
public class BlogController {
	@Autowired
	BlogOptService blogService;
	
	@RequestMapping("/publish")
	public ModelAndView doPublish(HttpServletRequest request){
		String content = request.getParameter("ta1");
		String uname = (String)request.getSession().getAttribute("username");
		Blog blog = new Blog();
		blog.setB_content(content);
		blog.setB_uname(uname);
		System.out.println(content);
		blogService.publishBlog(blog);
		return new ModelAndView("homepage","blog",content);
	}
	@RequestMapping("publish1.do")
	public String doPublish_new(@RequestBody Blog blog){
		System.out.println(blog.getB_content());
		return "homepage";
	}
	@RequestMapping(value="showBlogs.do")
	@ResponseBody
	public List<Blog> getBlogs(String nickname){
		System.out.println("【显示微博】列表");
		List<Blog> list = blogService.showFocusBlogs();
		return list;
	}
	@RequestMapping(value="publish.do")
	@ResponseBody
	public ResponseData publish(@RequestBody Blog blog){
		System.out.println("【微博发布】 controller");
		ResponseData res = new ResponseData();
		String ret = blogService.publishBlog(blog);
		if("true".equals(ret))
			res.setState(true);		
		return res;
	}
}
