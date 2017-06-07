package org.poom.sap.noriter.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.poom.sap.common.util.Paging;
import org.poom.sap.common.util.PagingUtils;
import org.poom.sap.noriter.model.service.NoriterService;
import org.poom.sap.noriter.model.vo.Noriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("noriter")
public class NoriterController {
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private NoriterService noriterService;
	
	private PagingUtils pu = new PagingUtils();

	
	@RequestMapping(value="/noriterList.do", method = RequestMethod.GET)
	public ModelAndView noriterList(@RequestParam(value="category") int category, Noriter noriter, ModelAndView mv, Paging npaging, HttpServletRequest request) throws Exception{

		// paging
		int a = 1;
		int b = 1;
		a = noriterService.noriterTC(noriter);
		pu.setChangedTotalCount(a);
		pu.setChangedPage(b);
		
		//전달받은 현재 페이지 추출
		if(request.getParameter("page") != null){
			b =Integer.parseInt(request.getParameter("page"));
			pu.setChangedPage(b);
		}
		npaging = pu.noticePaging();
		
		// category 추출
		System.out.println("category : " + category);
		
		// List 출력(get)
		List<Noriter> nlist = noriterService.noriterList(noriter, npaging, category);
		
		mv.setViewName("noriter/noriterList");
		mv.addObject("nlist", nlist);
		mv.addObject("page", npaging.getPage());
		mv.addObject("countList", npaging.getCountList());
		mv.addObject("countPage", npaging.getCountPage());
		mv.addObject("totalPage", npaging.getTotalPage());
		mv.addObject("startPage", npaging.getStartPage());
		mv.addObject("endPage", npaging.getEndPage());
		mv.addObject("category", category);
		
		System.out.println(npaging);

		return mv;
	}

	@RequestMapping(value="/noriterDetail.do", method = RequestMethod.GET)
	public ModelAndView noriterDetail(int classNo, ModelAndView mv) throws Exception {

		List<Noriter> nlist = noriterService.noriterDetail(classNo);

		//redirect 하려면 .do 여야 함
		mv.setViewName("noriter/noriterDetail");
		mv.addObject("nlist", nlist);

		return mv;
	}

	@RequestMapping(value="/noriterInsert.do", method=RequestMethod.GET)
	public String noriterInsertForm() {

		return "noriter/noriterInsert";
	}

	@RequestMapping(value="/nInsert.do", method = RequestMethod.POST)
	public ModelAndView noriterInsert(Noriter noriter, ModelAndView mv
			,HttpServletRequest request, HttpSession session) throws Exception{
		
		String path = request.getRealPath("/video");
		int num = noriter.getClassNo();
		String filename = noriter.getVideo().getOriginalFilename();
		long sctm = System.currentTimeMillis();	//파일명 중복제거를 위한 작업
		
		try {
			noriter.getVideo().transferTo(new File(path+"/"+sctm+"_"+filename));
		}catch (IOException e) {
			e.printStackTrace();
		}
		//파일 경로 설정 확인 및 command에 넣어줌(Notice notice 같은것을 command라고 부른는 듯 합니다)
		System.out.println("videopath : " +path+"/"+sctm+"_"+filename);
		noriter.setVideopath(path+"/"+sctm+"_"+filename);
		
		System.out.println("videoname : "+sctm+"_"+filename);
		noriter.setVideoname(sctm+"_"+filename);
		
		//서비스 메소드 실행하고, 결과 받기
		noriterService.noriterInsert(noriter);
		//받은 결과에 따라 뷰 선택
		mv.setViewName("redirect:/noriter/noriterList.do");

		return mv;
	}


	@RequestMapping(value="/nDelete.do", method = RequestMethod.GET)
	public ModelAndView noriterDelete(Noriter noriter, ModelAndView mv) throws Exception{

		//서비스 메소드 실행하고, 결과 받기
		noriterService.noriterDelete(noriter);
		//받은 결과에 따라 뷰 선택
		mv.setViewName("redirect:/noriter/noriterList.do");

		return mv;
	}

	@RequestMapping(value="/noriterUpdate.do", method=RequestMethod.POST)
	public ModelAndView noriterUpdateForm(int classNo, ModelAndView mv, HttpServletRequest request) throws Exception {

		List<Noriter> nlist = noriterService.noriterDetail(classNo);

		mv.setViewName("noriter/noriterUpdate");
		mv.addObject("nlist", nlist);

		return mv;
	}

	@RequestMapping(value="/nUpdate.do", method = RequestMethod.POST)
	public ModelAndView noriterUpdate(Noriter noriter, ModelAndView mv) throws Exception{

		//서비스 메소드 실행하고, 결과 받기
		noriterService.noriterUpdate(noriter);
		//받은 결과에 따라 뷰 선택
		mv.setViewName("redirect:/noriter/noriterList.do");

		return mv;
	}

	@RequestMapping(value="/navereditor.do")
	public String navereditor(){

		return "testeditor/navereditor1";
	}

	@RequestMapping(value="/cancelnavereditor.do")
	public String cancelnavereditor(){

		return "redirect:sap";
	}

	@RequestMapping(value="/sendnavereditor.do")
	public String sendnavereditor(HttpServletRequest request, String detail) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("detail"));
		System.out.println(detail);

		return "testeditor/navereditor2";
	}
	
	/*@RequestMapping(value="/mynoriter.do", method=RequestMethod.GET)
	public ModelAndView myNoriter(@RequestParam("nickname")Noriter noriter, ModelAndView mv)throws Exception{
		List<Noriter> mnlist = noriterService.myNoriter(noriter);
		System.out.println(noriter);
		mv.addObject("mnlist",mnlist);
		mv.setViewName("mypage/myssiat");
		return mv;
	}*/

}
