package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.UsersDailyAnalaysis;

public interface UsersDailyAnalaysisDao {

	List<UsersDailyAnalaysis> FindByUser(int userId);

}
