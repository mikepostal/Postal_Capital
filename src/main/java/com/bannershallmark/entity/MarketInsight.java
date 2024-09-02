package com.bannershallmark.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
	private Date marketInsightDate;

	@OneToMany(mappedBy = "marketInsightID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<MarketInsightDescription> marketInsightDescriptionList = new ArrayList<>();

	public MarketInsight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarketInsight(Integer marketInsightID, String marketInsightTitle, String marketInsightType,
			String marketInsightLevel, Date marketInsightDate,
			List<MarketInsightDescription> marketInsightDescriptionList) {
		super();
		this.marketInsightID = marketInsightID;
		this.marketInsightTitle = marketInsightTitle;
		this.marketInsightType = marketInsightType;
		this.marketInsightLevel = marketInsightLevel;
		this.marketInsightDate = marketInsightDate;
		this.marketInsightDescriptionList = marketInsightDescriptionList;
	}

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

	public Date getMarketInsightDate() {
		return marketInsightDate;
	}

	public void setMarketInsightDate(Date marketInsightDate) {
		this.marketInsightDate = marketInsightDate;
	}

	public List<MarketInsightDescription> getMarketInsightDescriptionList() {
		return marketInsightDescriptionList;
	}

	public void setMarketInsightDescriptionList(List<MarketInsightDescription> marketInsightDescriptionList) {
		this.marketInsightDescriptionList = marketInsightDescriptionList;
	}

}