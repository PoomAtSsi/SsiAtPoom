package org.poom.sap.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.poom.sap.noriter.model.service.NoriterService;
import org.poom.sap.noriter.model.vo.Noriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("menu")
public class MenubarUtils {
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private NoriterService noriterService;
	
	private PagingUtils pu = new PagingUtils();
	
	@RequestMapping(value="/menuList.do", method = RequestMethod.GET)
	public String MenuListForm(){
		log.info("menuList.do start");
		
		return "menu/menuList";
	}
	
	/*@RequestMapping(value="/noriterList.do", method=RequestMethod.GET)
	public String noriterListForm() {

		return "menu/noriterList";
	}*/
	
	@RequestMapping(value="/ggiriList.do", method = RequestMethod.GET)
	public ModelAndView ggiriList(ModelAndView mv) throws Exception{
		
		mv.setViewName("menu/ggiriList");
		
		return mv;
	}
		
	@RequestMapping(value="/noriterList.do", method = RequestMethod.GET)
	public ModelAndView noriterList(Noriter noriter, ModelAndView mv, Paging npaging, HttpServletRequest request) throws Exception{

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
		int category = 0;
		if(request.getParameter("category") != null){
			category = Integer.parseInt(request.getParameter("category"));
		}
				
		// List 출력(get)
		List<Noriter> nlist = noriterService.noriterList(noriter, npaging, category);
		
		mv.setViewName("menu/noriterList");
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
	
	
}
