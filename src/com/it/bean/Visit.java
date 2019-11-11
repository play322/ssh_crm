/**
 * 创建时间：2019年8月11日
 * 所在包：com.it.bean.Visit.java
 * 创建者：@author bjx
 */
package com.it.bean;
/**
 * 拜访记录实体类
 */
public class Visit {
	
	private Integer vid;
	private String vaddress;
	private String vcontent;
	
	//表示拜访记录所属的客户
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	//表示一条拜访记录所属用户
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
