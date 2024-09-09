package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.UsersDayOfWeekAnalaysis;

public interface UsersDayOfWeekAnalaysisDao {

	List<UsersDayOfWeekAnalaysis> FindByUser(int userId);

}
