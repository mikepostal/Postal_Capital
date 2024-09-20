package com.bannershallmark.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dailyanalysisbypair")
public class DailyAnalaysisByPair {
	@Id
	private int id;
	private Date tradingDate;
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

	public Date getTradingDate() {
		return tradingDate;
	}

	public void setTradingDate(Date tradingDate) {
		this.tradingDate = tradingDate;
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
