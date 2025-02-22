package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.CommentReplay;
import com.bannershallmark.entity.TradeComment;
import com.bannershallmark.entity.Users;

public interface TradeCommentDao {

	List<TradeComment> FindAll();

	void save(TradeComment tradeComment);

	TradeComment FindById(int id);

	void DeleteById(int id);

	List<TradeComment> FindByUser(Users users);

	void saveReplayMessage(CommentReplay commentReplay);

	List<CommentReplay> FindAllCommentReplaies();

	List<TradeComment> findAllWithReplays();

	List<TradeComment> findBydUserWithReplays(Users users);

	List<TradeComment> findBydUserWithReplays(Integer commentId);

}
