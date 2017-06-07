package org.poom.sap.notice.model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.apache.log4j.Logger;
import org.poom.sap.common.util.Paging;
import org.poom.sap.notice.model.dao.NoticeDao;
import org.poom.sap.notice.model.vo.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	NoticeDao noticeDao;


	@Override
	public List<Notice> noticeList(Notice notice, Paging paging) throws Exception {
		return (List<Notice>) noticeDao.noticeList(notice, paging);
	}

	@Override
	public List<Notice> noticeDetail(int notice_no) throws Exception {
		return noticeDao.noticeDetail(notice_no);
	}

	@Override
	public void noticeInsert(Notice notice) throws Exception {
		noticeDao.noticeInsert(notice);
	}

	@Override
	public void noticeDelete(Notice notice) throws Exception {
		noticeDao.noticeDelete(notice);
	}

	@Override
	public void noticeUpdate(Notice notice) throws Exception {
		noticeDao.noticeUpdate(notice);		
	}

	@Override
	public int noticeTC(Notice notice) {
		return noticeDao.noticeTC(notice);
	}

	@Override
	public List<Notice> brandnewNotice(Notice notice) {
		return noticeDao.brandnewNotice(notice);
	}


}
