package com.hly.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hly.springmvc.model.Data;

@Controller
@RequestMapping("/helingyu")
public class TestController {
	
	@RequestMapping(value="/hehehe",method=RequestMethod.POST,consumes="application/json")
	@ResponseBody 
	public List<Data> doTest(@RequestBody Data data){
		List<Data> list = new ArrayList<Data>();
		System.out.println("jjjjjj");
		System.out.println(data.getName());
		System.out.println(data.getAge());
		data.setName("xiayuqing");
		data.setAge(24);
		list.add(data);
		Data data0 = new Data();
		data0.setName("helingyu");
		data0.setAge(25);
		list.add(data0);
		
		return list;
	}
}
