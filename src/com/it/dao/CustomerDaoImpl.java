/**
 * ����ʱ�䣺2019��8��7��
 * ���ڰ���com.it.dao.CustomerDaoImpl.java
 * �����ߣ�@author bjx
 */
package com.it.dao;


import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.it.bean.Customer;
import com.it.bean.Dict;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	//��ӿͻ�
	public void add(Customer customer) {
		
		this.getHibernateTemplate().save(customer);
		
	}

	//��ѯ����
	public List<Customer> queryAll() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		
		if(list!=null && list.size()!=0) {
			
			return list;
		}
		
		return null;
	}

	//������ѯ
	public Customer findById(Customer customer) {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where cust_id=?",customer.getCust_id());
		if(list!=null && list.size()!=0) {
			Customer customer1 = list.get(0);
			return customer1 ;
		}
		return null;
	}

	//ɾ������
	public void del(Customer customer) {
		this.getHibernateTemplate().delete(customer);
		
	}

	//�޸�
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
		
	}

	//��ѯ�ܼ�¼��
	public int findCount() {
		//����hibernateTemplate�����find����ʵ��
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer ");
		if(list!=null && list.size()!=0) {
			Object obj = list.get(0);
			//ת��Ϊlong����
			Long lobj = (Long) obj;
			//ת��Ϊint
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	//��ѯ��ҳ�ļ���
	public List<Customer> findPage(int begin, int pageSize) {
		/**
		 * //��һ�� ʹ��hibernate�ײ����ʵ�֣��˽⣩
		//�õ�sessionFactory
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//�õ�session����
		Session session = sessionFactory.getCurrentSession();
		//���÷�ҳ��Ϣ
		Query query = session.createQuery("from Customer");
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Customer> list = query.list();
		 */
		
		//�ڶ���ʹ�����߶����hibernateTemplate�ķ���ʵ��
		//1 �������߶������ö��ĸ�ʵ������в���
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//����hibernateTemplate�ķ���ʵ��
//		��һ�����������߶���
//		�ڶ��������ǿ�ʼλ��
//		������������ÿҳ��¼��
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//������ѯ
	public List<Customer> findCondition(Customer customer) {
		//��һ�ַ�ʽ�� 
//		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//�õ�session����
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from Customer where custName like ?");
//		query.setParameter(0, "%"+customer.getCustName()+"%");
//		List<Customer> list = query.list();
		
		//�ڶ��ַ�ʽ �� ����hibernateTemplate��find����ʵ��
//		List<Customer> list = 
//				(List<Customer>) this.getHibernateTemplate().find("from Customer where cust_name like ?","%"+customer.getCust_name()+"%" );
		
		//�����ַ�ʽ�����߶���
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//���ò����Ǹ�����
		criteria.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
		//���÷���
		List<Customer> list = (List<Customer>) 
				this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

	//��������ѯ
	public List<Customer> findMore(Customer customer) {
		//��ʽһ��ƴ��hql���
//		String hql = "from Customer where 1=1 ";
//		//����list���ϣ����ֵ��Ϊ�գ���ֵ���õ�list����
//		List<Object> listo = new ArrayList<>();
//		//�ж�
//		if(!"".equals(customer.getCust_name()) && customer.getCust_name()!=null) {
//			hql += " and cust_name=?";
//			listo.add(customer.getCust_name());
//		}
//		if(!"".equals(customer.getCust_level()) && customer.getCust_level()!=null) {
//			hql += " and cust_level=?";
//			listo.add(customer.getCust_level());
//		}
//		if(!"".equals(customer.getCust_industry()) && customer.getCust_industry()!=null) {
//			hql += " and cust_industry=?";
//			listo.add(customer.getCust_industry());
//		}
//		
//		List<Customer> list = (List<Customer>)
//				this.getHibernateTemplate().find(hql, listo.toArray());
		
		//��ʽ�������߶���
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//�ж�ҳ���е�ֵ�Ƿ�Ϊ��
		if(!"".equals(customer.getCust_name()) && customer.getCust_name()!=null) {
			//��������ֵ
		criteria.add(Restrictions.eq("cust_name", customer.getCust_name()));
		}
//		if(!"".equals(customer.getCust_level()) && customer.getCust_level()!=null) {
//			criteria.add(Restrictions.eq("cust_level", customer.getCust_level()));
//		}
		if(!"".equals(customer.getCust_industry()) && customer.getCust_industry()!=null) {
			criteria.add(Restrictions.eq("cust_industry", customer.getCust_industry()));
		}
		
		//��������ѯ
		List<Customer> list = (List<Customer>)
				this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

	//��ѯ����
	public List<Dict> queryLevel() {
		
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}

	//��Դͳ��
	public List countSourse() {
		//����SQL��临�ӣ�hibernate�޷���ɣ���Ҫ���õײ�SQL
		//��ȡsession
		Session session = this.getSessionFactory().getCurrentSession();
		//����SQLQuery����
		SQLQuery sqlQuery = session.createSQLQuery("SELECT COUNT(*) num ,cust_source FROM t_customer GROUP BY cust_source");
		/*
		 * ��Ϊ����ֵ�������ֶΣ�һ���ֶ���id��һ�������ƣ�
		 * ���԰ѷ�������ת��map�ṹ
		 * */
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		//���÷����õ����
		List list = sqlQuery.list();
		return list;
	}

	//����ͳ��
	public List countLevel() {
		//��ȡsession
		Session session = this.getSessionFactory().getCurrentSession();
		//����SQLQuery����
		SQLQuery sqlQuery = session.createSQLQuery("SELECT num,d.dname FROM t_dict d,(SELECT COUNT(*) num,c.cdid\r\n" + 
									"FROM t_customer c,t_dict d WHERE c.cdid=d.dno\r\n" + 
									"GROUP BY cdid) s WHERE s.cdid=d.dno");
		//�ѽ��ת��Ϊmap�ṹ
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		//��������ѯ
		List list = sqlQuery.list();
		return list;
	}

}
