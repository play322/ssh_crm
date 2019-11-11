/**
 * 创建时间：2019年8月7日
 * 所在包：com.it.service.UserService.java
 * 创建者：@author bjx
 */
package com.it.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.it.bean.User;
import com.it.dao.UserDao;

@Transactional
public class UserService {
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	public User login(User user) {
		//调用dao中的方法
		return userDao.loginUser(user);
	}


	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userDao.queryAll();
	}
	

}
