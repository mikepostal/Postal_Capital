package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccountpnlsummary")
public class UserAccountPnlSummary {
	@Id
	private int id;
	private String firstname;
	private String lastname;
	private double initalSize;
	private int leverage;
	private String platform;
	private String type;
	private String accountLogin;
	private int totalTrades;
	private int noOfLong;
	private int noOfShort;
	private int noOfProfitTrades;
	private int noOfLossTrades;
	private int noOfLongWon;
	private int noOfShortWon;
	private double largestProfitTrade;
	private double largestLossTrade;
	private double longPnl;
	private double shortPnl;
	private double simpnl;
	private double realpnl;
	private double simPnlPercent;
	private double realPnlPercent;
	private double totalNetProfit;
	private double grossProfit;
	private double grossLoss;
	private double averageProfitTrade;
	private double averageLossTrade;
	private double currentBalance;
	private int userId;
	private int accountID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getInitalSize() {
		return initalSize;
	}

	public void setInitalSize(double initalSize) {
		this.initalSize = initalSize;
	}

	public int getLeverage() {
		return leverage;
	}

	public void setLeverage(int leverage) {
		this.leverage = leverage;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccountLogin() {
		return accountLogin;
	}

	public void setAccountLogin(String accountLogin) {
		this.accountLogin = accountLogin;
	}

	public int getTotalTrades() {
		return totalTrades;
	}

	public void setTotalTrades(int totalTrades) {
		this.totalTrades = totalTrades;
	}

	public int getNoOfLong() {
		return noOfLong;
	}

	public void setNoOfLong(int noOfLong) {
		this.noOfLong = noOfLong;
	}

	public int getNoOfShort() {
		return noOfShort;
	}

	public void setNoOfShort(int noOfShort) {
		this.noOfShort = noOfShort;
	}

	public int getNoOfProfitTrades() {
		return noOfProfitTrades;
	}

	public void setNoOfProfitTrades(int noOfProfitTrades) {
		this.noOfProfitTrades = noOfProfitTrades;
	}

	public int getNoOfLossTrades() {
		return noOfLossTrades;
	}

	public void setNoOfLossTrades(int noOfLossTrades) {
		this.noOfLossTrades = noOfLossTrades;
	}

	public double getLargestProfitTrade() {
		return largestProfitTrade;
	}

	public void setLargestProfitTrade(double largestProfitTrade) {
		this.largestProfitTrade = largestProfitTrade;
	}

	public double getLargestLossTrade() {
		return largestLossTrade;
	}

	public void setLargestLossTrade(double largestLossTrade) {
		this.largestLossTrade = largestLossTrade;
	}

	public double getLongPnl() {
		return longPnl;
	}

	public void setLongPnl(double longPnl) {
		this.longPnl = longPnl;
	}

	public double getShortPnl() {
		return shortPnl;
	}

	public void setShortPnl(double shortPnl) {
		this.shortPnl = shortPnl;
	}

	public double getSimpnl() {
		return simpnl;
	}

	public void setSimpnl(double simpnl) {
		this.simpnl = simpnl;
	}

	public double getRealpnl() {
		return realpnl;
	}

	public void setRealpnl(double realpnl) {
		this.realpnl = realpnl;
	}

	public double getSimPnlPercent() {
		return simPnlPercent;
	}

	public void setSimPnlPercent(double simPnlPercent) {
		this.simPnlPercent = simPnlPercent;
	}

	public double getRealPnlPercent() {
		return realPnlPercent;
	}

	public void setRealPnlPercent(double realPnlPercent) {
		this.realPnlPercent = realPnlPercent;
	}

	public double getTotalNetProfit() {
		return totalNetProfit;
	}

	public void setTotalNetProfit(double totalNetProfit) {
		this.totalNetProfit = totalNetProfit;
	}

	public double getGrossProfit() {
		return grossProfit;
	}

	public void setGrossProfit(double grossProfit) {
		this.grossProfit = grossProfit;
	}

	public double getGrossLoss() {
		return grossLoss;
	}

	public void setGrossLoss(double grossLoss) {
		this.grossLoss = grossLoss;
	}

	public double getAverageProfitTrade() {
		return averageProfitTrade;
	}

	public void setAverageProfitTrade(double averageProfitTrade) {
		this.averageProfitTrade = averageProfitTrade;
	}

	public double getAverageLossTrade() {
		return averageLossTrade;
	}

	public void setAverageLossTrade(double averageLossTrade) {
		this.averageLossTrade = averageLossTrade;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getNoOfLongWon() {
		return noOfLongWon;
	}

	public void setNoOfLongWon(int noOfLongWon) {
		this.noOfLongWon = noOfLongWon;
	}

	public int getNoOfShortWon() {
		return noOfShortWon;
	}

	public void setNoOfShortWon(int noOfShortWon) {
		this.noOfShortWon = noOfShortWon;
	}

}
