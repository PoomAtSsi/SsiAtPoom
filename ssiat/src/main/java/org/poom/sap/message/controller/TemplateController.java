package org.poom.sap.message.controller;

import java.util.ArrayList;

import org.poom.sap.message.model.service.TemplateService;
import org.poom.sap.message.model.vo.template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping("template")
public class TemplateController {
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private TemplateService templateService;
	
	@RequestMapping(value="/aview.do")
	public ModelAndView aView(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("message/template");
		return mav;
	}
	
	@RequestMapping(value="/a.do")
	public ModelAndView a(template t){
		ModelAndView mav = new ModelAndView();
		
		try {
			System.out.println("t.getSrchName() : "+t.getSrchName());
			
			// 서비스 수행
			ArrayList<template> tResult = templateService.a(t);
			
			// 검색어 저장
			// insert 호출
			
			//결과 파라메터 생성
			mav.addObject("memberList", tResult);
			
			//결과 페이지 지정
			mav.setViewName("message/template2");
		} catch(Exception e) {
			e.printStackTrace();
			
			//결과 파라메터 생성
			mav.addObject("memberList", null);
			mav.addObject("searchResult", false);
			
			//결과 페이지 지정
			mav.setViewName("message/template2");
		}
		
		return mav;
	}
}
