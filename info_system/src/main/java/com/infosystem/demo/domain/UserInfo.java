package com.infosystem.demo.domain;
public class UserInfo {
	private Integer id;
	private String name;
	private String password;
	private String info;
	private String user_type;

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public UserInfo(Integer id, String name, String password, String info) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.info = info;
	}
	public UserInfo(String name, String password, String info) {
		super();
		this.name = name;
		this.password = password;
		this.info = info;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", info='" + info + '\'' +
				", user_type='" + user_type + '\'' +
				'}';
	}
}
