package com.hometeach.dto;

public class WeixinUserBak {

	private String session_key;
	private String openid;
	
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Override
	public String toString(){
		return "session=" + session_key + ",openid=" + openid;
	}
	
}
