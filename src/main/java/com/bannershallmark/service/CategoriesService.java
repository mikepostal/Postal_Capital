package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.Categories;

public interface CategoriesService {

	List<Categories> FindAll();

	void save(Categories categories);

	Categories FindById(int id);
	
	void DeleteById(int id);

}
