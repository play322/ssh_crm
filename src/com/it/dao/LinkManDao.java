/**
 * 创建时间：2019年8月9日
 * 所在包：com.it.dao.LinkManDao.java
 * 创建者：@author bjx
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
