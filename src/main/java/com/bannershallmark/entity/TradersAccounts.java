package com.bannershallmark.entity;

import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tradersAccounts")
public class TradersAccounts {

	@Id
	@Column(name = "trdAccountID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trdAccountID;

	@ManyToOne
	@JoinColumn(name = "accountID")
	private Accounts account;

	@ManyToOne
	@JoinColumn(name = "userId")
	private Users user;

	private Date startfrom;
	private Date endto;

	public TradersAccounts() {
	}

	public Integer getTrdAccountID() {
		return trdAccountID;
	}

	public void setTrdAccountID(Integer trdAccountID) {
		this.trdAccountID = trdAccountID;
	}

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getStartfrom() {
		return startfrom;
	}

	public void setStartfrom(Date startfrom) {
		this.startfrom = startfrom;
	}

	public Date getEndto() {
		return endto;
	}

	public void setEndto(Date endto) {
		this.endto = endto;
	}

}