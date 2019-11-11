/**
 * 创建时间：2019年8月7日
 * 所在包：com.it.dao.CustomerDaoImpl.java
 * 创建者：@author bjx
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

	//添加客户
	public void add(Customer customer) {
		
		this.getHibernateTemplate().save(customer);
		
	}

	//查询所有
	public List<Customer> queryAll() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		
		if(list!=null && list.size()!=0) {
			
			return list;
		}
		
		return null;
	}

	//单个查询
	public Customer findById(Customer customer) {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where cust_id=?",customer.getCust_id());
		if(list!=null && list.size()!=0) {
			Customer customer1 = list.get(0);
			return customer1 ;
		}
		return null;
	}

	//删除操作
	public void del(Customer customer) {
		this.getHibernateTemplate().delete(customer);
		
	}

	//修改
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
		
	}

	//查询总记录数
	public int findCount() {
		//调用hibernateTemplate里面的find方法实现
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer ");
		if(list!=null && list.size()!=0) {
			Object obj = list.get(0);
			//转化为long类型
			Long lobj = (Long) obj;
			//转化为int
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	//查询分页的集合
	public List<Customer> findPage(int begin, int pageSize) {
		/**
		 * //第一种 使用hibernate底层代码实现（了解）
		//得到sessionFactory
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//得到session对象
		Session session = sessionFactory.getCurrentSession();
		//设置分页信息
		Query query = session.createQuery("from Customer");
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Customer> list = query.list();
		 */
		
		//第二种使用离线对象和hibernateTemplate的方法实现
		//1 创建离线对象，设置对哪个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//调用hibernateTemplate的方法实现
//		第一个参数是离线对象
//		第二个参数是开始位置
//		第三个参数是每页记录数
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//条件查询
	public List<Customer> findCondition(Customer customer) {
		//第一种方式： 
//		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//得到session对象
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from Customer where custName like ?");
//		query.setParameter(0, "%"+customer.getCustName()+"%");
//		List<Customer> list = query.list();
		
		//第二种方式 ： 调用hibernateTemplate的find方法实现
//		List<Customer> list = 
//				(List<Customer>) this.getHibernateTemplate().find("from Customer where cust_name like ?","%"+customer.getCust_name()+"%" );
		
		//第三种方式：离线对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//设置操作那个属性
		criteria.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
		//调用方法
		List<Customer> list = (List<Customer>) 
				this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

	//多条件查询
	public List<Customer> findMore(Customer customer) {
		//方式一：拼接hql语句
//		String hql = "from Customer where 1=1 ";
//		//创建list集合，如果值不为空，把值设置到list里面
//		List<Object> listo = new ArrayList<>();
//		//判断
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
		
		//方式二：离线对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//判断页面中的值是否为空
		if(!"".equals(customer.getCust_name()) && customer.getCust_name()!=null) {
			//设置属性值
		criteria.add(Restrictions.eq("cust_name", customer.getCust_name()));
		}
//		if(!"".equals(customer.getCust_level()) && customer.getCust_level()!=null) {
//			criteria.add(Restrictions.eq("cust_level", customer.getCust_level()));
//		}
		if(!"".equals(customer.getCust_industry()) && customer.getCust_industry()!=null) {
			criteria.add(Restrictions.eq("cust_industry", customer.getCust_industry()));
		}
		
		//调方法查询
		List<Customer> list = (List<Customer>)
				this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

	//查询级别
	public List<Dict> queryLevel() {
		
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}

	//来源统计
	public List countSourse() {
		//由于SQL语句复杂，hibernate无法完成，故要调用底层SQL
		//获取session
		Session session = this.getSessionFactory().getCurrentSession();
		//生成SQLQuery对象
		SQLQuery sqlQuery = session.createSQLQuery("SELECT COUNT(*) num ,cust_source FROM t_customer GROUP BY cust_source");
		/*
		 * 因为返回值有两个字段，一个字段是id，一个是名称，
		 * 所以把返回数据转换map结构
		 * */
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		//调用方法得到结果
		List list = sqlQuery.list();
		return list;
	}

	//级别统计
	public List countLevel() {
		//获取session
		Session session = this.getSessionFactory().getCurrentSession();
		//创建SQLQuery对象
		SQLQuery sqlQuery = session.createSQLQuery("SELECT num,d.dname FROM t_dict d,(SELECT COUNT(*) num,c.cdid\r\n" + 
									"FROM t_customer c,t_dict d WHERE c.cdid=d.dno\r\n" + 
									"GROUP BY cdid) s WHERE s.cdid=d.dno");
		//把结果转化为map结构
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		//调方法查询
		List list = sqlQuery.list();
		return list;
	}

}
