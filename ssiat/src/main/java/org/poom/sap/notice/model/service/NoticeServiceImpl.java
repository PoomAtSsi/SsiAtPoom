package org.poom.sap.notice.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.poom.sap.notice.model.dao.NoticeDao;
import org.poom.sap.notice.model.vo.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	NoticeDao noticeDao;

	/*@Override
	public List<Notice> noticeInsert() {
		System.out.println("service : noticeInsert run...");
		return noticeDao.noticeInsert();
		
	}*/

	@Override
	public ArrayList<Notice> noticeList(Notice notice) throws Exception {
		return noticeDao.noticeList(notice);
	}

	@Override
	public List<Notice> noticeDetail(int notice_no) throws Exception {
		/*noticeDao.updateViewsCnt(map);*/
		
		return noticeDao.noticeDetail(notice_no);
	}

	@Override
	public List<Map<String, Object>> noticeInsert2(Map<String, Object> map) throws Exception {
		return noticeDao.noticeInsert2(map);
	}

	
	@Override
	public int noticeInsert(Notice notice) throws Exception {
		return noticeDao.noticeInsert(notice);
	}
	
	

}
