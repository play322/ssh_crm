/**
 * 创建时间：2019年8月11日
 * 所在包：com.it.dao.VisitDao.java
 * 创建者：@author bjx
 */
package com.it.dao;

import java.util.List;

import com.it.bean.Visit;

public interface VisitDao {

	void add(Visit visit);

	List<Visit> queryAll();

}
