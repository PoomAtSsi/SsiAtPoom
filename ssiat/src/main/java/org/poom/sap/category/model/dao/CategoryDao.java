package org.poom.sap.category.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.poom.sap.category.model.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDao {
Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public CategoryDao(){}
	
	public List<Category> ListCategory(Category cate){
		return (List<Category>) sqlSession.selectList("categoryList", cate);
	}
	
	

}
