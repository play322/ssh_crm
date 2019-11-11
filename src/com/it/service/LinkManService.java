/**
 * ����ʱ�䣺2019��8��9��
 * ���ڰ���com.it.service.LinkManService.java
 * �����ߣ�@author bjx
 */
package com.it.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.it.bean.LinkMan;
import com.it.dao.LinkManDao;

@Transactional
public class LinkManService {
	
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	public void addLinkMan(LinkMan linkMan) {
		linkManDao.addLinkMan(linkMan);
		
	}
	public List<LinkMan> queryAll() {
		// TODO Auto-generated method stub
		return linkManDao.queryAll();
	}
	public LinkMan findById(LinkMan linkMan) {
		// TODO Auto-generated method stub
		return linkManDao.findById(linkMan);
	}
	public void update(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.update(linkMan);
	}
	public void delLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.delLinkMan(linkMan);
	}
	public List<LinkMan> findConditin(LinkMan linkMan) {
		// TODO Auto-generated method stub
		return linkManDao.findCondition(linkMan);
	}
	public List<LinkMan> moreQuery(LinkMan linkMan) {
		// TODO Auto-generated method stub
		return linkManDao.moreQuery(linkMan);
	}
	

}
