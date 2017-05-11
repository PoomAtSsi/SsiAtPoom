package org.poom.sap.common.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("itcp")
public class SsiatInterceptorController {
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/firstInterceptor.do")
	public ModelAndView openSampleList(Map<String, Object> commamdMap) throws Exception{
		
		ModelAndView mv = new ModelAndView("interceptor");
		log.debug("인터셉터 테스트");
		mv.setViewName("interceptor");
	
		return mv;
	}
}