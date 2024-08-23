package com.bannershallmark.entity;

import javax.persistence.*;

@Entity
@Table(name = "marketInsightFile")
public class MarketInsightFile {
	
    @Id
    @Column(name = "marketInsightFileID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer marketInsightFileID;
    
    @ManyToOne
	@JoinColumn(name = "marketInsightID")
	private MarketInsight marketInsight;
    
    private String marketInsightFileName;

	public Integer getMarketInsightFileID() {
		return marketInsightFileID;
	}

	public void setMarketInsightFileID(Integer marketInsightFileID) {
		this.marketInsightFileID = marketInsightFileID;
	}

	public MarketInsight getMarketInsight() {
		return marketInsight;
	}

	public void setMarketInsight(MarketInsight marketInsight) {
		this.marketInsight = marketInsight;
	}

	public String getMarketInsightFileName() {
		return marketInsightFileName;
	}

	public void setMarketInsightFileName(String marketInsightFileName) {
		this.marketInsightFileName = marketInsightFileName;
	}
  
}