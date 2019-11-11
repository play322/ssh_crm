/**
 * ����ʱ�䣺2019��8��9��
 * ���ڰ���com.it.dao.LinkManDao.java
 * �����ߣ�@author bjx
 */
package com.it.dao;

import java.util.List;

import com.it.bean.LinkMan;

public interface LinkManDao {

	void addLinkMan(LinkMan linkMan);

	List<LinkMan> queryAll();

	LinkMan findById(LinkMan linkMan);

	void update(LinkMan linkMan);

	void delLinkMan(LinkMan linkMan);

	List<LinkMan> findCondition(LinkMan linkMan);

	List<LinkMan> moreQuery(LinkMan linkMan);

}
