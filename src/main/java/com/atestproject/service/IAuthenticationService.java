package com.atestproject.service;

import com.atestproject.domain.Account;
import com.atestproject.exception.BadCredentialsException;
import com.atestproject.exception.NotFoundException;

public interface IAuthenticationService {

	Account authenticate(Account account) throws NotFoundException, BadCredentialsException;
}
