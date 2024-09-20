package com.bannershallmark.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pnlview")
public class PnlView {
	@Id
	private Integer id;
	private String accountLogin;
	private String pair;
	private LocalDateTime tradingDate;
	private Double pnl;
	private Double pnlPercent;
	private String comment;
	private int userId;
	private int pnlID;
	private int accountID;
	private String firstname;
	private String lastname;
	private String position;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountLogin() {
		return accountLogin;
	}

	public void setAccountLogin(String accountLogin) {
		this.accountLogin = accountLogin;
	}

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
	}

	public LocalDateTime getTradingDate() {
		return tradingDate;
	}

	public void setTradingDate(LocalDateTime tradingDate) {
		this.tradingDate = tradingDate;
	}

	public Double getPnl() {
		return pnl;
	}

	public void setPnl(Double pnl) {
		this.pnl = pnl;
	}

	public Double getPnlPercent() {
		return pnlPercent;
	}

	public void setPnlPercent(Double pnlPercent) {
		this.pnlPercent = pnlPercent;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPnlID() {
		return pnlID;
	}

	public void setPnlID(int pnlID) {
		this.pnlID = pnlID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
