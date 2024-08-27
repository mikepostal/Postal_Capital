package com.bannershallmark.entity;

import javax.persistence.*;

@Entity
@Table(name = "tradePairs")
public class TradePairs {

	@Id
	@Column(name = "trdpairsID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trdpairsID;

	@ManyToOne
	@JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
	private Categories category;

	private String pairName;

	public TradePairs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradePairs(Integer trdpairsID, Categories category, String pairName) {
		super();
		this.trdpairsID = trdpairsID;
		this.category = category;
		this.pairName = pairName;
	}

	public Integer getTrdpairsID() {
		return trdpairsID;
	}

	public void setTrdpairsID(Integer trdpairsID) {
		this.trdpairsID = trdpairsID;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public String getPairName() {
		return pairName;
	}

	public void setPairName(String pairName) {
		this.pairName = pairName;
	}
}