package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.Categories;

public interface CategoriesDao {

	List<Categories> FindAll();

	void save(Categories categories);

	Categories FindById(int id);

	void DeleteById(int id);

}
