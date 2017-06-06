package org.poom.sap.category.model.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.poom.sap.category.model.service.CategoryService;
import org.poom.sap.category.model.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("category")
public class CategoryController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/clist.do", method=RequestMethod.GET)
	public ModelAndView ListCategory(Category cate, ModelAndView mv) throws Exception{
		List<Category> clist =  categoryService.ListCategory(cate);
		
		mv.setViewName("category/category");
		mv.addObject("clist",clist);
		return mv;
	}
	

}
