package com.tedu.hello;

public class UserInfo {
	
	private String skin;
	
	// getters and setters
	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	
	// toString
	
	@Override
	public String toString() {
		return "UserInfo [skin=" + skin + "]";
	}
	
	
}
