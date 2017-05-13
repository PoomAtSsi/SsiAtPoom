package org.poom.sap.board.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.poom.sap.AbstractDao;
import org.poom.sap.board.model.vo.Board;

@Repository("BoardDao")
public class BoardDao extends AbstractDao {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public BoardDao(){}

	/*
	public List<Board> BoardInsert() {
		 System.out.println("dao : selectLogin run...");
		return qlSession.selectList("BoardInsert");
	}*/
	
	/*@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>) sqlSession.selectList("BoardInsert", map);
    }*/

	@SuppressWarnings("unchecked")
	public ArrayList<Board> boardInsert(Board Board) throws Exception {
		return (ArrayList<Board>) sqlSession.selectList("BoardInsert", Board);
	}

	@SuppressWarnings("unchecked")
	public List<Board> boardDetail(int Board_no) throws Exception {
		
		System.out.println("BoardDao : " + Board_no);
		
		return (List<Board>) sqlSession.selectList("BoardDetail", Board_no);
		
		//return (List<Board>) sqlSession.selectOne("BoardDetail", Board_no); 일때는 자바빈즈의 Board를 java.util.ArrayList화 시킬 수 없다고 나왔다.
		//근데 selectList하니까 됬음.
	}
	
	/*public void updateViewsCnt(Map<String, Object> map) throws Exception{
		sqlSession.update("BoardUpdateViewsCnt", map);
	}*/




	
}
