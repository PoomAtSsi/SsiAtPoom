package org.poom.sap.notice.model.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.poom.sap.common.util.Paging;
import org.poom.sap.notice.model.vo.Notice;

public interface NoticeService {
	
	List<Notice> noticeList(Notice notice, Paging npaging) throws Exception;

	List<Notice> noticeDetail(int notice_no) throws Exception;
	
	void noticeInsert(Notice notice) throws Exception;

	void noticeDelete(Notice notice) throws Exception;

	void noticeUpdate(Notice notice) throws Exception;

	int noticeTC(Notice notice);

	List<Notice> brandnewNotice(Notice notice);

	
}
