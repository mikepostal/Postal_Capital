package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "yearlyanalaysis")
public class YearlyAnalaysis {
	@Id
	private int id;
	private int tradingYear;
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

	public double getTotalPnl() {
		return totalPnl;
	}

	public void setTotalPnl(double totalPnl) {
		this.totalPnl = totalPnl;
	}

}
