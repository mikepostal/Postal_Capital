package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weeklyanalysisbypair")
public class WeeklyAnalaysisByPair {
	@Id
	private int id;
	private int tradingYear;
	private int tradingWeek;
	private String pair;
	@Column(name = "total_pnl")
	private double totalPnl;
	@Column(name = "cumulative_pnl")
	private double cumulativePnl;

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

	public double getTotalPnl() {
		return totalPnl;
	}

	public void setTotalPnl(double totalPnl) {
		this.totalPnl = totalPnl;
	}

	public double getCumulativePnl() {
		return cumulativePnl;
	}

	public void setCumulativePnl(double cumulativePnl) {
		this.cumulativePnl = cumulativePnl;
	}

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
	}

}
