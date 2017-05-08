package com.kh.sample.notice.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sample.notice.model.dao.NoticeDao;
import com.kh.sample.notice.model.vo.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	NoticeDao noticeDao;

	/*@Override
	public List<Notice> noticeInsert() {
		System.out.println("service : noticeInsert run...");
		return noticeDao.noticeInsert();
		
	}*/

	@Override
	public ArrayList<Notice> noticeInsert(Notice notice) throws Exception {
		return noticeDao.noticeInsert(notice);
	}

	@Override
	public List<Notice> noticeDetail(int notice_no) throws Exception {
		/*noticeDao.updateViewsCnt(map);*/
		
		System.out.println("noticeService : " + notice_no);
		
		return noticeDao.noticeDetail(notice_no);
	}
	
	

}
