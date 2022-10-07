package sbp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sbp.dto.TransferRequest;
import sbp.model.Account;
import sbp.service.TransferService;

@RestController
public class AccountController {
	
	private final TransferService transferService;
	
	public AccountController(TransferService transferService) {
		this.transferService = transferService;
		
	}
	
	
	@PostMapping("/transfer")
	public void transferMoney(
			@RequestBody TransferRequest request
			) {
		
		transferService.transferMoney(request.getSenderAccountId(),
				request.getReciverAccountId(),
				request.getAmount());
		
				
				
		
	}
	
	
	@GetMapping("/accounts")
	public Iterable<Account> getAllAccounts(
			@RequestBody(required =false) String name
			
			){
		
		if(name == null) {
			return transferService.getAllAcounts();
			
		}else {
			return transferService.findAccountsByName(name);
			
		}
	}
		
	
	

}
