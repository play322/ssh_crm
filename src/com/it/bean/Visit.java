/**
 * ����ʱ�䣺2019��8��11��
 * ���ڰ���com.it.bean.Visit.java
 * �����ߣ�@author bjx
 */
package com.it.bean;
/**
 * �ݷü�¼ʵ����
 */
public class Visit {
	
	private Integer vid;
	private String vaddress;
	private String vcontent;
	
	//��ʾ�ݷü�¼�����Ŀͻ�
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	//��ʾһ���ݷü�¼�����û�
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getVaddress() {
		return vaddress;
	}
	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
	}
	public String getVcontent() {
		return vcontent;
	}
	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}
	
	
	

}
