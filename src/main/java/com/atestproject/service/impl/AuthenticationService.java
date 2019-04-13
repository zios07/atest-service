package com.atestproject.service.impl;

import com.atestproject.domain.Account;
import com.atestproject.exception.BadCredentialsException;
import com.atestproject.exception.NotFoundException;
import com.atestproject.repository.AccountRepository;
import com.atestproject.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired 
	private AccountRepository accountRepo;
	
	@Override
	public Account authenticate(Account credentials) throws NotFoundException, BadCredentialsException {
		Account account = accountRepo.findByUsername(credentials.getUsername());
		if(account == null || (account.getPassword() != null && !account.getPassword().equals(credentials.getPassword())))
			throw new BadCredentialsException("AUTHENTICATION.ERROR", "Bad credentials");
		return account;
	}

}
