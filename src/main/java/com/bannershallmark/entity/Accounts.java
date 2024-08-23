package com.bannershallmark.entity;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts {
	
    @Id
    @Column(name = "accountID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountID;
    private String platform;
    private Integer leverage;
    private Double initalSize;
    private Date createdON;
    private String url;
    private String apiEndPoint;
    private String apiSecret;
    private String active;
    
    
	public Integer getAccountID() {
		return accountID;
	}
	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Integer getLeverage() {
		return leverage;
	}
	public void setLeverage(Integer leverage) {
		this.leverage = leverage;
	}
	public Double getInitalSize() {
		return initalSize;
	}
	public void setInitalSize(Double initalSize) {
		this.initalSize = initalSize;
	}
	public Date getCreatedON() {
		return createdON;
	}
	public void setCreatedON(Date createdON) {
		this.createdON = createdON;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getApiEndPoint() {
		return apiEndPoint;
	}
	public void setApiEndPoint(String apiEndPoint) {
		this.apiEndPoint = apiEndPoint;
	}
	public String getApiSecret() {
		return apiSecret;
	}
	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	   
}