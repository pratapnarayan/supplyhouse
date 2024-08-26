package com.supplyhouse.accounts;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Invitation {
	
	@Id
	private String invitationId;
    private int businessOwnerId;
    private int inviteeAccountId;
    private Date invitationDate;
    private String shareOrderHistory;
    private boolean isAccepted;
    
    
    
	public Invitation() {
		
	}

	public Invitation(String invitationId, int businessOwnerId, int inviteeAccountId, Date invitationDate,
			String shareOrderHistory, boolean isAccepted) {
		super();
		this.invitationId = invitationId;
		this.businessOwnerId = businessOwnerId;
		this.inviteeAccountId = inviteeAccountId;
		this.invitationDate = invitationDate;
		this.shareOrderHistory = shareOrderHistory;
		this.isAccepted = isAccepted;
	}

	public String getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}

	public int getBusinessOwnerId() {
		return businessOwnerId;
	}

	public void setBusinessOwnerId(int businessOwnerId) {
		this.businessOwnerId = businessOwnerId;
	}

	public int getInviteeAccountId() {
		return inviteeAccountId;
	}

	public void setInviteeAccountId(int inviteeAccountId) {
		this.inviteeAccountId = inviteeAccountId;
	}

	public Date getInvitationDate() {
		return invitationDate;
	}

	public void setInvitationDate(Date invitationDate) {
		this.invitationDate = invitationDate;
	}

	public String getShareOrderHistory() {
		return shareOrderHistory;
	}

	public void setShareOrderHistory(String shareOrderHistory) {
		this.shareOrderHistory = shareOrderHistory;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
    
    

}
