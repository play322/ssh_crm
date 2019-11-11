/**
 * 创建时间：2019年8月9日
 * 所在包：com.it.action.LinkManAction.java
 * 创建者：@author bjx
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

		//注入customerService对象
		private CustomerService customerService;
		public void setCustomerService(CustomerService customerService) {
			this.customerService = customerService;
		}
		/*
		 * 需要上传文件（流）
		 * 需要上传文件名称
		 * （1）在action里面成员变量位置定义变量（命名规范）
		 * - 一个表示上传文件
		 * - 一个表示文件名称
		 * （2）生成变量的get和set方法
		 * 
		 * 还有一个变量，上传文件的mime类型
		 * */
		
		// 上传文件
		//变量的名称需要是表单里面文件上传项的name值
		private File upload;
		//上传文件名称   表单里面文件上传项的name值FileName
		private String uploadFileName;
		//生成get和set方法
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
		
		//添加联系人
		public String addLinkMan() throws IOException {
		//判断是否需要上传文件
			if(upload!=null) {
			//写上传代码
			//在服务器文件夹里面创建文件
			File serverFile = new File("F:\\upload\\"+uploadFileName);
			//把文件复制到服务器的文件里
			FileUtils.copyFile(upload, serverFile);
			
			}
		linkManService.addLinkMan(linkMan);
		return "addLinkMan";
		} 
		
		//到添加页面
		public String toAddPage() {
		//把所有客户查询到传到联系人添加页面可供联系人选择
		List<Customer> listcustomer = customerService.queryAll();
		//存到域对象中
		ServletActionContext.getRequest().setAttribute("listcustomer", listcustomer);
		return "toAddPage";
	}
	
	

	//联系人列表
	public String list() {
		List<LinkMan> list = linkManService.queryAll();
		//将集合放到域对象中
		ServletActionContext.getRequest().setAttribute("list",list);
		return "list";
	}

	//查询单个
	public String findById() {
		linkMan  = linkManService.findById(linkMan);
		//把所有customer的信息也要放到页面里去
		List<Customer> listcustomer = customerService.queryAll();
		ServletActionContext.getRequest().setAttribute("linkman", linkMan);
		ServletActionContext.getRequest().setAttribute("customer", listcustomer);
		return "findById";
	}
	
	//修改联系人
	public String update() {
		linkManService.update(linkMan);
		return "update";
	}
	
	//删除联系人
	public String del() {
		linkManService.delLinkMan(linkMan);
		return "del";
	}

	//模糊查询
	public String findCondition() {
		if(!"".equals(linkMan.getLkm_name()) && linkMan.getLkm_name()!=null) {
			List<LinkMan> listL = linkManService.findConditin(linkMan);
			//放到域对象
			ServletActionContext.getRequest().setAttribute("list", listL);
		}else {
			//List<LinkMan> list = linkManService.queryAll();
			list();
		}
		return "findCondition";
	}
	
	//到多条件查询页面
	public String toMoreCondition() {
		List<Customer> list = customerService.queryAll();
		//System.out.println("list-->"+list.size());
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toMoreCondition";
	}
	
	//多条件查询
	public String moreQuery() {
		
		List<LinkMan> listLinkMan = linkManService.moreQuery(linkMan);
		
		ServletActionContext.getRequest().setAttribute("list", listLinkMan);
		return "moreQuery";
	}
	
	
	
	}
		

