package org.poom.sap.notice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.poom.sap.notice.model.service.NoticeService;
import org.poom.sap.notice.model.vo.Notice;


@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

/*	@RequestMapping(value="/nInsert.do")
	public ModelAndView noticeInsert(Map<String,Object> map, ModelAndView mv) throws Exception{

		//서비스 메소드 실행하고, 결과 받기
		List<Map<String,Object>> nlist = noticeService.noticeInsert(map);
		//받은 결과에 따라 뷰 선택
		mv.setViewName("notice/notice");
		//mv = new ModelAndView("notice");

		mv.addObject("nlist", nlist);

		return mv;
	}*/
	
	@RequestMapping(value="/nInsert.do")
	public ModelAndView noticeInsert(Notice notice, ModelAndView mv) throws Exception{

		//서비스 메소드 실행하고, 결과 받기
		ArrayList<Notice> nlist = noticeService.noticeInsert(notice);
		//받은 결과에 따라 뷰 선택
		mv.setViewName("notice/notice");
		/*mv = new ModelAndView("notice");*/

		mv.addObject("nlist", nlist);

		return mv;
	}
	
	
	@RequestMapping("/nDetail.do")
	public ModelAndView noticeDetail(int notice_no, ModelAndView mv, HttpServletRequest request) throws Exception {
		
		System.out.println("controller : " + notice_no);
		
		List<Notice> nlist = noticeService.noticeDetail(notice_no);
		
		mv.setViewName("notice/noticeDetailView");
		
		
		mv.addObject("nlist", nlist);
		
		return mv;
	}
	
	
}
