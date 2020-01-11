package com.revature.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ReimbursementDTO implements Serializable {

	private static final long serialVersionUID = -2599858684487092879L;
	
	private int reimbId;
	private int reimbAmount;
	private Date reimbSubmitted;
	private Date reimbResolved;
	private String reimbDescription;
	private int reimbAuthor;
	private int statusId;
	private int reimbType;
	
	public ReimbursementDTO() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public ReimbursementDTO(int reimbId, int reimbAmount, Date reimbSubmitted, Date reimbResolved,
			String reimbDescription, int reimbAuthor, int statusId, int reimbType) {
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

	@Override
	public int hashCode() {
		return Objects.hash(reimbAmount, reimbAuthor, reimbDescription, reimbId, reimbResolved, reimbSubmitted,
				reimbType, statusId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ReimbursementDTO)) {
			return false;
		}
		ReimbursementDTO other = (ReimbursementDTO) obj;
		return reimbAmount == other.reimbAmount && reimbAuthor == other.reimbAuthor
				&& Objects.equals(reimbDescription, other.reimbDescription) && reimbId == other.reimbId
				&& Objects.equals(reimbResolved, other.reimbResolved)
				&& Objects.equals(reimbSubmitted, other.reimbSubmitted) && reimbType == other.reimbType
				&& statusId == other.statusId;
	}

	@Override
	public String toString() {
		return "ReimbursementDTO [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbAuthor=" + reimbAuthor + ", statusId=" + statusId + ", reimbType=" + reimbType + "]";
	}
	
}
//
//reimb_id SERIAL PRIMARY KEY,
//reimb_amount INTEGER,
//reimb_submitted TIMESTAMP,
//reimb_resolved TIMESTAMP,
//reimb_description VARCHAR (250),
//reimb_receipt BYTEA,
//reimb_author INTEGER REFERENCES project_1.ers_user (ers_user_id),
//reimb_resolver INTEGER REFERENCES project_1.ers_user (ers_user_id),
//reimb_status_id INTEGER REFERENCES project_1.ers_reimbursement_status (reimb_status_id),
//reimb_type_id INT

//package com.revature.models;

//import java.io.Serializable;
//import java.util.Objects;
//
//public class EmployeeDTO implements Serializable {
//
//	private static final long serialVersionUID = 7368277144445969032L;
//
//	private int id;
//	private String firstName;
//	private String lastName;
//	private String username;
//	private String password;
//
//	private String hireDate;
