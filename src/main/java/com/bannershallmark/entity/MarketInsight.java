package com.bannershallmark.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "marketInsight")
public class MarketInsight {
	
    @Id
    @Column(name = "marketInsightID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer marketInsightID;
    private String marketInsightTitle;
    private String marketInsightType;
    private String marketInsightLevel;
    private String marketInsightDetail;
    private Date marketInsightDate;
    
    
	public Integer getMarketInsightID() {
		return marketInsightID;
	}
	public void setMarketInsightID(Integer marketInsightID) {
		this.marketInsightID = marketInsightID;
	}
	public String getMarketInsightTitle() {
		return marketInsightTitle;
	}
	public void setMarketInsightTitle(String marketInsightTitle) {
		this.marketInsightTitle = marketInsightTitle;
	}
	public String getMarketInsightType() {
		return marketInsightType;
	}
	public void setMarketInsightType(String marketInsightType) {
		this.marketInsightType = marketInsightType;
	}
	public String getMarketInsightLevel() {
		return marketInsightLevel;
	}
	public void setMarketInsightLevel(String marketInsightLevel) {
		this.marketInsightLevel = marketInsightLevel;
	}
	public String getMarketInsightDetail() {
		return marketInsightDetail;
	}
	public void setMarketInsightDetail(String marketInsightDetail) {
		this.marketInsightDetail = marketInsightDetail;
	}
	public Date getMarketInsightDate() {
		return marketInsightDate;
	}
	public void setMarketInsightDate(Date marketInsightDate) {
		this.marketInsightDate = marketInsightDate;
	} 
	
}