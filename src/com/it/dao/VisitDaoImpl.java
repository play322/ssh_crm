/**
 * 创建时间：2019年8月11日
 * 所在包：com.it.dao.VisitDaoImpl.java
 * 创建者：@author bjx
 */
package com.it.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.it.bean.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	//添加客户拜访
	public void add(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

	//拜访列表
	public List<Visit> queryAll() {
		return (List<Visit>)this.getHibernateTemplate().find("from Visit");
	}

}
