/**
 * 创建时间：2019年8月8日
 * 所在包：com.it.bean.PageBean.java
 * 创建者：@author bjx
 */
package com.it.bean;

import java.util.List;

public class PageBean {
	//当前页
	private Integer currentPage;
	//总记录数
	private Integer totalCount;
	//总页数
	private Integer totalPage;
	//每页显示记录数
	private Integer pageSize;
	//开始位置
	private Integer begin;
	//每页记录的集合
	private List<Customer> list;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public List<Customer> getList() {
		return list;
	}
	public void setList(List<Customer> list) {
		this.list = list;
	}
	
	
	

}
