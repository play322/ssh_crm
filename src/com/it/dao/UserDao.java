/**
 * ����ʱ�䣺2019��8��7��
 * ���ڰ���com.it.dao.UserDao.java
 * �����ߣ�@author bjx
 */
package com.it.dao;

import java.util.List;

import com.it.bean.User;

public interface UserDao {

	User loginUser(User user);

	List<User> queryAll();

}
