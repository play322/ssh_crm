package com.it.bean;

import java.util.HashSet;
import java.util.Set;

/**
 *Title:`cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
  `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
  `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
  `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
  `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '移动电话',
 *Time:2019年5月31日.下午8:30:39
 */
public class Customer {
	
	private Integer cust_id; //客户编号(主键)
	private String cust_name; //客户名称(公司名称)
	private String cust_source; //客户信息来源
	private String cust_industry; //客户所属行业
	//private String cust_level; //客户级别
	private String cust_phone;//固定电话
	private String cust_mobile;//移动电话
	
	//表示一个客户只能有一个级别
	private Dict dictCusLevel;	
	public Dict getDictCusLevel() {
		return dictCusLevel;
	}
	public void setDictCusLevel(Dict dictCusLevel) {
		this.dictCusLevel = dictCusLevel;
	}


	//拜访记录的集合
	private Set<Visit> setCus = new HashSet<>();
	public Set<Visit> getSetCus() {
		return setCus;
	}
	public void setSetCus(Set<Visit> setCus) {
		this.setCus = setCus;
	}


	//联系人的集合
	private Set<LinkMan> set = new HashSet<>();
	public Set<LinkMan> getSet() {
		return set;
	}
	public void setSet(Set<LinkMan> set) {
		this.set = set;
	}
	
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_source() {
		return cust_source;
	}
	public void setCust_source(String cust_source) {
		this.cust_source = cust_source;
	}
	public String getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(String cust_industry) {
		this.cust_industry = cust_industry;
	}
//	public String getCust_level() {
//		return cust_level;
//	}
//	public void setCust_level(String cust_level) {
//		this.cust_level = cust_level;
//	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Customer(int cust_id, String cust_name, String cust_source,
			String cust_industry, String cust_level, String cust_phone,
			String cust_mobile) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_source = cust_source;
		this.cust_industry = cust_industry;
		//this.cust_level = cust_level;
		this.cust_phone = cust_phone;
		this.cust_mobile = cust_mobile;
	}
	
	
//	@Override
//	public String toString() {
//		
//		//System.out.println("ID\t客户名称\t\t客户来源\t\t所属行业\t\t客户等级\t\t固定电话\t\t移动电话");
//		
//		return 	this.getCust_id()+"\t"+this.getCust_name()+"\t\t"+this.getCust_source()+"\t\t"+this.getCust_industry()
//				+"\t\t"+this.getCust_level()+"\t\t"+this.getCust_phone()+"\t"+this.getCust_mobile();
//	}
	
	
	
	
	
	
	
	

}
