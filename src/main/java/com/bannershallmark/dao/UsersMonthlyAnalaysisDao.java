package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.UsersMonthlyAnalaysis;

public interface UsersMonthlyAnalaysisDao {

	List<UsersMonthlyAnalaysis> FindByUser(int userId);

}
