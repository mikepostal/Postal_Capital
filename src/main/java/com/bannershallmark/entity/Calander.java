package com.bannershallmark.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "calander")
public class Calander {
	
    @Id
    @Column(name = "calanderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer calanderID;
    private String calanderName;
    private String type;
    private String level;
    private Date startfrom;
    private Date endto;
    
    
	public Integer getCalanderID() {
		return calanderID;
	}
	public void setCalanderID(Integer calanderID) {
		this.calanderID = calanderID;
	}
	public String getCalanderName() {
		return calanderName;
	}
	public void setCalanderName(String calanderName) {
		this.calanderName = calanderName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
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