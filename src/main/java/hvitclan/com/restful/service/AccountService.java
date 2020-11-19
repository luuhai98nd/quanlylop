package hvitclan.com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hvitclan.com.restful.entites.Account;
import hvitclan.com.restful.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public boolean checkLogin(Account account) {
		List<Account> listAccounts = accountRepository.findAll();
		for(Account account2 : listAccounts) {
			if(account.getUsername().equals(account2.getUsername())&&(account.getPassword().equals(account2.getPassword()))) return true;
		}
		return false;
	}
}
