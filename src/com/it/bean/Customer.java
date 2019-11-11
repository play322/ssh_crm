package com.it.bean;

import java.util.HashSet;
import java.util.Set;

/**
 *Title:`cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '�ͻ����(����)',
  `cust_name` varchar(32) NOT NULL COMMENT '�ͻ�����(��˾����)',
  `cust_source` varchar(32) DEFAULT NULL COMMENT '�ͻ���Ϣ��Դ',
  `cust_industry` varchar(32) DEFAULT NULL COMMENT '�ͻ�������ҵ',
  `cust_level` varchar(32) DEFAULT NULL COMMENT '�ͻ�����',
  `cust_phone` varchar(64) DEFAULT NULL COMMENT '�̶��绰',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '�ƶ��绰',
 *Time:2019��5��31��.����8:30:39
 */
public class Customer {
	
	private Integer cust_id; //�ͻ����(����)
	private String cust_name; //�ͻ�����(��˾����)
	private String cust_source; //�ͻ���Ϣ��Դ
	private String cust_industry; //�ͻ�������ҵ
	//private String cust_level; //�ͻ�����
	private String cust_phone;//�̶��绰
	private String cust_mobile;//�ƶ��绰
	
	//��ʾһ���ͻ�ֻ����һ������
	private Dict dictCusLevel;	
	public Dict getDictCusLevel() {
		return dictCusLevel;
	}
	public void setDictCusLevel(Dict dictCusLevel) {
		this.dictCusLevel = dictCusLevel;
	}


	//�ݷü�¼�ļ���
	private Set<Visit> setCus = new HashSet<>();
	public Set<Visit> getSetCus() {
		return setCus;
	}
	public void setSetCus(Set<Visit> setCus) {
		this.setCus = setCus;
	}


	//��ϵ�˵ļ���
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
//		//System.out.println("ID\t�ͻ�����\t\t�ͻ���Դ\t\t������ҵ\t\t�ͻ��ȼ�\t\t�̶��绰\t\t�ƶ��绰");
//		
//		return 	this.getCust_id()+"\t"+this.getCust_name()+"\t\t"+this.getCust_source()+"\t\t"+this.getCust_industry()
//				+"\t\t"+this.getCust_level()+"\t\t"+this.getCust_phone()+"\t"+this.getCust_mobile();
//	}
	
	
	
	
	
	
	
	

}
