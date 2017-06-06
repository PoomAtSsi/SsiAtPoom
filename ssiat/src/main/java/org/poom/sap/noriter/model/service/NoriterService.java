package org.poom.sap.noriter.model.service;

import java.util.List;

import org.poom.sap.common.util.Paging;
import org.poom.sap.noriter.model.vo.Noriter;
import org.poom.sap.notice.model.vo.Notice;

public interface NoriterService {

	List<Noriter> noriterList(Noriter noriter, Paging paging, int category) throws Exception;

	List<Noriter> noriterDetail(int classNo) throws Exception;
	
	void noriterInsert(Noriter noriter) throws Exception;

	void noriterDelete(Noriter noriter) throws Exception;

	void noriterUpdate(Noriter noriter) throws Exception;
	
	int noriterTC(Noriter noriter);
}
