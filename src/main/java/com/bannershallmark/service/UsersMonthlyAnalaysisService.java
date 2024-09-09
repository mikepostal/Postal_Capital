package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UsersMonthlyAnalaysis;

public interface UsersMonthlyAnalaysisService {

	List<UsersMonthlyAnalaysis> FindByUser(int userId);

}
