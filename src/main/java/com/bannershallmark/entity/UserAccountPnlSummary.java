package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccountpnlsummary")
public class UserAccountPnlSummary {
	@Id
	private int id;
	private String firstname;
	private String lastname;
	private double initalSize;
	private int leverage;
	private String platform;
	private String accountLogin;
	@Column(name = "total_pnl")
	private double totalPnl;
	@Column(name = "total_pnl_percent")
	private double totalPnlPercent;
	private int userId;
	private int accountID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getInitalSize() {
		return initalSize;
	}

	public void setInitalSize(double initalSize) {
		this.initalSize = initalSize;
	}

	public int getLeverage() {
		return leverage;
	}

	public void setLeverage(int leverage) {
		this.leverage = leverage;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getAccountLogin() {
		return accountLogin;
	}

	public void setAccountLogin(String accountLogin) {
		this.accountLogin = accountLogin;
	}

	public double getTotalPnl() {
		return totalPnl;
	}

	public void setTotalPnl(double totalPnl) {
		this.totalPnl = totalPnl;
	}

	public double getTotalPnlPercent() {
		return totalPnlPercent;
	}

	public void setTotalPnlPercent(double totalPnlPercent) {
		this.totalPnlPercent = totalPnlPercent;
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
