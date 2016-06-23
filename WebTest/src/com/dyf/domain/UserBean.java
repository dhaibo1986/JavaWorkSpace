package com.dyf.domain;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2528971668992457925L;
	private Integer id;
	private String username;
	private String password;
	private String name;
	private Boolean sex;
	private Date regdate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
