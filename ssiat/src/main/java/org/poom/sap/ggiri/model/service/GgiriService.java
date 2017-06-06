package org.poom.sap.ggiri.model.service;

import java.util.ArrayList;
import java.util.List;

import org.poom.sap.ggiri.model.vo.Ggiri;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface GgiriService {
	List<Ggiri> ggiriList(Ggiri ggiri) throws Exception;

	List<Ggiri> categoryGgiri(Ggiri ggiri) throws Exception;
	
	List<Ggiri> ggiriDetail(int g_no) throws Exception;
	
	int ggiriInsert(Ggiri ggiri) throws Exception;
	
	int ggiriUpdate(Ggiri ggiri)throws Exception;

	void ggiriDelete(int g_no) throws Exception;
	
	void ggiriJoin(Ggiri ggiri,int g_no) throws Exception;
	
	List<Ggiri> joinedGgiri(int g_j_no)throws Exception;
	
	void likeGgiri(Ggiri ggiri, int g_no)throws Exception;
	
	void unlikeGgiri(Ggiri ggiri, int g_no)throws Exception;

	/*void ggiriDetail2(String string)throws Exception;*/
	
	List<Ggiri> ggiriProfile(Ggiri ggiri) throws Exception;
	
	ArrayList<Ggiri> myGgiri(Ggiri ggiri)throws Exception;
	
}
