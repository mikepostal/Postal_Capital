package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.PnlView;

public interface PnlViewService {

	List<PnlView> findByUserId(int userId);

	List<PnlView> findAll();

}
