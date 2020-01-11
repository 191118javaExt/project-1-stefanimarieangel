package com.revature.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Reimbursement implements Serializable {
	
	private int reimbId;
	private int reimbAmount;
	private Date reimbSubmitted;
	private Date reimbResolved;
	private String reimbDescription;
	private int reimbAuthor;
	private int statusId;
	private int reimbType;
	
	private static final long serialVersionUID = 2399083438878127163L;
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public int getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(int reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Date getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(Date reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public Date getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Date reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public int getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getReimbType() {
		return reimbType;
	}
	public void setReimbType(int reimbType) {
		this.reimbType = reimbType;
	}
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int reimbId, int reimbAmount, Date reimbSubmitted, Date reimbResolved, String reimbDescription,
			int reimbAuthor, int statusId, int reimbType) {
		
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.statusId = statusId;
		this.reimbType = reimbType;
	}
	@Override
	public int hashCode() {
		return Objects.hash(reimbId, reimbAmount, reimbSubmitted, reimbResolved, reimbDescription, reimbAuthor, statusId, reimbType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Reimbursement)) {
			return false;
		}
		
		Reimbursement other = (Reimbursement) obj;
		return (reimbId == other.reimbId) && (reimbAmount == other.reimbAmount)
				&& Objects.equals(reimbSubmitted, other.reimbSubmitted) && Objects.equals(reimbResolved, other.reimbResolved)
				&& Objects.equals(reimbDescription, other.reimbDescription) && reimbAuthor == other.reimbAuthor && statusId == other.statusId 
				&& reimbType == other.reimbType;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbAuthor=" + reimbAuthor + ", statusId=" + statusId + ", reimbType=" + reimbType + "]";
	}
	
	
}
