package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UsersDailyAnalaysis;

public interface UsersDailyAnalaysisService {

	List<UsersDailyAnalaysis> FindByUser(int userId);

}
