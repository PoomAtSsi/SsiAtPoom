package org.poom.sap.ggiri.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.poom.sap.ggiri.model.dao.GgiriDao;
import org.poom.sap.ggiri.model.vo.Ggiri;
import org.poom.sap.notice.model.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ggiriService")
@Transactional
public class GgiriServiceImpl implements GgiriService{
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	GgiriDao ggiriDao;
	
	@Override
	public List<Ggiri> ggiriList(Ggiri ggiri) throws Exception{
		log.debug("gser");
		return ggiriDao.ggiriList(ggiri);
	}
	
	@Override
	public List<Ggiri> categoryGgiri(Ggiri ggiri)throws Exception{
		return ggiriDao.CategoryGgiri(ggiri);
	}
	
	@Override
	public List<Ggiri> ggiriDetail(int g_no) throws Exception{
		//System.out.println("gs");
		return (List<Ggiri>)ggiriDao.ggiriDetail(g_no);
	}
	
	@Override
	public int ggiriInsert(Ggiri ggiri) throws Exception {
		return ggiriDao.ggiriInsert(ggiri);
	}
	
	@Override
	public int ggiriUpdate(Ggiri ggiri)throws Exception{
		return ggiriDao.ggiriUpdate(ggiri);
	}
	
	@Override
	public void ggiriDelete(int g_no) throws Exception{
		 ggiriDao.ggiriDelete(g_no);
	}
	
	//끼리 신청
	@Override
	@Transactional
	public void ggiriJoin(Ggiri ggiri, int g_no)throws Exception{
		ggiriDao.ggiriJoin(ggiri);
		ggiriDao.ggiriJoin2(g_no);
	}
	
	//끼리 신청한 사람
	@Override
	public List<Ggiri> joinedGgiri(int g_j_no)throws Exception{
		return ggiriDao.joinedggiri(g_j_no);
	}
	
	@Override
	public void likeGgiri(Ggiri ggiri, int g_no)throws Exception{
		ggiriDao.likeGgiri(ggiri);
		ggiriDao.likeGgiriCount(g_no);
	}
	
	@Override
	public void unlikeGgiri(Ggiri ggiri, int g_no)throws Exception{
		ggiriDao.unlikeGgiri(ggiri);
		ggiriDao.likeGgiriCount(g_no);
	}
	
	@Override
	public List<Ggiri> ggiriProfile(Ggiri ggiri)throws Exception{
		return ggiriDao.ggiriProfile(ggiri);
	}
}
