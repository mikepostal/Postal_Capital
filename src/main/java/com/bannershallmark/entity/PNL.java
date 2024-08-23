package com.bannershallmark.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "pnl")
public class PNL {
	
    @Id
    @Column(name = "pnlID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pnlID;
    
    @ManyToOne
	@JoinColumn(name = "trdpairsID")
	private TradePairs tradePair;
    
    @ManyToOne
	@JoinColumn(name = "accountID")
	private Accounts accounts;
    
    private Date tradingDate;
    private Double pnl;
    private Double pnlPercent;
    
	public Integer getPnlID() {
		return pnlID;
	}
	public void setPnlID(Integer pnlID) {
		this.pnlID = pnlID;
	}
	public TradePairs getTradePair() {
		return tradePair;
	}
	public void setTradePair(TradePairs tradePair) {
		this.tradePair = tradePair;
	}
	public Accounts getAccounts() {
		return accounts;
	}
	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
	public Date getTradingDate() {
		return tradingDate;
	}
	public void setTradingDate(Date tradingDate) {
		this.tradingDate = tradingDate;
	}
	public Double getPnl() {
		return pnl;
	}
	public void setPnl(Double pnl) {
		this.pnl = pnl;
	}
	public Double getPnlPercent() {
		return pnlPercent;
	}
	public void setPnlPercent(Double pnlPercent) {
		this.pnlPercent = pnlPercent;
	}
}