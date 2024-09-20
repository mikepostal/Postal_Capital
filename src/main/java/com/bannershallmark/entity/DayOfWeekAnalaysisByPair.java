package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dayofweekanalysisbypair")
public class DayOfWeekAnalaysisByPair {
	@Id
	private int id;
	private String dayOfWeek;
	private String pair;
	@Column(name = "total_pnl")
	private double totalPnl;

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

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
	}

}
