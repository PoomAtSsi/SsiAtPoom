package com.kh.sample.notice.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sample.notice.model.vo.Notice;

@Repository("noticeDao")
public class NoticeDao {
	
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
	public ArrayList<Notice> noticeInsert(Notice notice) throws Exception {
		return (ArrayList<Notice>) sqlSession.selectList("noticeInsert", notice);
	}

	@SuppressWarnings("unchecked")
	public List<Notice> noticeDetail(int notice_no) throws Exception {
		
		System.out.println("noticeDao : " + notice_no);
		
		return (List<Notice>) sqlSession.selectList("noticeDetail", notice_no);
		
		//return (List<Notice>) sqlSession.selectOne("noticeDetail", notice_no); 일때는 자바빈즈의 Notice를 java.util.ArrayList화 시킬 수 없다고 나왔다.
		//근데 selectList하니까 됬음.
	}
	
	/*public void updateViewsCnt(Map<String, Object> map) throws Exception{
		sqlSession.update("noticeUpdateViewsCnt", map);
	}*/




	
}
