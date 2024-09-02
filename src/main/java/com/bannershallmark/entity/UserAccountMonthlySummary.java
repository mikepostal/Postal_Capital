package com.bannershallmark.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccountmonthlysummary")
public class UserAccountMonthlySummary {
	@Id
	private int id;
	private int tradingYear;
	private int tradingMonth;
	private String monthName;
	private int trdpairID;
	private double totalPnl;
	private int userId;
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

	public int getTrdpairID() {
		return trdpairID;
	}

	public void setTrdpairID(int trdpairID) {
		this.trdpairID = trdpairID;
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

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

}
