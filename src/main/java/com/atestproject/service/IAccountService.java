package com.atestproject.service;

import com.atestproject.domain.Account;
import com.atestproject.exception.NotFoundException;

import java.util.List;

public interface IAccountService {

	Account addAccount(Account accountd);

	Account findAccount(long id) throws NotFoundException;

	List<Account> findAllAccounts();

	void deleteAccount(long id) throws NotFoundException;

	List<Account> searchAccounts(Account accountdtDto) throws NotFoundException;
	
	Account findAccountByUsername(String username) throws NotFoundException;
}
