package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.PnlView;

public interface PnlViewDao {

	List<PnlView> findByUserId(int userId);

	List<PnlView> findAll();

}
