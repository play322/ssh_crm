/**
 * 创建时间：2019年8月11日
 * 所在包：com.it.service.VisitService.java
 * 创建者：@author bjx
 */
package com.it.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.it.bean.Visit;
import com.it.dao.VisitDao;

@Transactional
public class VisitService {
	
	private VisitDao visitDao;
	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}
	public void add(Visit visit) {
		visitDao.add(visit);		
	}
	public List<Visit> queryAll() {
		return visitDao.queryAll();
	}

}
