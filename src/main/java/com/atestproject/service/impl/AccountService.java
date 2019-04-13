package com.atestproject.service.impl;

import com.atestproject.domain.Account;
import com.atestproject.exception.NotFoundException;
import com.atestproject.repository.AccountRepository;
import com.atestproject.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	private AccountRepository repo;

	@Override
	public Account addAccount(Account account) {
		return repo.save(account);
	}

	@Override
	public Account findAccount(long id) throws NotFoundException {
		if(!repo.existsById(id))
			throw new NotFoundException("code", "message");
		return repo.findById(id).get();
	}

	@Override
	public List<Account> findAllAccounts() {
		return repo.findAll();
	}

	@Override
	public void deleteAccount(long id) throws NotFoundException {
		if(!repo.existsById(id))
			throw new NotFoundException("code", "message");
		repo.deleteById(id);
	}

	@Override
	public List<Account> searchAccounts(Account accountDto) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findAccountByUsername(String username) throws NotFoundException {
		Account account = repo.findByUsername(username);
		if(account == null)
			throw new NotFoundException("code", "message");
		return account;
	}

}
