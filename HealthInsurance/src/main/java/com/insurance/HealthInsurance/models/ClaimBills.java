package com.insurance.HealthInsurance.models;

import java.util.Date;

public class ClaimBills {

    private int clamId;
    private short clblBillIndex;
    private String clblDocumentTitle;
    private String clblDocumentPath;
    private double clblClaimAmount;
    private double clblProcessedAmount;
    private Date clblProcessedDate;
    private int clblProcessedBy;
    private String clblRemarks;
    private String clblStatus;
    
    
	public ClaimBills() {
		
	}


	public int getClamId() {
		return clamId;
	}


	public short getClblBillIndex() {
		return clblBillIndex;
	}


	public String getClblDocumentTitle() {
		return clblDocumentTitle;
	}


	public String getClblDocumentPath() {
		return clblDocumentPath;
	}


	public double getClblClaimAmount() {
		return clblClaimAmount;
	}


	public double getClblProcessedAmount() {
		return clblProcessedAmount;
	}


	public Date getClblProcessedDate() {
		return clblProcessedDate;
	}


	public int getClblProcessedBy() {
		return clblProcessedBy;
	}


	public String getClblRemarks() {
		return clblRemarks;
	}


	public String getClblStatus() {
		return clblStatus;
	}


	public void setClamId(int clamId) {
		this.clamId = clamId;
	}


	public void setClblBillIndex(short clblBillIndex) {
		this.clblBillIndex = clblBillIndex;
	}


	public void setClblDocumentTitle(String clblDocumentTitle) {
		this.clblDocumentTitle = clblDocumentTitle;
	}


	public void setClblDocumentPath(String clblDocumentPath) {
		this.clblDocumentPath = clblDocumentPath;
	}


	public void setClblClaimAmount(double clblClaimAmount) {
		this.clblClaimAmount = clblClaimAmount;
	}


	public void setClblProcessedAmount(double clblProcessedAmount) {
		this.clblProcessedAmount = clblProcessedAmount;
	}


	public void setClblProcessedDate(Date clblProcessedDate) {
		this.clblProcessedDate = clblProcessedDate;
	}


	public void setClblProcessedBy(int clblProcessedBy) {
		this.clblProcessedBy = clblProcessedBy;
	}


	public void setClblRemarks(String clblRemarks) {
		this.clblRemarks = clblRemarks;
	}


	public void setClblStatus(String clblStatus) {
		this.clblStatus = clblStatus;
	}

	
   
}
