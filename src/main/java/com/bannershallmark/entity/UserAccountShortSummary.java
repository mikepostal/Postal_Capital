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
	@Column(name = "usersim_pnl")
	private double usersimPnl;
	@Column(name = "userreal_pnl")
	private double userrealPnl;
	@Column(name = "usersimpnl_percent")
	private double usersimpnlPercent;
	@Column(name = "userrealpnl_percent")
	private double userrealpnlPercent;
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

	public double getUsersimPnl() {
		return usersimPnl;
	}

	public void setUsersimPnl(double usersimPnl) {
		this.usersimPnl = usersimPnl;
	}

	public double getUserrealPnl() {
		return userrealPnl;
	}

	public void setUserrealPnl(double userrealPnl) {
		this.userrealPnl = userrealPnl;
	}

	public double getUsersimpnlPercent() {
		return usersimpnlPercent;
	}

	public void setUsersimpnlPercent(double usersimpnlPercent) {
		this.usersimpnlPercent = usersimpnlPercent;
	}

	public double getUserrealpnlPercent() {
		return userrealpnlPercent;
	}

	public void setUserrealpnlPercent(double userrealpnlPercent) {
		this.userrealpnlPercent = userrealpnlPercent;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
