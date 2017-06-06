package org.poom.sap.noriter.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.poom.sap.common.util.Paging;
import org.poom.sap.noriter.model.dao.NoriterDao;
import org.poom.sap.noriter.model.vo.Noriter;
import org.poom.sap.notice.model.vo.Notice;

@Service("noriterService")
public class NoriterServiceImpl implements NoriterService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	NoriterDao noriterDao;

	@Override
	public List<Noriter> noriterList(Noriter noriter, Paging paging, int category) throws Exception {
		return noriterDao.noriterList(noriter, paging, category);
	}

	@Override
	public List<Noriter> noriterDetail(int classNo) throws Exception {
		return noriterDao.noriterDetail(classNo);
	}

	@Override
	public void noriterInsert(Noriter noriter) throws Exception {
		noriterDao.noriterInsert(noriter);
	}

	@Override
	public void noriterDelete(Noriter noriter) throws Exception {
		noriterDao.noriterDelete(noriter);
	}

	@Override
	public void noriterUpdate(Noriter noriter) throws Exception {
		noriterDao.noriterUpdate(noriter);		
	}
	
	@Override
	public int noriterTC(Noriter noriter) {
		return noriterDao.noriterTC(noriter);
	}
	
	

}
