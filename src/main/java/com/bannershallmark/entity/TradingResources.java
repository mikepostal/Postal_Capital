package com.bannershallmark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TradingResources {
	@Id
	@Column(name = "resId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer resId;
	private String title;
	private String videoName;
	private String videoFileType;
	@Column(columnDefinition = "longblob")
	private byte[] videoData;

	private String documentName;
	private String documentFileType;
	@Column(columnDefinition = "longblob")
	private byte[] documentData;

	@Column(columnDefinition = "longblob")
	private String description;

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoFileType() {
		return videoFileType;
	}

	public void setVideoFileType(String videoFileType) {
		this.videoFileType = videoFileType;
	}

	public byte[] getVideoData() {
		return videoData;
	}

	public void setVideoData(byte[] videoData) {
		this.videoData = videoData;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentFileType() {
		return documentFileType;
	}

	public void setDocumentFileType(String documentFileType) {
		this.documentFileType = documentFileType;
	}

	public byte[] getDocumentData() {
		return documentData;
	}

	public void setDocumentData(byte[] documentData) {
		this.documentData = documentData;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
