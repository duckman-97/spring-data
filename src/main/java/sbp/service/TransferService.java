package sbp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbp.exceptions.AccountNotFoundException;
import sbp.model.Account;
import sbp.repository.AccountRepository;

@Service
public class TransferService {
	
	private final AccountRepository accountRepository;
	
	
	
	public TransferService(
			AccountRepository accountRepository
			) {
		this.accountRepository = accountRepository;
		
		
	}
	
	@Transactional
	public void transferMoney(    
			long idSender, 
		    long idReceiver, 
		    BigDecimal amount) {
		Account sender = accountRepository.findById(idSender) //findById가 자동으로 생겨있음
						.orElseThrow(() -> new AccountNotFoundException());  
		
		Account reciver = accountRepository.findById(idReceiver)
				.orElseThrow(()->new AccountNotFoundException());
		
		
		 
	    BigDecimal senderNewAmount =                             
	      sender.getAmount().subtract(amount);                   
	 
	    BigDecimal receiverNewAmount =                           
	    		reciver.getAmount().add(amount);                      

	    
	    accountRepository                                        
	      .changeAmount(idSender, senderNewAmount);              
	 
	    accountRepository                                        
	      .changeAmount(idReceiver, receiverNewAmount);          


		

	}
	public Iterable<Account> getAllAcounts(){
		return accountRepository.findAll();
		
	}
	
	public List<Account> findAccountsByName(String name){
		return accountRepository.findAccountsByName(name);
		
	}
	

}
