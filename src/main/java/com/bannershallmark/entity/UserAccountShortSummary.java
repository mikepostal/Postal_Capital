package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccountshortsummary")
public class UserAccountShortSummary {
	@Id
	private int id;
	private String firstname;
	private String lastname;
	@Column(name = "numof_accounts")
	private int numofAccounts;
	@Column(name = "total_inital")
	private double totalInital;
	@Column(name = "usertotal_pnl")
	private double usertotalPnl;
	@Column(name = "userpnl_percent")
	private double userpnlPercent;
	private int userId;

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

	public int getNumofAccounts() {
		return numofAccounts;
	}

	public void setNumofAccounts(int numofAccounts) {
		this.numofAccounts = numofAccounts;
	}

	public double getTotalInital() {
		return totalInital;
	}

	public void setTotalInital(double totalInital) {
		this.totalInital = totalInital;
	}

	public double getUsertotalPnl() {
		return usertotalPnl;
	}

	public void setUsertotalPnl(double usertotalPnl) {
		this.usertotalPnl = usertotalPnl;
	}

	public double getUserpnlPercent() {
		return userpnlPercent;
	}

	public void setUserpnlPercent(double userpnlPercent) {
		this.userpnlPercent = userpnlPercent;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
