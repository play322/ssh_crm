/**
 * ����ʱ�䣺2019��8��7��
 * ���ڰ���com.it.action.CustomerAction.java
 * �����ߣ�@author bjx
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
	 * ��ҳ����
	 */
	//���Է�װ
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String listPage() {
		//����service�ķ���ʵ�ַ�װ
		PageBean pageBean = customerService.listpage(currentPage);
		//�ŵ����������
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listPage";
	}
	
	//�����ҳ��
	public String toAdd() {
		List<Dict> listLevel = customerService.queryLevel();
		ServletActionContext.getRequest().setAttribute("listLevel", listLevel);
		return "toAdd";
	}
	
	//��ӷ���
	public String Add() {
		customerService.add(customer);
		return "Add";
	}
	
	//�ͻ��б�
	public String queryAll() {
		list = customerService.queryAll();
		//System.out.println("list.size-->"+list.size());
		return "queryAll";
	}

	
	//ɾ��
	public String del() {
		//�ȸ���id�鵥��
		Customer customer1 = customerService.findById(customer);
		//��ɾ��
		if(customer1!=null) {
			customerService.del(customer1);
		}
		return "del";
	}
	
	//�޸�-�Ȳ�ѯ����
		public String findById() {
			customer = customerService.findById(customer);
			List<Dict> listLevel = customerService.queryLevel();
			ServletActionContext.getRequest().setAttribute("listLevel", listLevel);
			return "findById";
		}
		
	//�޸�
		public String upd() {
			customerService.update(customer);
			return "upd";
		}

		//������ѯ
		public String findCondition() {
			if(!"".equals(customer.getCust_name()) && customer.getCust_name()!=null ) {
				List<Customer> list = customerService.findCondition(customer);
				ServletActionContext.getRequest().setAttribute("list", list);
			}else {
				list = customerService.queryAll();
			}
			
			return "findCondition";
		}
		
		//����������ѯҳ��
		public String toMoreCondition() {
			
			return "toMoreCondition";
		}
		
		
		//��������ѯ
		public String moreCondition() {
			List<Customer> list = customerService.findMore(customer);
			ServletActionContext.getRequest().setAttribute("list",list);
			return "moreCondition";
		}
		
		
		//��Դͳ��
		public String countSoure() {
			List listSource = customerService.countSourse();
			ServletActionContext.getRequest().setAttribute("listSource",listSource);
			return "countSoure";
		}
		
		//����ͳ��
		public  String countLevel() {
			List listLevel = customerService.countLevel();
			ServletActionContext.getRequest().setAttribute("listLevel",listLevel);
			return "countLevel";
		}
		
}
