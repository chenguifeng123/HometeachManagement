package com.hometeach.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginService {

	private static final String FIXED_USER = "admin";
	private static final String FIXED_PASSWORD = "root0000";
	
	@RequestMapping(value = "/loginPost" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loginPost(String user, String password, HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(!FIXED_USER.equals(user) || !FIXED_PASSWORD.equals(password)){
			map.put("success", false);
			if(!FIXED_USER.equals(user))
				map.put("message", "001");
			else
				map.put("message", "011");
			return map;
		}
		
		httpSession.setAttribute(LoginFilter.SESSION_KEY, user);
		System.out.println("login success");
		map.put("success", true);
		map.put("message", "0");
		
		return map;
	}
	
	@RequestMapping(value = "/loginOut" , method = RequestMethod.GET)
	public String loginOut(HttpSession httpSession){
		httpSession.removeAttribute(LoginFilter.SESSION_KEY);
		return String.format("redirect:%s", LoginFilter.LOGIN);
	}
	
}
