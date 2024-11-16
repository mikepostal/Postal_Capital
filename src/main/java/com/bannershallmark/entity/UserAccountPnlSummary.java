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
	private double simpnl;
	private double realpnl;
	private double simPnlPercent;
	private double realPnlPercent;
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

	public double getSimpnl() {
		return simpnl;
	}

	public void setSimpnl(double simpnl) {
		this.simpnl = simpnl;
	}

	public double getRealpnl() {
		return realpnl;
	}

	public void setRealpnl(double realpnl) {
		this.realpnl = realpnl;
	}

	public double getSimPnlPercent() {
		return simPnlPercent;
	}

	public void setSimPnlPercent(double simPnlPercent) {
		this.simPnlPercent = simPnlPercent;
	}

	public double getRealPnlPercent() {
		return realPnlPercent;
	}

	public void setRealPnlPercent(double realPnlPercent) {
		this.realPnlPercent = realPnlPercent;
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
