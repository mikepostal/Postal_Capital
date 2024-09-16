package com.bannershallmark.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class CommentReplay {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "replayId")
	private Integer replayId;

	@Column(columnDefinition = "longblob")
	private String replayMessage;
	@Column(name = "date", nullable = false)
	private Date date;

	@PrePersist
	protected void onCreate() {
		this.date = new Date(System.currentTimeMillis());
	}

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "commentId", referencedColumnName = "commentId")
	private TradeComment tradeComment;

	public Integer getReplayId() {
		return replayId;
	}

	public void setReplayId(Integer replayId) {
		this.replayId = replayId;
	}

	public String getReplayMessage() {
		return replayMessage;
	}

	public void setReplayMessage(String replayMessage) {
		this.replayMessage = replayMessage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public TradeComment getTradeComment() {
		return tradeComment;
	}

	public void setTradeComment(TradeComment tradeComment) {
		this.tradeComment = tradeComment;
	}

}
