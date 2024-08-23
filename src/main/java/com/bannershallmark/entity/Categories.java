package com.bannershallmark.entity;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class Categories {
	
    @Id
    @Column(name = "categoryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryID;
    private String categoryName;
    
    
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
    
    
	   
}