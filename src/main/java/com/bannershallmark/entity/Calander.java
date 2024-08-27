package com.bannershallmark.entity;

import java.sql.Date;
import java.time.LocalDateTime;

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
    private LocalDateTime startfrom;
    private LocalDateTime endto;
    
    
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
	public LocalDateTime getStartfrom() {
		return startfrom;
	}
	public void setStartfrom(LocalDateTime startfrom) {
		this.startfrom = startfrom;
	}
	public LocalDateTime getEndto() {
		return endto;
	}
	public void setEndto(LocalDateTime endto) {
		this.endto = endto;
	}
	
    
     
}