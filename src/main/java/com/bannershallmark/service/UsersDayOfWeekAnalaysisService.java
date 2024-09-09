package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UsersDayOfWeekAnalaysis;

public interface UsersDayOfWeekAnalaysisService {

	List<UsersDayOfWeekAnalaysis> FindByUser(int userId);

}
