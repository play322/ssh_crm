/**
 * ����ʱ�䣺2019��8��7��
 * ���ڰ���com.it.service.UserService.java
 * �����ߣ�@author bjx
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
		//����dao�еķ���
		return userDao.loginUser(user);
	}


	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userDao.queryAll();
	}
	

}
