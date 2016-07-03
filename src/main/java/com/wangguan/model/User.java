package com.wangguan.model;

import java.io.Serializable;

/**
 * user表对应实体类
 * 
 * @author zhangtb
 * @date 2016-7-3 14:18:20
 * @since 1.0.0
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1784127475450391274L;

	private Integer id;
	private String username;
	private String password;
	private Integer type;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", type=" + type + "]";
	}

}
