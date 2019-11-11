/**
 * 创建时间：2019年8月7日
 * 所在包：com.it.service.CustomerService.java
 * 创建者：@author bjx
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
	
	//添加客户
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

	//封装分页数据到pagebean对象里面
	public PageBean listpage(Integer currentPage) {
		//创建PageBean对象
		PageBean pageBean = new PageBean();
		//当前页
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//总页数
		//总记录数 除以 每页显示记录数
		//能够整除
		int totalPage = 0;
		if(totalCount%pageSize==0) {//整除
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始位置
		int begin = (currentPage-1)*pageSize;
		
		//每页记录的list集合
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
