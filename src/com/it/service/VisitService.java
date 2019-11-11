/**
 * ����ʱ�䣺2019��8��11��
 * ���ڰ���com.it.service.VisitService.java
 * �����ߣ�@author bjx
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
