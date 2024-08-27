package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.CategoriesDao;
import com.bannershallmark.entity.Categories;
import com.bannershallmark.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService{
	@Autowired
	private CategoriesDao categoriesDao;

	@Override
	@Transactional
	public List<Categories> FindAll() {
		return categoriesDao.FindAll();
	}

	@Override
	@Transactional
	public void save(Categories categories) {
		categoriesDao.save(categories);
	}

	@Override
	@Transactional
	public Categories FindById(int id) {
		return categoriesDao.FindById(id);
	}

	@Override
	@Transactional
	public void DeleteById(int id) {
		categoriesDao.DeleteById(id);
	}
}
