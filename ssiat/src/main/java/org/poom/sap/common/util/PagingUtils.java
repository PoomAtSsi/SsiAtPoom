package org.poom.sap.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.poom.sap.common.util.Paging;

public class PagingUtils {
	
	private int changedPage;
	private int changedTotalCount;
	
	@Autowired
	private Paging npaging;
	
	public PagingUtils(){}
	
	public Paging noticePaging() throws Exception{
		
		npaging = new Paging();
		
		int totalCount = 0;
		totalCount = changedTotalCount;
		
		int page = 1;
		if(changedPage != 0){
			page = changedPage;
		}
		System.out.println("page : " + page);
		
		npaging.setPage(page);	// 현재 페이지 번호
		int countList = 10;				// 한 페이지에 출력될 게시물 수
		npaging.setCountList(countList);
		int countPage = 10;				// 한 화면에 출력될 페이지 수
		npaging.setCountPage(countPage); 
		
		npaging.setTotalCount(totalCount);			// 전체 게시글 글 수
		int totalPage = totalCount / countList;		// 전체 페이지 수
		npaging.setTotalPage(totalPage);
		
		int startPage = ((page - 1) / 10) * 10 + 1;		// 첫번째 페이지 번호
		npaging.setStartPage(startPage);
		int endPage = startPage + countPage - 1;		// 끝 페이지 (페이징 너비 기준)
		npaging.setEndPage(endPage);
		
		
		if (totalCount % countList > 0) {
			totalPage++;
			npaging.setTotalPage(totalPage);
		}

		if (totalPage < page) {
			page = totalPage;
			npaging.setPage(page);
		}
		

		if (endPage > totalPage) {
			endPage = totalPage;
			npaging.setEndPage(endPage);
		}

		if (startPage > 1) {
			System.out.println("<a href=\"?page=1\">처음</a>");
		}

		if (page > 1) {
			System.out.println("<a href=\"?page=" + (page - 1) + "\">이전</a>");
		}
		
		

		for (int iCount = startPage; iCount <= endPage; iCount++) {
			if (iCount == page) {
				System.out.println(" <b>" + iCount + "</b>");
			} else {
				System.out.println(" " + iCount + " ");
			}
		}

		if (page < totalPage) {
			System.out.println("<a href=\"?page=" + (page + 1) + "\">다음</a>");
		}

		if (endPage < totalPage) {
			System.out.println("<a href=\"?page=" + totalPage + "\">끝</a>");
		}
		
		return npaging;
	}
	
	public Paging noriterPaging() throws Exception{
		
		npaging = new Paging();
		
		int totalCount = 0;
		totalCount = changedTotalCount;
		
		int page = 1;
		if(changedPage != 0){
			page = changedPage;
		}
		System.out.println("page : " + page);
		
		npaging.setPage(page);	// 현재 페이지 번호
		int countList = 10;				// 한 페이지에 출력될 게시물 수
		npaging.setCountList(countList);
		int countPage = 10;				// 한 화면에 출력될 페이지 수
		npaging.setCountPage(countPage); 
		
		npaging.setTotalCount(totalCount);			// 전체 게시글 글 수
		int totalPage = totalCount / countList;		// 전체 페이지 수
		npaging.setTotalPage(totalPage);
		
		int startPage = ((page - 1) / 10) * 10 + 1;		// 첫번째 페이지 번호
		npaging.setStartPage(startPage);
		int endPage = startPage + countPage - 1;		// 끝 페이지 (페이징 너비 기준)
		npaging.setEndPage(endPage);
		
		
		if (totalCount % countList > 0) {
			totalPage++;
			npaging.setTotalPage(totalPage);
		}
		
		if (totalPage < page) {
			page = totalPage;
			npaging.setPage(page);
		}
		
		
		if (endPage > totalPage) {
			endPage = totalPage;
			npaging.setEndPage(endPage);
		}
		
		if (startPage > 1) {
			System.out.println("<a href=\"?page=1\">처음</a>");
		}
		
		if (page > 1) {
			System.out.println("<a href=\"?page=" + (page - 1) + "\">이전</a>");
		}
		
		
		
		for (int iCount = startPage; iCount <= endPage; iCount++) {
			if (iCount == page) {
				System.out.println(" <b>" + iCount + "</b>");
			} else {
				System.out.println(" " + iCount + " ");
			}
		}
		
		if (page < totalPage) {
			System.out.println("<a href=\"?page=" + (page + 1) + "\">다음</a>");
		}
		
		if (endPage < totalPage) {
			System.out.println("<a href=\"?page=" + totalPage + "\">끝</a>");
		}
		
		return npaging;
	}

	public int getChangedPage() {
		return changedPage;
	}

	public void setChangedPage(int changedPage) {
		this.changedPage = changedPage;
	}

	public int getChangedTotalCount() {
		return changedTotalCount;
	}

	public void setChangedTotalCount(int changedTotalCount) {
		this.changedTotalCount = changedTotalCount;
	}

	
}
