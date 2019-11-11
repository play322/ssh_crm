/**
 * 创建时间：2019年8月7日
 * 所在包：com.it.action.CustomerAction.java
 * 创建者：@author bjx
 */
package com.it.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.it.bean.Customer;
import com.it.bean.Dict;
import com.it.bean.PageBean;
import com.it.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	
	private Customer customer = new Customer();
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public Customer getModel() {
		return customer;
	}
	private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	/**
	 * 分页功能
	 */
	//属性封装
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String listPage() {
		//调用service的方法实现封装
		PageBean pageBean = customerService.listpage(currentPage);
		//放到域对象里面
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listPage";
	}
	
	//到添加页面
	public String toAdd() {
		List<Dict> listLevel = customerService.queryLevel();
		ServletActionContext.getRequest().setAttribute("listLevel", listLevel);
		return "toAdd";
	}
	
	//添加方法
	public String Add() {
		customerService.add(customer);
		return "Add";
	}
	
	//客户列表
	public String queryAll() {
		list = customerService.queryAll();
		//System.out.println("list.size-->"+list.size());
		return "queryAll";
	}

	
	//删除
	public String del() {
		//先根据id查单个
		Customer customer1 = customerService.findById(customer);
		//再删除
		if(customer1!=null) {
			customerService.del(customer1);
		}
		return "del";
	}
	
	//修改-先查询单个
		public String findById() {
			customer = customerService.findById(customer);
			List<Dict> listLevel = customerService.queryLevel();
			ServletActionContext.getRequest().setAttribute("listLevel", listLevel);
			return "findById";
		}
		
	//修改
		public String upd() {
			customerService.update(customer);
			return "upd";
		}

		//条件查询
		public String findCondition() {
			if(!"".equals(customer.getCust_name()) && customer.getCust_name()!=null ) {
				List<Customer> list = customerService.findCondition(customer);
				ServletActionContext.getRequest().setAttribute("list", list);
			}else {
				list = customerService.queryAll();
			}
			
			return "findCondition";
		}
		
		//到多条件查询页面
		public String toMoreCondition() {
			
			return "toMoreCondition";
		}
		
		
		//多条件查询
		public String moreCondition() {
			List<Customer> list = customerService.findMore(customer);
			ServletActionContext.getRequest().setAttribute("list",list);
			return "moreCondition";
		}
		
		
		//来源统计
		public String countSoure() {
			List listSource = customerService.countSourse();
			ServletActionContext.getRequest().setAttribute("listSource",listSource);
			return "countSoure";
		}
		
		//级别统计
		public  String countLevel() {
			List listLevel = customerService.countLevel();
			ServletActionContext.getRequest().setAttribute("listLevel",listLevel);
			return "countLevel";
		}
		
}
