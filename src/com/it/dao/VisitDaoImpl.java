/**
 * ����ʱ�䣺2019��8��11��
 * ���ڰ���com.it.dao.VisitDaoImpl.java
 * �����ߣ�@author bjx
 */
package com.it.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.it.bean.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	//��ӿͻ��ݷ�
	public void add(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

	//�ݷ��б�
	public List<Visit> queryAll() {
		return (List<Visit>)this.getHibernateTemplate().find("from Visit");
	}

}
