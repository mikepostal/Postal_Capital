package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UsersYearlyAnalaysis;

public interface UsersYearlyAnalaysisService {

	List<UsersYearlyAnalaysis> FindByUser(int userId);

}
