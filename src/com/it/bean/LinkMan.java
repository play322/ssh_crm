package com.it.bean;

/**
 *Title:`lkm_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '��ϵ�˱��(����)',
  `lkm_name` varchar(16) DEFAULT NULL COMMENT '��ϵ������',
  `lkm_cust_id` bigint(32) NOT NULL COMMENT '�ͻ�id',
  `lkm_gender` char(1) DEFAULT NULL COMMENT '��ϵ���Ա�',
  `lkm_phone` varchar(16) DEFAULT NULL COMMENT '��ϵ�˰칫�绰',
  `lkm_mobile` varchar(16) DEFAULT NULL COMMENT '��ϵ���ֻ�',
  `lkm_email` varchar(64) DEFAULT NULL COMMENT '��ϵ������',
  `lkm_qq` varchar(16) DEFAULT NULL COMMENT '��ϵ��qq',
  `lkm_position` varchar(16) DEFAULT NULL COMMENT '��ϵ��ְλ',
  `lkm_memo` varchar(512) DEFAULT NULL COMMENT '��ϵ�˱�ע',
 *Time:2019��5��31��.����8:39:40
 */
public class LinkMan {
	
	private int lkm_id;//��ϵ�˱��(����)',
	private String lkm_name;//��ϵ������
	private String lkm_gender;//��ϵ���Ա�',,
	private String lkm_phone;//��ϵ�˰칫�绰'
	private String lkm_mobile;//��ϵ���ֻ�
	
	//�����ͻ�
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(int lkm_id) {
		this.lkm_id = lkm_id;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	
	public String getLkm_gender() {
		return lkm_gender;
	}
	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	public String getLkm_phone() {
		return lkm_phone;
	}
	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}
	public String getLkm_mobile() {
		return lkm_mobile;
	}
	public void setLkm_mobile(String lkm_mobile) {
		this.lkm_mobile = lkm_mobile;
	}
	
	public LinkMan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
