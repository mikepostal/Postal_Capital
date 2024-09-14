package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.TradeCommentDao;
import com.bannershallmark.entity.CommentReplay;
import com.bannershallmark.entity.TradeComment;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.TradeCommentService;

@Service
public class TradeCommentServiceImpl implements TradeCommentService {
	@Autowired
	private TradeCommentDao tradeCommentDao;

	@Override
	@Transactional
	public List<TradeComment> FindAll() {
		return tradeCommentDao.FindAll();
	}

	@Override
	@Transactional
	public void save(TradeComment tradeComment) {
		tradeCommentDao.save(tradeComment);

	}

	@Override
	@Transactional
	public TradeComment FindById(int id) {
		return tradeCommentDao.FindById(id);
	}

	@Override
	@Transactional
	public void DeleteById(int id) {
		tradeCommentDao.DeleteById(id);
	}

	@Override
	@Transactional
	public List<TradeComment> FindByUser(Users users) {
		return tradeCommentDao.FindByUser(users);
	}

	@Override
	@Transactional
	public void saveReplayMessage(CommentReplay commentReplay) {
		tradeCommentDao.saveReplayMessage(commentReplay);
		
	}

	@Override
	@Transactional
	public List<CommentReplay> FindAllCommentReplaies() {
		return tradeCommentDao.FindAllCommentReplaies();
	}

	@Override
	@Transactional
	public List<TradeComment> findAllWithReplays() {
		return tradeCommentDao.findAllWithReplays();
	}

	@Override
	@Transactional
	public List<TradeComment> findBydUserWithReplays(Users users) {
		return tradeCommentDao.findBydUserWithReplays(users);
	}

	@Override
	@Transactional
	public List<TradeComment> findBydIdWithReplays(Integer commentId) {
		return tradeCommentDao.findBydUserWithReplays(commentId);
	}
}
