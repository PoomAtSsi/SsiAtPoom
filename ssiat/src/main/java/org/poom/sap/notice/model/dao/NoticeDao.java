package org.poom.sap.notice.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.poom.sap.common.util.Paging;
import org.poom.sap.notice.model.vo.Notice;

@Repository("noticeDao")
public class NoticeDao {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public NoticeDao(){}

	@SuppressWarnings("unchecked")
	public List<Notice> noticeList(Notice notice, Paging paging) throws Exception {
		Map map = new HashMap();
		int start = ((paging.getPage() -1 ) * 10) + 1;
		int end = (paging.getPage() * 10);
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
//		map.put("notice", notice);
		map.put("start", start);
		map.put("end", end);
		
		return  (List<Notice>) sqlSession.selectList("noticeList", map);
		
		
//		return (List<Notice>) sqlSession.selectList("noticeList", notice);
	}

	@SuppressWarnings("unchecked")
	public List<Notice> noticeDetail(int notice_no) throws Exception {
		
		return (List<Notice>) sqlSession.selectList("noticeDetail", notice_no);
		
		//return (List<Notice>) sqlSession.selectOne("noticeDetail", notice_no); 일때는 자바빈즈의 Notice를 java.util.ArrayList화 시킬 수 없다고 나왔다.
		//근데 selectList하니까 됬음.
	}

	public void noticeInsert(Notice notice) {
		sqlSession.insert("noticeInsert", notice);
	}
	
//	public void noticeInsertFile(Map<String, Object> map) throws Exception{
//		sqlSession.insert("noticeInsertFile", map);
//	}
	
	public void noticeDelete(Notice notice) {
		sqlSession.update("noticeDelete", notice);
	}

	public void noticeUpdate(Notice notice) {
		sqlSession.update("noticeUpdate", notice);
	}

	public int noticeTC(Notice notice) {
		return  (Integer) sqlSession.selectOne("noticeTC", notice);
	}

	public List<Notice> brandnewNotice(Notice notice) {
		return (List<Notice>) sqlSession.selectList("brandnewNotice", notice);
	}

}
