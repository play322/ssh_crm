/**
 * ����ʱ�䣺2019��8��7��
 * ���ڰ���com.it.dao.CustomerDao.java
 * �����ߣ�@author bjx
 */
package com.it.dao;

import java.util.List;

import com.it.bean.Customer;
import com.it.bean.Dict;

public interface CustomerDao {

	void add(Customer customer);

	List<Customer> queryAll();

	Customer findById(Customer customer);

	void del(Customer customer);

	void update(Customer customer);

	int findCount();

	List<Customer> findPage(int begin, int pageSize);

	List<Customer> findCondition(Customer customer);

	List<Customer> findMore(Customer customer);

	List<Dict> queryLevel();

	List countSourse();

	List countLevel();

}
