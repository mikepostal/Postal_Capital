package com.bannershallmark.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts {

	@Id
	@Column(name = "accountID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountID;
	private String platform;
	private Integer leverage;
	private Double initalSize;
	private Date createdON;
	private String accountLogin;
	private boolean active;

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Integer getLeverage() {
		return leverage;
	}

	public void setLeverage(Integer leverage) {
		this.leverage = leverage;
	}

	public Double getInitalSize() {
		return initalSize;
	}

	public void setInitalSize(Double initalSize) {
		this.initalSize = initalSize;
	}

	public Date getCreatedON() {
		return createdON;
	}

	public void setCreatedON(Date createdON) {
		this.createdON = createdON;
	}

	public String getAccountLogin() {
		return accountLogin;
	}

	public void setAccountLogin(String accountLogin) {
		this.accountLogin = accountLogin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}