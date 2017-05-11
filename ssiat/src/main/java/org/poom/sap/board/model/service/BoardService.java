package org.poom.sap.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.poom.sap.board.model.vo.Board;

public interface BoardService {
	ArrayList<Board> boardInsert(Board board) throws Exception;

	List<Board> boardDetail(int board_no) throws Exception;

}
