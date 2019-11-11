/**
 * 创建时间：2019年8月7日
 * 所在包：com.it.action.UserAction.java
 * 创建者：@author bjx
 */
package com.it.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.it.bean.User;
import com.it.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//属性封装
	private String username;
	private String password;
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

	public String login() {
		User user = new User();
		user.setUser_name(username);
		user.setUser_password(password);
		System.out.println(user);
		User user1 = userService.login(user);
		if(user1!=null) {//登录
			//使用session保持登录状态
			HttpServletRequest  request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", user1);
			return "loginok";
		}else {
			return "login";
		}
		
		
	}

}
