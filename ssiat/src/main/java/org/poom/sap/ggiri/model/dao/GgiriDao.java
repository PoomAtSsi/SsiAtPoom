package org.poom.sap.ggiri.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.poom.sap.ggiri.model.vo.Ggiri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ggiriDao")
public class GgiriDao {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public GgiriDao(){}

	@SuppressWarnings("unchecked")
	public List<Ggiri> ggiriList(Ggiri ggiri) {
		// TODO Auto-generated method stub
		log.debug("gdao");
		return (List<Ggiri>) sqlSession.selectList("ggiriList");
	}
	
	public List<Ggiri> CategoryGgiri(Ggiri ggiri){
		return (List<Ggiri>) sqlSession.selectList("categoryGgiri", ggiri);
	}

	@SuppressWarnings("unchecked")
	public List<Ggiri> ggiriDetail(int g_no) {
		// TODO Auto-generated method stub
		//System.out.println("gdao");
		return (List<Ggiri>) sqlSession.selectList("ggiriDetail",g_no);
	}
	
	public int ggiriInsert(Ggiri ggiri){
		return sqlSession.insert("ggiriInsert", ggiri);
	}
	
	public int ggiriUpdate(Ggiri ggiri){
		 return sqlSession.update("ggiriUpdate", ggiri);
		 
	}
	
	public void ggiriDelete(int g_no){
		 sqlSession.update("ggiriDelete", g_no);
	}
	//끼리 신청하기
	public void ggiriJoin(Ggiri ggiri){
		sqlSession.insert("ggiriJoin", ggiri);
	}
	public void ggiriJoin2(int g_no){
		sqlSession.update("ggiriJoinCount",g_no);
	}
	
	//끼리 신청한사람 리스트
	public List<Ggiri> joinedggiri(int g_j_no){
		return (List<Ggiri>) sqlSession.selectList("joinedGgiri", g_j_no);
	}
	
	//끼리 즐겨찾기
	public void likeGgiri(Ggiri ggiri){
		sqlSession.insert("likeGgiri", ggiri);
	}
	
	public void likeGgiriCount(int g_no){
		sqlSession.update("likeGgiriCount", g_no);
	}
	
	public void unlikeGgiri(Ggiri ggiri){
		sqlSession.delete("unlikeGgiri", ggiri);
	}
	
	public List<Ggiri> ggiriProfile(Ggiri ggiri){
		return (List<Ggiri>) sqlSession.selectList("memberProfile", ggiri);
	}
	
	public ArrayList<Ggiri> myGgiri(Ggiri ggiri){
		return (ArrayList<Ggiri>) sqlSession.selectList("myGgiri", ggiri);
	}

}
