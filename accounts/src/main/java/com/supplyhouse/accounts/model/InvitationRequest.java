package com.supplyhouse.accounts.model;

public class InvitationRequest {

	private String inviteeAccountId;
    private String shareOrderHistory;
    
	public String getInviteeAccountId() {
		return inviteeAccountId;
	}
	public void setInviteeAccountId(String inviteeAccountId) {
		this.inviteeAccountId = inviteeAccountId;
	}
	public String getShareOrderHistory() {
		return shareOrderHistory;
	}
	public void setShareOrderHistory(String shareOrderHistory) {
		this.shareOrderHistory = shareOrderHistory;
	}
    
    
    
}
