/**
 * ����ʱ�䣺2019��8��11��
 * ���ڰ���com.it.dao.VisitDao.java
 * �����ߣ�@author bjx
 */
package com.it.dao;

import java.util.List;

import com.it.bean.Visit;

public interface VisitDao {

	void add(Visit visit);

	List<Visit> queryAll();

}
