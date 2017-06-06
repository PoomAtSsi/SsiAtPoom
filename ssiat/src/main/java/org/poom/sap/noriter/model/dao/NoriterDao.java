package org.poom.sap.noriter.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.poom.sap.common.util.Paging;
import org.poom.sap.noriter.model.vo.Noriter;
import org.poom.sap.notice.model.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("noriterDao")
public class NoriterDao {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public NoriterDao(){}
	
	@SuppressWarnings("unchecked")
	public List<Noriter> noriterList(Noriter noriter, Paging paging, int category) throws Exception {
		Map map = new HashMap();
		int start = ((paging.getPage() -1 ) * 10) + 1;
		int end = (paging.getPage() * 10);
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
		map.put("noriter", noriter);
		map.put("start", start);
		map.put("end", end);
		map.put("category", category);
		
		// category가 1일 경우, 전체 출력
		return (List<Noriter>) sqlSession.selectList("noriterList", map);
	}

	@SuppressWarnings("unchecked")
	public List<Noriter> noriterDetail(int classNo) throws Exception {
		
		return (List<Noriter>) sqlSession.selectList("noriterDetail", classNo);
		
		//return (List<Noriter>) sqlSession.selectOne("noriterDetail", noriter_no); 일때는 자바빈즈의 Noriter를 java.util.ArrayList화 시킬 수 없다고 나왔다.
		//근데 selectList하니까 됬음.
	}

	public void noriterInsert(Noriter noriter) {
		sqlSession.insert("noriterInsert", noriter);
	}

	public void noriterDelete(Noriter noriter) {
		sqlSession.update("noriterDelete", noriter);
	}

	public void noriterUpdate(Noriter noriter) {
		sqlSession.update("noriterUpdate", noriter);
	}
	
	public int noriterTC(Noriter noriter) {
		return  (Integer) sqlSession.selectOne("noriterTC", noriter);
	}

}
