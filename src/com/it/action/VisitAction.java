/**
 * 创建时间：2019年8月11日
 * 所在包：com.it.action.VisitAction.java
 * 创建者：@author bjx
 */
package com.it.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.it.bean.Customer;
import com.it.bean.User;
import com.it.bean.Visit;
import com.it.service.CustomerService;
import com.it.service.UserService;
import com.it.service.VisitService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	
	private Visit visit = new Visit();
	public Visit getModel() {
		return visit;
	}
	
	private VisitService visitService;
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	//到添加页面
	public String toAddPage() {
		//查询所有客户
		List<Customer> listCus = customerService.queryAll();
		
		//查询所有用户
		List<User> listUser = userService.queryAll();
		
		//放到域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listCus", listCus);
		request.setAttribute("listUser", listUser);
		return "toAddPage";
	}
	
	//添加客户拜访
	public String addVisit() {
		visitService.add(visit);
		return "addVisit";
	}

	//客户拜访列表
	public String list() {
		List<Visit> listv = visitService.queryAll();
		ServletActionContext.getRequest().setAttribute("list", listv);
		return "list";
	}
	

}
