package org.poom.sap.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
import org.poom.sap.common.util.Paging;
import org.poom.sap.common.util.PagingUtils;
import org.poom.sap.notice.model.service.NoticeService;
import org.poom.sap.notice.model.vo.Notice;

@Controller
@RequestMapping("notice")
public class NoticeController {
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private NoticeService noticeService;

	private PagingUtils pu = new PagingUtils();

	@RequestMapping(value="/noticeList.do", method = RequestMethod.GET)
	public ModelAndView noticeList(Notice notice, ModelAndView mv, Paging npaging, HttpServletRequest request) throws Exception{

		// paging
		int a = 1;
		int b = 1;
		a = noticeService.noticeTC(notice);
		pu.setChangedTotalCount(a);
		pu.setChangedPage(b);
		
		//전달받은 현재 페이지 추출
		if(request.getParameter("page") != null){
			b =Integer.parseInt(request.getParameter("page"));
			pu.setChangedPage(b);
		}
		npaging = pu.noticePaging();
		
		// List 출력(get)
		List<Notice> nlist = noticeService.noticeList(notice, npaging);
		
		mv.setViewName("notice/noticeList");
		
		mv.addObject("nlist", nlist);
		mv.addObject("page", npaging.getPage());
		mv.addObject("countList", npaging.getCountList());
		mv.addObject("countPage", npaging.getCountPage());
		mv.addObject("totalPage", npaging.getTotalPage());
		mv.addObject("startPage", npaging.getStartPage());
		mv.addObject("endPage", npaging.getEndPage());
		
		System.out.println(npaging);

		return mv;
	}


	@RequestMapping(value="/noticeDetail.do", method = RequestMethod.GET)
	public ModelAndView noticeDetail(int notice_no, ModelAndView mv, HttpServletRequest request) throws Exception {

		List<Notice> nlist = noticeService.noticeDetail(notice_no);

		//redirect 하려면 .do 여야 함
		mv.setViewName("notice/noticeDetail");
		mv.addObject("nlist", nlist);

		return mv;
	}

	@RequestMapping(value="/noticeInsert.do", method=RequestMethod.GET)
	public String noticeInsertForm() {

		return "notice/noticeInsert";
	}

	@RequestMapping(value="/nInsert.do", method = RequestMethod.POST)
	public ModelAndView noticeInsert(Notice notice, ModelAndView mv
			,HttpServletRequest request, HttpSession session) throws Exception{

		String path = request.getRealPath("/file");
		int num = notice.getNotice_no();
		String filename = notice.getNotice_file().getOriginalFilename();

		try {
			notice.getNotice_file().transferTo(new File(path+"/"+num+"_"+filename));
		}catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(path+"/"+num+"_"+filename);
		notice.setNotice_filepath(path+"/"+num+"_"+filename);

		//서비스 메소드 실행하고, 결과 받기
		noticeService.noticeInsert(notice);
		//받은 결과에 따라 뷰 선택
		mv.setViewName("redirect:/notice/noticeList.do");

		return mv;
	}


	@RequestMapping(value="/nDelete.do", method = RequestMethod.GET)
	public ModelAndView noticeDelete(Notice notice, ModelAndView mv) throws Exception{

		//서비스 메소드 실행하고, 결과 받기
		noticeService.noticeDelete(notice);
		//받은 결과에 따라 뷰 선택
		mv.setViewName("redirect:/notice/noticeList.do");

		return mv;
	}

	@RequestMapping(value="/noticeUpdate.do", method=RequestMethod.POST)
	public ModelAndView noticeUpdateForm(int notice_no, ModelAndView mv, HttpServletRequest request) throws Exception {

		List<Notice> nlist = noticeService.noticeDetail(notice_no);

		mv.setViewName("notice/noticeUpdate");
		mv.addObject("nlist", nlist);

		return mv;
	}

	@RequestMapping(value="/nUpdate.do", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(Notice notice, ModelAndView mv) throws Exception{

		//서비스 메소드 실행하고, 결과 받기
		noticeService.noticeUpdate(notice);
		//받은 결과에 따라 뷰 선택
		mv.setViewName("redirect:/notice/noticeList.do");

		return mv;
	}

}
