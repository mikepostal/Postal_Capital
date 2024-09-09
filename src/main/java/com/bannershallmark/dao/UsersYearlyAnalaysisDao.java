package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.UsersYearlyAnalaysis;

public interface UsersYearlyAnalaysisDao {

	List<UsersYearlyAnalaysis> FindByUser(int userId);

}
