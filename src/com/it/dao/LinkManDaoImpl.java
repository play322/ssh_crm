/**
 * ����ʱ�䣺2019��8��9��
 * ���ڰ���com.it.dao.LinkManDaoImpl.java
 * �����ߣ�@author bjx
 */
package com.it.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.it.bean.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	//�����ϵ��
	public void addLinkMan(LinkMan linkMan) {

		this.getHibernateTemplate().save(linkMan);
		
	}

	//��ϵ���б�
	public List<LinkMan> queryAll() {
		// TODO Auto-generated method stub
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

	//��ѯ������ϵ��
	public LinkMan findById(LinkMan linkMan) {
		List<LinkMan> list = (List<LinkMan>) 
				this.getHibernateTemplate().find("from LinkMan where lkm_id=?",linkMan.getLkm_id());
		if(list!=null && list.size()!=0) {
			LinkMan linkMan1 = list.get(0);
			return linkMan1;
		}
		return null;
	}

	@Override
	public void update(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);
	
	}

	@Override
	public void delLinkMan(LinkMan linkMan) {
		this.getHibernateTemplate().delete(linkMan);
		
	}

	//ģ����ѯ
	public List<LinkMan> findCondition(LinkMan linkMan) {
		//�������߶���
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		//���ò����Ǹ�����
		criteria.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		//���÷�����ѯ
		List<LinkMan> list = (List<LinkMan>)
				this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

	//��������ѯ
	public List<LinkMan> moreQuery(LinkMan linkMan) {
		//��ʽһ��ƴ��hql���ʵ��
//		String hql = "from LinkMan where 1=1 ";
//		List<Object> listp = new ArrayList<>();
//		//�ж�
//		if(!"".equals(linkMan.getLkm_name()) && linkMan.getLkm_name()!=null) {
//			hql += " and lkm_name=?";
//			listp.add(linkMan.getLkm_name());
//		}
//		if(linkMan.getCustomer().getCust_id()!=null && linkMan.getCustomer().getCust_id()>0) {
//			hql += " and customer.cust_id=?";
//			listp.add(linkMan.getCustomer().getCust_id());
//		}
//		
//		
//		List<LinkMan> list = (List<LinkMan>)
//				this.getHibernateTemplate().find(hql, listp.toArray());
//		
		
		//��ʽ�������߶���ʵ��
		//�������߶���
		DetachedCriteria cirteria = DetachedCriteria.forClass(LinkMan.class);
		
		//�жϲ���������ֵ
		if(!"".equals(linkMan.getLkm_name()) && linkMan.getLkm_name()!=null) {
			cirteria.add(Restrictions.eq("lkm_name", linkMan.getLkm_name()));
		}
		if(linkMan.getCustomer().getCust_id()!=null && linkMan.getCustomer().getCust_id()>0) {
			cirteria.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		//��������ѯ
		List<LinkMan> list = (List<LinkMan>)
				this.getHibernateTemplate().findByCriteria(cirteria);
		return list;
	}

}
