package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weeklyanalysisbyuserandaccount")
public class WeeklyAnalaysisByUserAndAccount {
	@Id
	private int id;
	private int tradingYear;
	private int tradingWeek;
	@Column(name = "total_pnl")
	private double totalPnl;
	@Column(name = "cumulative_pnl")
	private double cumulativePnl;
	private int userId;
	private String firstname;
	private String lastname;
	private String accountLogin;
	private int accountID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTradingYear() {
		return tradingYear;
	}

	public void setTradingYear(int tradingYear) {
		this.tradingYear = tradingYear;
	}

	public int getTradingWeek() {
		return tradingWeek;
	}

	public void setTradingWeek(int tradingWeek) {
		this.tradingWeek = tradingWeek;
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

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

}
