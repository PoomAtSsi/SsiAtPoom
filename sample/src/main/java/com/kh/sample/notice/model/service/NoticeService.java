package com.kh.sample.notice.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.sample.notice.model.vo.Notice;

public interface NoticeService {
//	List<Notice> noticeInsert();
	
	ArrayList<Notice> noticeInsert(Notice notice) throws Exception;

	List<Notice> noticeDetail(int notice_no) throws Exception;


	
}