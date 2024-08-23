package com.bannershallmark.entity;


import javax.persistence.*;

@Entity
@Table(name = "affectedByCalander")
public class AffectedByCalander {
	
    @Id
    @Column(name = "affectedByCalanderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer affectedByCalanderID;
    
    @ManyToOne
	@JoinColumn(name = "calanderID")
	private Calander calander;
    
    @ManyToOne
	@JoinColumn(name = "trdpairsID")
	private TradePairs tradePairs;
    

	public Integer getAffectedByCalanderID() {
		return affectedByCalanderID;
	}

	public void setAffectedByCalanderID(Integer affectedByCalanderID) {
		this.affectedByCalanderID = affectedByCalanderID;
	}

	public Calander getCalander() {
		return calander;
	}

	public void setCalander(Calander calander) {
		this.calander = calander;
	}

	public TradePairs getTradePairs() {
		return tradePairs;
	}

	public void setTradePairs(TradePairs tradePairs) {
		this.tradePairs = tradePairs;
	}
    
    
    
    
    
     
}