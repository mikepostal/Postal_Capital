package com.bannershallmark.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class Categories {

	@Id
	@Column(name = "categoryID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryID;
	private String categoryName;
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<TradePairs> tradePairs = new ArrayList<>();

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<TradePairs> getTradePairs() {
		return tradePairs;
	}

	public void setTradePairs(List<TradePairs> tradePairs) {
		this.tradePairs = tradePairs;
	}
 
}