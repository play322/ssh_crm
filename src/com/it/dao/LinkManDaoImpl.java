/**
 * 创建时间：2019年8月9日
 * 所在包：com.it.dao.LinkManDaoImpl.java
 * 创建者：@author bjx
 */
package com.it.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.it.bean.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	//添加联系人
	public void addLinkMan(LinkMan linkMan) {

		this.getHibernateTemplate().save(linkMan);
		
	}

	//联系人列表
	public List<LinkMan> queryAll() {
		// TODO Auto-generated method stub
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

	//查询单个联系人
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

	//模糊查询
	public List<LinkMan> findCondition(LinkMan linkMan) {
		//创建离线对象
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		//设置操作那个属性
		criteria.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		//调用方法查询
		List<LinkMan> list = (List<LinkMan>)
				this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

	//多条件查询
	public List<LinkMan> moreQuery(LinkMan linkMan) {
		//方式一：拼接hql语句实现
//		String hql = "from LinkMan where 1=1 ";
//		List<Object> listp = new ArrayList<>();
//		//判断
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
		
		//方式二：离线对象实现
		//创建离线对象
		DetachedCriteria cirteria = DetachedCriteria.forClass(LinkMan.class);
		
		//判断并设置属性值
		if(!"".equals(linkMan.getLkm_name()) && linkMan.getLkm_name()!=null) {
			cirteria.add(Restrictions.eq("lkm_name", linkMan.getLkm_name()));
		}
		if(linkMan.getCustomer().getCust_id()!=null && linkMan.getCustomer().getCust_id()>0) {
			cirteria.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		//调方法查询
		List<LinkMan> list = (List<LinkMan>)
				this.getHibernateTemplate().findByCriteria(cirteria);
		return list;
	}

}
