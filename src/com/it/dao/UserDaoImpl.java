/**
 * ����ʱ�䣺2019��8��7��
 * ���ڰ���com.it.dao.UserDaoImpl.java
 * �����ߣ�@author bjx
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
		
		
		//�ж�
		if(listU!=null && listU.size()!=0) {
			//����һ��user����
			User user1 = listU.get(0);
			return user1;
		}
		return null;
	}

	//��ѯ�����û�
	public List<User> queryAll() {
		List<User> list = (List<User>)this.getHibernateTemplate().find("from User");
		return list;
	}
	
	
	

}
