package com.supplyhouse.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplyhouse.accounts.model.AcceptInvitationRequest;
import com.supplyhouse.accounts.model.ApiResponse;
import com.supplyhouse.accounts.model.DeclineInvitationRequest;
import com.supplyhouse.accounts.model.InvitationRequest;
import com.supplyhouse.accounts.model.UnlinkRequest;
import com.supplyhouse.accounts.model.UpgradeRequest;
import com.supplyhouse.accounts.service.AccountService;
import com.supplyhouse.accounts.service.BusinessOwnerService;
import com.supplyhouse.accounts.service.InvitationService;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private InvitationService invitationService;

	@Autowired
	private BusinessOwnerService businessOwnerService;

	// Endpoint to upgrade an account to a business owner account
	@PostMapping("/accounts/upgrade")
	public ResponseEntity<ApiResponse> upgradeAccount(@RequestBody UpgradeRequest upgradeRequest) {
		boolean success = accountService.requestUpgrade(upgradeRequest.getAccountId());
		if (success) {
			accountService.addAccountToBusinessOwner(upgradeRequest.getAccountId());
			return new ResponseEntity<>(new ApiResponse("success", "Upgrade request submitted. Will be reviewed."),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					new ApiResponse("error",
							"Upgrade request denied. Ensure account has placed at least 10 orders in the past year."),
					HttpStatus.BAD_REQUEST);
		}
	}

	// Endpoint to send an invitation to a subaccount
	@PostMapping("/business/{businessOwnerId}/invite")
	public ResponseEntity<ApiResponse> sendInvitation(@PathVariable String businessOwnerId,
			@RequestBody InvitationRequest invitationRequest) {
		boolean success = businessOwnerService.sendInvitation(businessOwnerId, invitationRequest.getInviteeAccountId(),
				invitationRequest.getShareOrderHistory());
		if (success) {
			return new ResponseEntity<>(new ApiResponse("success", "Invitation sent successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponse("error",
					"Invitation could not be sent. Possible reasons: invitee is already linked to another business."),
					HttpStatus.BAD_REQUEST);
		}
	}

	// Endpoint to accept an invitation
	@PostMapping("/accounts/{accountId}/accept-invitation")
	public ResponseEntity<ApiResponse> acceptInvitation(@PathVariable String accountId,
			@RequestBody AcceptInvitationRequest acceptInvitationRequest) {
		boolean success = invitationService.acceptInvitation(accountId, acceptInvitationRequest.getBusinessOwnerId(),
				acceptInvitationRequest.getShareOrderHistory());
		if (success) {
			return new ResponseEntity<>(new ApiResponse("success", "Invitation accepted and account linked."),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponse("error",
					"Invitation acceptance failed. Possible reasons: invitation expired or already linked to another business."),
					HttpStatus.BAD_REQUEST);
		}
	}

	// Endpoint to decline an invitation
	@PostMapping("/accounts/{accountId}/decline-invitation")
	public ResponseEntity<ApiResponse> declineInvitation(@PathVariable String accountId,
			@RequestBody DeclineInvitationRequest declineInvitationRequest) {
		boolean success = invitationService.declineInvitation(accountId, declineInvitationRequest.getBusinessOwnerId());
		if (success) {
			return new ResponseEntity<>(new ApiResponse("success", "Invitation declined."), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					new ApiResponse("error",
							"Invitation decline failed. Possible reasons: invitation not found or already acted upon."),
					HttpStatus.BAD_REQUEST);
		}
	}

	// Endpoint to unlink a subaccount
	@PostMapping("/business/{businessOwnerId}/unlink")
	public ResponseEntity<ApiResponse> unlinkSubaccount(@PathVariable String businessOwnerId,
			@RequestBody UnlinkRequest unlinkRequest) {
		boolean success = businessOwnerService.unlinkSubaccount(businessOwnerId, unlinkRequest.getSubaccountId());
		if (success) {
			return new ResponseEntity<>(new ApiResponse("success", "Subaccount unlinked successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponse("error",
					"Failed to unlink subaccount. Possible reasons: subaccount not linked to this business owner."),
					HttpStatus.BAD_REQUEST);
		}
	}
}
