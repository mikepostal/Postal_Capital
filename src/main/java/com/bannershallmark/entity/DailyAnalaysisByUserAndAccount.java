package com.bannershallmark.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dailyanalysisbyuserandaccount")
public class DailyAnalaysisByUserAndAccount {
	@Id
	private int id;
	private Date tradingDate;
	@Column(name = "total_pnl")
	private double totalPnl;
	private int userId;
	private String firstname;
	private String lastname;
	private String accountLogin;
	private String platform;
	private int accountID;
	@Column(name = "cumulative_pnl")
	private double cumulativePnl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTradingDate() {
		return tradingDate;
	}

	public void setTradingDate(Date tradingDate) {
		this.tradingDate = tradingDate;
	}

	public double getTotalPnl() {
		return totalPnl;
	}

	public void setTotalPnl(double totalPnl) {
		this.totalPnl = totalPnl;
	}

	public double getCumulativePnl() {
		return cumulativePnl;
	}

	public void setCumulativePnl(double cumulativePnl) {
		this.cumulativePnl = cumulativePnl;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getAccountLogin() {
		return accountLogin;
	}

	public void setAccountLogin(String accountLogin) {
		this.accountLogin = accountLogin;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

}
