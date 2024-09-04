package com.bannershallmark.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "pnl")
public class PNL {

	@Id
	@Column(name = "pnlID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pnlID;

//	@ManyToOne
//	@JoinColumn(name = "trdpairsID")
//	private TradePairs tradePair;
//
//	@ManyToOne
//	@JoinColumn(name = "accountID")
//	private Accounts accounts;

	private String accountLogin;
	private String pair;
	private LocalDateTime tradingDate;
	private Double pnl;
	private Double pnlPercent;
	private String comment;

	public Integer getPnlID() {
		return pnlID;
	}

	public void setPnlID(Integer pnlID) {
		this.pnlID = pnlID;
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

}