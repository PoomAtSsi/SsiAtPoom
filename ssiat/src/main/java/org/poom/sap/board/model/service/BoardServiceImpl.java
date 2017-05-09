package org.poom.sap.board.model.service;

import org.poom.sap.board.model.vo.Board;
import org.poom.sap.board.model.dao.BoardDao;

import java.util.ArrayList;
import java.util.List;

import org.poom.sap.board.model.dao.BoardDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BoardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDao boardDao;

	/*@Override
	public List<Notice> boardInsert() {
		System.out.println("service : boardInsert run...");
		return boardDao.boardInsert();
		
	}*/

	@Override
	public ArrayList<Board> boardInsert(Board board) throws Exception {
		return boardDao.boardInsert(board);
	}

	@Override
	public List<Board> boardDetail(int board_no) throws Exception {
		/*boardDao.updateViewsCnt(map);*/
		
		System.out.println("boardService : " + board_no);
		
		return boardDao.boardDetail(board_no);
	}
	
	

}
