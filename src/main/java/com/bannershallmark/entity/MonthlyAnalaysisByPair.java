package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monthlyanalysisbypair")
public class MonthlyAnalaysisByPair {
	@Id
	private int id;
	private int tradingYear;
	private int tradingMonth;
	private String monthName;
	private String pair;
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

	public double getTotalPnl() {
		return totalPnl;
	}

	public void setTotalPnl(double totalPnl) {
		this.totalPnl = totalPnl;
	}

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
	}

}
