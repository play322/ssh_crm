/**
 * ����ʱ�䣺2019��8��7��
 * ���ڰ���com.it.service.CustomerService.java
 * �����ߣ�@author bjx
 */
package com.it.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.it.bean.Customer;
import com.it.bean.Dict;
import com.it.bean.PageBean;
import com.it.dao.CustomerDao;

@Transactional
public class CustomerService {
	
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	//��ӿͻ�
	public void add(Customer customer) {
		customerDao.add(customer);
		
	}

	public List<Customer> queryAll() {
		
		return customerDao.queryAll();
		
	}

	public Customer findById(Customer customer) {
		
		return customerDao.findById(customer);
	}

	public void del(Customer customer) {
		customerDao.del(customer);
		
	}

	public void update(Customer customer) {
		customerDao.update(customer);
		
	}

	//��װ��ҳ���ݵ�pagebean��������
	public PageBean listpage(Integer currentPage) {
		//����PageBean����
		PageBean pageBean = new PageBean();
		//��ǰҳ
		pageBean.setCurrentPage(currentPage);
		//�ܼ�¼��
		int totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//ÿҳ��ʾ��¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��ҳ��
		//�ܼ�¼�� ���� ÿҳ��ʾ��¼��
		//�ܹ�����
		int totalPage = 0;
		if(totalCount%pageSize==0) {//����
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//��ʼλ��
		int begin = (currentPage-1)*pageSize;
		
		//ÿҳ��¼��list����
		List<Customer> list = customerDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public List<Customer> findCondition(Customer customer) {
		
		return customerDao.findCondition(customer);
	}

	public List<Customer> findMore(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.findMore(customer);
	}

	public List<Dict> queryLevel() {
		// TODO Auto-generated method stub
		return customerDao.queryLevel();
	}

	public List countSourse() {
		// TODO Auto-generated method stub
		return customerDao.countSourse() ;
	}

	public List countLevel() {
		// TODO Auto-generated method stub
		return customerDao.countLevel();
	}
	

}
