package com.bannershallmark.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TradeComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentId")
	private Integer commentId;

	@Column(columnDefinition = "longblob")
	private String description;
	@Column(name = "date", nullable = false)
	private Date date;

	@PrePersist
	protected void onCreate() {
		this.date = new Date(System.currentTimeMillis());
	}

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Users user;
	
	@OneToMany(mappedBy = "tradeComment",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CommentReplay> commentReplays = new ArrayList<>();

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<CommentReplay> getCommentReplays() {
		return commentReplays;
	}

	public void setCommentReplays(List<CommentReplay> commentReplays) {
		this.commentReplays = commentReplays;
	}

}
