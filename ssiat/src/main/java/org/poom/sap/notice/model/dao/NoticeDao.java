package org.poom.sap.notice.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.poom.sap.notice.model.vo.Notice;

@Repository("noticeDao")
public class NoticeDao {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public NoticeDao(){}

	/*
	public List<Notice> noticeInsert() {
		 System.out.println("dao : selectLogin run...");
		return qlSession.selectList("noticeInsert");
	}*/
	
	/*@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>) sqlSession.selectList("noticeInsert", map);
    }*/

	@SuppressWarnings("unchecked")
	public ArrayList<Notice> noticeList(Notice notice) throws Exception {
		return (ArrayList<Notice>) sqlSession.selectList("noticeList", notice);
	}
	public List<Map<String, Object>> noticeInsert2(Map<String, Object> map) {
		return (List<Map<String, Object>>) sqlSession.selectList("noticeInsert2", map);
	}

	@SuppressWarnings("unchecked")
	public List<Notice> noticeDetail(int notice_no) throws Exception {
		
		return (List<Notice>) sqlSession.selectList("noticeDetail", notice_no);
		
		//return (List<Notice>) sqlSession.selectOne("noticeDetail", notice_no); 일때는 자바빈즈의 Notice를 java.util.ArrayList화 시킬 수 없다고 나왔다.
		//근데 selectList하니까 됬음.
	}

	public int noticeInsert(Notice notice) {
		return sqlSession.insert("noticeInsert", notice);
	}
	
	/*public void updateViewsCnt(Map<String, Object> map) throws Exception{
		sqlSession.update("noticeUpdateViewsCnt", map);
	}*/




	
}
