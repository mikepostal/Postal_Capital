package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monthlyanalysisbyuserandaccount")
public class MonthlyAnalaysisByUserAndAccount {
	@Id
	private int id;
	private int tradingYear;
	private int tradingMonth;
	private String monthName;
	private int userId;
	private String firstname;
	private String lastname;
	private String accountLogin;
	@Column(name = "total_pnl")
	private double totalPnl;

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

	public int getTradingMonth() {
		return tradingMonth;
	}

	public void setTradingMonth(int tradingMonth) {
		this.tradingMonth = tradingMonth;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public double getTotalPnl() {
		return totalPnl;
	}

	public void setTotalPnl(double totalPnl) {
		this.totalPnl = totalPnl;
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

}
