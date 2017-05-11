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
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	/*public String loginCheck(HttpServletRequest request){*/
	public ModelAndView loginCheck(Member member, ModelAndView mv, HttpSession session){
		/*String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		Member member = new Member();
		member.setMember_id(userId);
		member.setMember_pwd(userPwd);*/
		//System.out.println(member.getMember_id() + ", " + member.getMember_pwd());
		
		Member loginUser = memberService.loginCheck(member);
		
		if(loginUser != null)
			session.setAttribute("loginUser", loginUser);
		
		//ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
//		mv.addObject("loginUser", loginUser);
		//return "home";
		return mv;
	}
	
	@RequestMapping("/logout.do")
	public String logOut(HttpSession session){
		if(session != null)
			session.invalidate();
		
		
		//RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		//view.forward(request, response);
		
		return "home";
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
