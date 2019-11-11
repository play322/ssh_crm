/**
 * 创建时间：2019年8月7日
 * 所在包：com.it.dao.UserDao.java
 * 创建者：@author bjx
 */
package com.it.dao;

import java.util.List;

import com.it.bean.User;

public interface UserDao {

	User loginUser(User user);

	List<User> queryAll();

}
