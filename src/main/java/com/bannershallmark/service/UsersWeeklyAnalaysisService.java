package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UsersWeeklyAnalaysis;

public interface UsersWeeklyAnalaysisService {

	List<UsersWeeklyAnalaysis> FindByUser(int userId);

}
