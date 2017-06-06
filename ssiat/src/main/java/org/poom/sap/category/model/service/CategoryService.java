package org.poom.sap.category.model.service;

import java.util.List;

import org.poom.sap.category.model.vo.Category;

public interface CategoryService {
	List<Category> ListCategory(Category cate) throws Exception;
}
