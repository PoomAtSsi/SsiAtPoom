package org.poom.sap.category.model.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.poom.sap.category.model.dao.CategoryDao;
import org.poom.sap.category.model.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<Category> ListCategory(Category cate) throws Exception{
		return categoryDao.ListCategory(cate);
	}

}
