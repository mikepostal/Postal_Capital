package com.bannershallmark.entity;
import java.sql.Date;

import javax.persistence.*;

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
    
    private Date from;
    private Date to;
    
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
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
    
    
       
}