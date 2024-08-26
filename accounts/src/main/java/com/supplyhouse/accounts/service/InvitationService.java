package com.supplyhouse.accounts.service;

import org.springframework.stereotype.Service;

@Service
public class InvitationService {
    public boolean acceptInvitation(String accountId, String businessOwnerId, String shareOrderHistoryFrom) {
        // Logic to accept invitation from Business Owner
        return true;
    }

    public boolean declineInvitation(String accountId, String businessOwnerId) {
        // Logic to decline invitation from Business Owner
        return true; 
    }
}
