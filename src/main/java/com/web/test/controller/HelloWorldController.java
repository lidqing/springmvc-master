package com.web.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.test.service.TestService;

@Controller
@RequestMapping("/test")
public class HelloWorldController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/index")
	public @ResponseBody String index() {
		return "Hello World!";
	}

	@RequestMapping("/page")
	public String page(Model model) {
		model.addAttribute("msg", "go go go");
		System.out.println("gogogo");
		return "go.jsp";
	}

	@RequestMapping("/page2")
	public ModelAndView html(Model model) {
		ModelAndView mav = new ModelAndView("go.jsp");
		mav.addObject("msg", "go2 go2 go2");
		return mav;
	}

	@RequestMapping("/greeting")
	public String thymeleaf(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		return "greeting";
	}
	
	@RequestMapping("/freemark")
	public String freemark(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		return "freemark";
	}
	
	@RequestMapping("listUser")
	public @ResponseBody List<Map<String,Object>> getUserList(String name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		List<Map<String,Object>> data = testService.queryUserlist(map);
		System.out.println("data:"+data);
		return data;
	}
	
	@RequestMapping("updateUser")
	public @ResponseBody String updateUser(String account,String phone){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("account", account);
		map.put("phone", phone);
		
		testService.updateUser(map);
		
		testService.insertUserStyle(map);
		
		return "success";
	}
	
}
