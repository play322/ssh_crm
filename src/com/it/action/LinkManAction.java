/**
 * ����ʱ�䣺2019��8��9��
 * ���ڰ���com.it.action.LinkManAction.java
 * �����ߣ�@author bjx
 */
package com.it.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.it.bean.Customer;
import com.it.bean.LinkMan;
import com.it.service.CustomerService;
import com.it.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	
		private LinkMan linkMan = new LinkMan();
		public LinkMan getModel() {
		return linkMan;
		}
		private LinkManService linkManService;
		public void setLinkManService(LinkManService linkManService) {
			this.linkManService = linkManService;
		}

		//ע��customerService����
		private CustomerService customerService;
		public void setCustomerService(CustomerService customerService) {
			this.customerService = customerService;
		}
		/*
		 * ��Ҫ�ϴ��ļ�������
		 * ��Ҫ�ϴ��ļ�����
		 * ��1����action�����Ա����λ�ö�������������淶��
		 * - һ����ʾ�ϴ��ļ�
		 * - һ����ʾ�ļ�����
		 * ��2�����ɱ�����get��set����
		 * 
		 * ����һ���������ϴ��ļ���mime����
		 * */
		
		// �ϴ��ļ�
		//������������Ҫ�Ǳ������ļ��ϴ����nameֵ
		private File upload;
		//�ϴ��ļ�����   �������ļ��ϴ����nameֵFileName
		private String uploadFileName;
		//����get��set����
		public File getUpload() {
			return upload;
		}
		public void setUpload(File upload) {
			this.upload = upload;
		}
		public String getUploadFileName() {
			return uploadFileName;
		}
		public void setUploadFileName(String uploadFileName) {
			this.uploadFileName = uploadFileName;
		}
		
		//�����ϵ��
		public String addLinkMan() throws IOException {
		//�ж��Ƿ���Ҫ�ϴ��ļ�
			if(upload!=null) {
			//д�ϴ�����
			//�ڷ������ļ������洴���ļ�
			File serverFile = new File("F:\\upload\\"+uploadFileName);
			//���ļ����Ƶ����������ļ���
			FileUtils.copyFile(upload, serverFile);
			
			}
		linkManService.addLinkMan(linkMan);
		return "addLinkMan";
		} 
		
		//�����ҳ��
		public String toAddPage() {
		//�����пͻ���ѯ��������ϵ�����ҳ��ɹ���ϵ��ѡ��
		List<Customer> listcustomer = customerService.queryAll();
		//�浽�������
		ServletActionContext.getRequest().setAttribute("listcustomer", listcustomer);
		return "toAddPage";
	}
	
	

	//��ϵ���б�
	public String list() {
		List<LinkMan> list = linkManService.queryAll();
		//�����Ϸŵ��������
		ServletActionContext.getRequest().setAttribute("list",list);
		return "list";
	}

	//��ѯ����
	public String findById() {
		linkMan  = linkManService.findById(linkMan);
		//������customer����ϢҲҪ�ŵ�ҳ����ȥ
		List<Customer> listcustomer = customerService.queryAll();
		ServletActionContext.getRequest().setAttribute("linkman", linkMan);
		ServletActionContext.getRequest().setAttribute("customer", listcustomer);
		return "findById";
	}
	
	//�޸���ϵ��
	public String update() {
		linkManService.update(linkMan);
		return "update";
	}
	
	//ɾ����ϵ��
	public String del() {
		linkManService.delLinkMan(linkMan);
		return "del";
	}

	//ģ����ѯ
	public String findCondition() {
		if(!"".equals(linkMan.getLkm_name()) && linkMan.getLkm_name()!=null) {
			List<LinkMan> listL = linkManService.findConditin(linkMan);
			//�ŵ������
			ServletActionContext.getRequest().setAttribute("list", listL);
		}else {
			//List<LinkMan> list = linkManService.queryAll();
			list();
		}
		return "findCondition";
	}
	
	//����������ѯҳ��
	public String toMoreCondition() {
		List<Customer> list = customerService.queryAll();
		//System.out.println("list-->"+list.size());
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toMoreCondition";
	}
	
	//��������ѯ
	public String moreQuery() {
		
		List<LinkMan> listLinkMan = linkManService.moreQuery(linkMan);
		
		ServletActionContext.getRequest().setAttribute("list", listLinkMan);
		return "moreQuery";
	}
	
	
	
	}
		

