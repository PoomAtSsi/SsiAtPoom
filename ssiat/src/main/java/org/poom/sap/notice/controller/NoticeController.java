package org.poom.sap.notice.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import first.common.common.CommandMap;

import org.apache.log4j.Logger;
import org.poom.sap.notice.model.service.NoticeService;
import org.poom.sap.notice.model.vo.Notice;


@Controller
@RequestMapping("notice")
public class NoticeController {
	Logger log = Logger.getLogger(this.getClass());

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


	/*@RequestMapping(value="/testMapArgumentResolver.do")
	public ModelAndView noticeInsert(CommandMap commandMap, ModelAndView mv) throws Exception{

		if(commandMap.isEmpty() == false){
			Iterator<Entry<String,Object>> iterator =
					commandMap.getMap().entrySet().iterator();
			Entry<String,Object> entry = null;
			while(iterator.hasNext()){
				entry = iterator.next();
				log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
			}
		}

		return mv;
	}*/


	@RequestMapping(value="/nList.do")
	public ModelAndView noticeList(Notice notice, ModelAndView mv) throws Exception{

		ArrayList<Notice> nlist = noticeService.noticeList(notice);
		mv.setViewName("notice/notice");
		mv.addObject("nlist", nlist);
		
		return mv;
	}
	
	
	@RequestMapping(value="/nInsert.do")
	public ModelAndView noticeInsert(Notice notice, ModelAndView mv) throws Exception{

		//서비스 메소드 실행하고, 결과 받기
		noticeService.noticeInsert(notice);
		//받은 결과에 따라 뷰 선택
		mv.setViewName("notice/notice");

		return mv;
//		return "redirect:notice/notice";
	}
	
	
//	@RequestMapping(value="/testMapArgumentResolver.do")
//	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
//		
//		ModelAndView mv = new ModelAndView("");
//		
//		if(commandMap.isEmpty() == false){
//			Iterator<Entry<String,Object>> iterator =
//					commandMap.getMap().entrySet().iterator();
//			Entry<String,Object> entry = null;
//			
//			while(iterator.hasNext()){
//				entry = iterator.next();
//				log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
//			}
//		}
//		
//		return mv;
//	}



	@RequestMapping(value="/nInsert2.do")
	public ModelAndView noticeInsert2(Map<String, Object> commandMap, ModelAndView mv) throws Exception{

		List<Map<String,Object>> nlist = noticeService.noticeInsert2(commandMap);

		mv.setViewName("notice/notice2");
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
