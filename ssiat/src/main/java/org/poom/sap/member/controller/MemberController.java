package org.poom.sap.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.poom.sap.member.model.service.MemberService;
import org.poom.sap.member.model.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("member")
/*@SessionAttributes("loginUser")*/
public class MemberController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView loginCheck(Member member, ModelAndView mv, HttpSession session){
		
		Member loginUser = memberService.loginCheck(member);
		
		if(loginUser != null)
			session.setAttribute("loginUser", loginUser);
		
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logOut(HttpSession session){
		/*if(session != null)
			session.invalidate();*/
		session.setAttribute("loginUser", null);
		return "redirect:/";
	}
	
	@RequestMapping("/insert.do")
	public ModelAndView memberInsert(){
		return null;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView memberUpdate(){
		return null;
	}
	
	@RequestMapping("/delete.do")
	public String memberDelete(){
		return null;
	}
	
	@RequestMapping("/list.do")
	public ModelAndView memberList(){
		return null;
	}
	
	@RequestMapping("/idSearch")
	public ModelAndView memberIdSeach(){
		return null;
	}
}
