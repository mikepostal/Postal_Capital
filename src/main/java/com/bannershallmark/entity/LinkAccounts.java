package com.bannershallmark.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "linkaccounts")
public class LinkAccounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "demoAcc")
	private Accounts demoAcc;

	@OneToOne
	@JoinColumn(name = "realAcc")
	private Accounts realAcc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Accounts getDemoAcc() {
		return demoAcc;
	}

	public void setDemoAcc(Accounts demoAcc) {
		this.demoAcc = demoAcc;
	}

	public Accounts getRealAcc() {
		return realAcc;
	}

	public void setRealAcc(Accounts realAcc) {
		this.realAcc = realAcc;
	}

}
