package com.bannershallmark.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marketInsightDescription")
public class MarketInsightDescription {
	@Column(name = "miDescID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer miDescID;

	@Lob
	@Column(columnDefinition = "longblob")
	private String marketInsightDetail;

	@ManyToOne
	@JoinColumn(name = "marketInsightID", referencedColumnName = "marketInsightID")
	private MarketInsight marketInsightID;

	@OneToMany(mappedBy = "miDescID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<MarketInsightFile> marketInsightFileList = new ArrayList<>();

	public MarketInsightDescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarketInsightDescription(Integer miDescID, String marketInsightDetail, MarketInsight marketInsightID,
			List<MarketInsightFile> marketInsightFileList) {
		super();
		this.miDescID = miDescID;
		this.marketInsightDetail = marketInsightDetail;
		this.marketInsightID = marketInsightID;
		this.marketInsightFileList = marketInsightFileList;
	}

	public Integer getMiDescID() {
		return miDescID;
	}

	public void setMiDescID(Integer miDescID) {
		this.miDescID = miDescID;
	}

	public String getMarketInsightDetail() {
		return marketInsightDetail;
	}

	public void setMarketInsightDetail(String marketInsightDetail) {
		this.marketInsightDetail = marketInsightDetail;
	}

	public MarketInsight getMarketInsightID() {
		return marketInsightID;
	}

	public void setMarketInsightID(MarketInsight marketInsightID) {
		this.marketInsightID = marketInsightID;
	}

	public List<MarketInsightFile> getMarketInsightFileList() {
		return marketInsightFileList;
	}

	public void setMarketInsightFileList(List<MarketInsightFile> marketInsightFileList) {
		this.marketInsightFileList = marketInsightFileList;
	}

}
