package org.poom.sap.notice.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.poom.sap.notice.model.vo.Notice;

public interface NoticeService {
//	List<Notice> noticeInsert();
	
	ArrayList<Notice> noticeList(Notice notice) throws Exception;

	List<Notice> noticeDetail(int notice_no) throws Exception;
	
	List<Map<String, Object>> noticeInsert2(Map<String, Object> map) throws
	Exception;

	int noticeInsert(Notice notice) throws Exception;

	
}
