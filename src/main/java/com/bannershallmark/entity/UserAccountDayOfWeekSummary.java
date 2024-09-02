package com.bannershallmark.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccountdayofweeksummary")
public class UserAccountDayOfWeekSummary {
	@Id
	private int id;
	private String dayOfWeek;
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

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
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
