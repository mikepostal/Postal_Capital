package com.bannershallmark.entity;

import javax.persistence.*;

@Entity
@Table(name = "marketInsightFile")
public class MarketInsightFile {

	@Id
	@Column(name = "marketInsightFileID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer marketInsightFileID;

	private String fileName;
	private String fileType;
	@Column(columnDefinition = "longblob")
	private byte[] data;

	public Integer getMarketInsightFileID() {
		return marketInsightFileID;
	}

	public void setMarketInsightFileID(Integer marketInsightFileID) {
		this.marketInsightFileID = marketInsightFileID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}