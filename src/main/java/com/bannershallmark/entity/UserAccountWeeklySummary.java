package com.bannershallmark.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccountweeklysummary")
public class UserAccountWeeklySummary {
	@Id
	private int id;
	private int tradingYear;
	private int tradingWeek;
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

	public int getTradingWeek() {
		return tradingWeek;
	}

	public void setTradingWeek(int tradingWeek) {
		this.tradingWeek = tradingWeek;
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
