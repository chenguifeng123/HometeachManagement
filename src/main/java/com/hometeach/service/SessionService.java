package com.hometeach.service;

import org.springframework.stereotype.Service;
// 暂时先不用redis 等缓存
@Service
public class SessionService {

	// 先测试发一个时间
	public String getSessionKey(){
		return String.valueOf(System.currentTimeMillis());
	}
}
