package com.usdj.springcloud.zuul.user.dto;

/**
 * @program: zuul
 * @description: user dto
 * @author: JerryDeng
 * @create: 2019-03-10 11:40
 **/
public class User {

	private String loginName;
	private String name;
	private String avatar;
	private String memos;

	public User() {
	}

	public User(String loginName, String name, String avatar, String memos) {
		this.loginName = loginName;
		this.name = name;
		this.avatar = avatar;
		this.memos = memos;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMemos() {
		return memos;
	}

	public void setMemos(String memos) {
		this.memos = memos;
	}
}
