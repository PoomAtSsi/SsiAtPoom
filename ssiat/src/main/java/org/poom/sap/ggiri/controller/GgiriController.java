package org.poom.sap.ggiri.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.poom.sap.ggiri.model.service.GgiriService;
import org.poom.sap.ggiri.model.vo.Ggiri;
import org.poom.sap.notice.model.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("ggiri")
public class GgiriController {
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private GgiriService ggiriService;
	
	//끼리목록
	@RequestMapping(value="/glist.do", method=RequestMethod.GET)
	public ModelAndView ggiriList(Ggiri ggiri, ModelAndView mv) throws Exception{
		List<Ggiri> glist = ggiriService.ggiriList(ggiri);
		
		mv.setViewName("/ggiri/ggiriList");
		mv.addObject("glist",glist);
		System.out.println("gct");
		return mv;
	}
	
	//끼리 카테고리별 리스트
	/*@RequestMapping(value="/gCate.do",method=RequestMethod.GET)
	public ModelAndView CateGgiri(Ggiri ggiri, ModelAndView mv)throws Exception{
		List<Ggiri> glist = ggiriService.ggiriList(ggiri);
		
		mv.setViewName("ggiri/ggiriList");
		mv.addObject("glist", glist);
		return mv;
	}*/
	
	//끼리 상세보기
	@RequestMapping(value="/gDetail.do", method=RequestMethod.GET)
	public ModelAndView noticeDetail(@RequestParam("g_no") int g_no, ModelAndView mv, HttpServletRequest request) throws Exception {
		
		List<Ggiri> glist = ggiriService.ggiriDetail(g_no);
		List<Ggiri> gjlist = ggiriService.joinedGgiri(g_no);
		
		mv.setViewName("ggiri/ggiriDetailView");
		mv.addObject("glist",glist);
		mv.addObject("gjlist",gjlist);
		return mv;
		/*Ggiri ggiri = ggiriService.ggiriDetail(g_no);
		System.out.println(g_no);
		mv.setViewName("ggiri/ggiriDetailView");
		mv.addObject("ggiri", ggiri);
		System.out.println("gt");
		return mv;*/
	}
	//끼리 만들기 폼
	@RequestMapping(value="/ggiriInsertForm.do", method=RequestMethod.GET)
	public String insertGgiriForm() {
		return "ggiri/ggiriInsert";
	}
	
	//끼리 만들기
	@RequestMapping(value="/gInsert.do", method = RequestMethod.POST)
	public String ggiriInsert(@ModelAttribute("ggiri")Ggiri ggiri, ModelAndView mv) throws Exception{
		//서비스 메소드 실행하고, 결과 받기
		ggiriService.ggiriInsert(ggiri);
		return "redirect:/ggiri/glist.do";
	}
	
	//끼리 수정하기 폼
	@RequestMapping(value="/ggiriUpdateForm.do", method=RequestMethod.GET)
	public ModelAndView UpdateGgiriForm( int g_no,ModelAndView mv) throws Exception {
		System.out.println(g_no);
		//ModelAndView mv = new ModelAndView("ggiri/ggiriUpdate");
		List<Ggiri> glist =  ggiriService.ggiriDetail(g_no);
		
		mv.setViewName("ggiri/ggiriUpdate");
		mv.addObject("glist",glist);
		return mv;
	}
	//끼리 수정하기
	@RequestMapping(value="/gUpdate.do", method= RequestMethod.POST)
	public String ggiriUpdate(@ModelAttribute("ggiri")Ggiri ggiri) throws Exception{
		System.out.println(ggiri.getG_no());
		//Ggiri ggiri = new Ggiri();
		 ggiriService.ggiriUpdate(ggiri);
		System.out.println("uuuuu");
		return "redirect:/ggiri/glist.do";
	}
	
	//끼리 삭제?
	@RequestMapping(value="/gDelete.do", method={RequestMethod.GET, RequestMethod.POST})
	public String ggiriDelete(int g_no) throws Exception{
		
		//System.out.println(g_no);
		ggiriService.ggiriDelete(g_no);
		//System.out.println("2222222");
		return "redirect:/ggiri/glist.do";
	}
	
	@RequestMapping(value="/gJoinForm.do", method=RequestMethod.GET)
	public ModelAndView ggiriJoinForm(@RequestParam("g_no") int g_no, ModelAndView mv)throws Exception{
		List<Ggiri> glist =  ggiriService.ggiriDetail(g_no);
		mv.setViewName("ggiri/ggiriJoin");
		mv.addObject("glist",glist);
		return mv;
	}
	//끼리 신청하기
	@RequestMapping(value="/gJoin.do", method=RequestMethod.POST)
	public String ggiriJoin(@ModelAttribute("ggiri")Ggiri ggiri, int g_no)throws Exception{
		ggiriService.ggiriJoin(ggiri, g_no);
		return "redirect:/";
	}
	
	//끼리 신청한 사람 
	@RequestMapping(value="/gJoined.do", method=RequestMethod.GET)
	public ModelAndView joinedGgiri(int g_j_no, ModelAndView mv)throws Exception{
		List<Ggiri> gjlist = ggiriService.joinedGgiri(g_j_no);
		mv.setViewName("ggiri/ggiriDetailView");
		mv.addObject("gjlist",gjlist);
		return mv;
	}
	
	//즐겨찾기
	@ResponseBody
	@RequestMapping(value="/gLike.do", method=RequestMethod.POST)
	public String LikeGgiri(Ggiri ggiri, @RequestParam("g_no") int g_no)throws Exception{
		
		//List<Ggiri> glist = ggiriService.ggiriDetail(g_no);
		System.out.println(g_no);
		System.out.println(ggiri);
		ggiriService.likeGgiri(ggiri, g_no);
		return "redirect:/";
	}
	
	//즐겨찾기 취소
	@ResponseBody
	@RequestMapping(value="/gUnlike.do", method=RequestMethod.POST)
	public String unLikeGgiri(Ggiri ggiri, @RequestParam("g_no") int g_no)throws Exception{
		ggiriService.unlikeGgiri(ggiri, g_no);
		return "redirect:/";
	}
	
	//씨앗지기 프로필사진
	@RequestMapping(value="gProfile.do", method=RequestMethod.POST)
	public ModelAndView ggiriProfile(Ggiri ggiri, ModelAndView mv)throws Exception{
		List<Ggiri> gplist = ggiriService.ggiriProfile(ggiri);
		mv.setViewName("ggiri/ggiriDetailView");
		mv.addObject("gplist",gplist);
		return mv;
	}
}
