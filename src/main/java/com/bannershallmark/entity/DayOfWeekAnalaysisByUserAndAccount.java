package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dayofweekanalysisbyuserandaccount")
public class DayOfWeekAnalaysisByUserAndAccount {
	@Id
	private int id;
	private String dayOfWeek;
	@Column(name = "total_pnl")
	private double totalPnl;
	private String firstname;
	private String lastname;
	private String accountLogin;
	private String platform;
	private int userId;

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

	public double getTotalPnl() {
		return totalPnl;
	}

	public void setTotalPnl(double totalPnl) {
		this.totalPnl = totalPnl;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
