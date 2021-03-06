package com.atestproject.service;

import com.atestproject.domain.User;
import com.atestproject.dto.ProfileDTO;
import com.atestproject.exception.NotFoundException;
import com.atestproject.exception.ServiceException;

import java.util.List;

public interface IUserService {
	
	User addUser(User user) throws ServiceException;

	User findUser(long id) throws NotFoundException;

	List<User> findAllUsers();

	void deleteUser(long id) throws NotFoundException;

	List<User> searchUsers(User userDto) throws NotFoundException;

	User updateUser(User user) throws NotFoundException;
	
	User findUserByUsername(String username) throws NotFoundException;

	User getConnectedUser() throws NotFoundException;

    User updateUserProfile(ProfileDTO user);
}
