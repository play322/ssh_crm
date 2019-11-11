/**
 * ����ʱ�䣺2019��8��11��
 * ���ڰ���com.it.action.VisitAction.java
 * �����ߣ�@author bjx
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


	//�����ҳ��
	public String toAddPage() {
		//��ѯ���пͻ�
		List<Customer> listCus = customerService.queryAll();
		
		//��ѯ�����û�
		List<User> listUser = userService.queryAll();
		
		//�ŵ������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listCus", listCus);
		request.setAttribute("listUser", listUser);
		return "toAddPage";
	}
	
	//��ӿͻ��ݷ�
	public String addVisit() {
		visitService.add(visit);
		return "addVisit";
	}

	//�ͻ��ݷ��б�
	public String list() {
		List<Visit> listv = visitService.queryAll();
		ServletActionContext.getRequest().setAttribute("list", listv);
		return "list";
	}
	

}
