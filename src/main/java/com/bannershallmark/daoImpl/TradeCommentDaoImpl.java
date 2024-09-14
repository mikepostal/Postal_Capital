package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.TradeCommentDao;
import com.bannershallmark.entity.CommentReplay;
import com.bannershallmark.entity.TradeComment;
import com.bannershallmark.entity.Users;

@Repository
public class TradeCommentDaoImpl implements TradeCommentDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TradeComment> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<TradeComment> query = session.createQuery("from TradeComment", TradeComment.class);
		return query.getResultList();
	}

	@Override
	public void save(TradeComment tradeComment) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tradeComment);
	}

	@Override
	public TradeComment FindById(int id) {
		Session session = sessionFactory.getCurrentSession();
		TradeComment tradeComment = session.get(TradeComment.class, id);
		return tradeComment;
	}

	@Override
	public void DeleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		TradeComment tradeComment = FindById(id);
		session.delete(tradeComment);
	}

	@Override
	public List<TradeComment> FindByUser(Users users) {
		Session session = sessionFactory.getCurrentSession();
		Query<TradeComment> query = session.createQuery("from TradeComment where userId = :users", TradeComment.class);
		query.setParameter("users", users);
		return query.getResultList();
	}

	@Override
	public void saveReplayMessage(CommentReplay commentReplay) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(commentReplay);

	}

	@Override
	public List<CommentReplay> FindAllCommentReplaies() {
		Session session = sessionFactory.getCurrentSession();
		Query<CommentReplay> query = session.createQuery("from CommentReplay", CommentReplay.class);
		return query.getResultList();
	}

	@Override
	public List<TradeComment> findAllWithReplays() {
		Session session = sessionFactory.getCurrentSession();
		Query<TradeComment> query = session.createQuery(
				"SELECT DISTINCT c from TradeComment c LEFT JOIN FETCH c.commentReplays", TradeComment.class);
		return query.getResultList();
	}

	@Override
	public List<TradeComment> findBydUserWithReplays(Users users) {
		Session session = sessionFactory.getCurrentSession();
		Query<TradeComment> query = session.createQuery(
				"SELECT DISTINCT c from TradeComment c LEFT JOIN FETCH c.commentReplays WHERE c.user = :users",
				TradeComment.class);
		query.setParameter("users", users);
		return query.getResultList();
	}

	@Override
	public List<TradeComment> findBydUserWithReplays(Integer commentId) {
		Session session = sessionFactory.getCurrentSession();
		Query<TradeComment> query = session.createQuery(
				"SELECT DISTINCT c from TradeComment c LEFT JOIN FETCH c.commentReplays WHERE c.commentId = :commentId",
				TradeComment.class);
		query.setParameter("commentId", commentId);
		return query.getResultList();
	}
}
