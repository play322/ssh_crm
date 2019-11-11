/**
 * 创建时间：2019年8月7日
 * 所在包：com.it.dao.UserDaoImpl.java
 * 创建者：@author bjx
 */
package com.it.dao;


import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.it.bean.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User loginUser(User user) {
		
		@SuppressWarnings("all")
		List<User> listU = (List<User>) this.getHibernateTemplate().
	find("from User where user_name=? and user_password=?", user.getUser_name(),user.getUser_password());
		
		
		//判断
		if(listU!=null && listU.size()!=0) {
			//返回一个user对象
			User user1 = listU.get(0);
			return user1;
		}
		return null;
	}

	//查询所有用户
	public List<User> queryAll() {
		List<User> list = (List<User>)this.getHibernateTemplate().find("from User");
		return list;
	}
	
	
	

}
