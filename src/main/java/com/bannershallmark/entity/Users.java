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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userlogin")
public class Users {

	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "LoginId")
	private String username;
	private String firstname;
	private String lastname;
	@Column(name = "Pwd")
	private String password;
	@Column(name = "EmailAddress")
	private String email;
	private String addressLine;

	@OneToOne
	@JoinColumn(name = "userRoleId")
	private Role role;
	private String active;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<TradeComment> tradeComments = new ArrayList<>();

//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//	private List<TradersAccounts> tradersAccounts = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<TradeComment> getTradeComments() {
		return tradeComments;
	}

	public void setTradeComments(List<TradeComment> tradeComments) {
		this.tradeComments = tradeComments;
	}

//	public List<TradersAccounts> getTradersAccounts() {
//		return tradersAccounts;
//	}
//
//	public void setTradersAccounts(List<TradersAccounts> tradersAccounts) {
//		this.tradersAccounts = tradersAccounts;
//	}

}
