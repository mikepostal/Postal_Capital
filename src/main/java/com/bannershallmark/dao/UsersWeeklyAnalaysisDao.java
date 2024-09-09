package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.UsersWeeklyAnalaysis;

public interface UsersWeeklyAnalaysisDao {

	List<UsersWeeklyAnalaysis> FindByUser(int userId);

}
