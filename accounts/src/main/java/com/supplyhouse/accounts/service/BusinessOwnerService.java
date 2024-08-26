package com.supplyhouse.accounts.service;

import org.springframework.stereotype.Service;

@Service
public class BusinessOwnerService {
    public boolean sendInvitation(String businessOwnerId, String inviteeAccountId, String shareOrderHistoryFrom) {
        // Logic to send an invitation to Invitee Account
        return true;
    }

    public boolean unlinkSubaccount(String businessOwnerId, String subaccountId) {
        // Logic to unlink an account from Business Owner ID
        return true;
    }
}