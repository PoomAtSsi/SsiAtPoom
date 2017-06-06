package org.poom.sap.common.util;

public class Paging implements java.io.Serializable{

	private int page;					// 현재 페이지 번호
	private int countList;				// 한 페이지에 출력될 게시물 수
	private int countPage;				// 한 화면에 출력될 페이지 수
	private int totalCount;			// 전체 게시글 글 수
	private int totalPage;		// 전체 페이지 수
	
	private int startPage;		// 첫번째 페이지 번호
	private int endPage;		// 끝 페이지 (페이징 너비 기준)


	public Paging(){}
	
	public Paging(int page, int countList, int countPage, 
			int totalCount, int totalPage) {
		super();
		this.page = page;
		this.countList = countList;
		this.countPage = countPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}
	
	public Paging(int countList, int countPage, 
			int totalCount, int totalPage) {
		super();
		this.countList = countList;
		this.countPage = countPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCountList() {
		return countList;
	}

	public void setCountList(int countList) {
		this.countList = countList;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "Paging [page=" + page + ", countList=" + countList + ", countPage=" + countPage + ", totalCount="
				+ totalCount + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
}


