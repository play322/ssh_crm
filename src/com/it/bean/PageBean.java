/**
 * ����ʱ�䣺2019��8��8��
 * ���ڰ���com.it.bean.PageBean.java
 * �����ߣ�@author bjx
 */
package com.it.bean;

import java.util.List;

public class PageBean {
	//��ǰҳ
	private Integer currentPage;
	//�ܼ�¼��
	private Integer totalCount;
	//��ҳ��
	private Integer totalPage;
	//ÿҳ��ʾ��¼��
	private Integer pageSize;
	//��ʼλ��
	private Integer begin;
	//ÿҳ��¼�ļ���
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
