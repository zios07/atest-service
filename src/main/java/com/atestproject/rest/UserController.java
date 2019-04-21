package com.atestproject.rest;

import com.atestproject.domain.User;
import com.atestproject.dto.ProfileDTO;
import com.atestproject.exception.NotFoundException;
import com.atestproject.exception.ServiceException;
import com.atestproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<User> findUser(@PathVariable long id) throws NotFoundException {
		User user = service.findUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}


	@GetMapping(value = "/find/connected")
	public ResponseEntity<User> findUser() throws NotFoundException {
		User user = service.getConnectedUser();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> findAllUsers() {
		List<User> users = service.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping("register")
	public ResponseEntity<User> addUser(@RequestBody User user) throws ServiceException {
		User savedUser = service.addUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) throws NotFoundException {
        User updatedUser = service.updateUser(user);
        return new ResponseEntity<User>(updatedUser, HttpStatus.CREATED);
    }

    @PutMapping(value = "profile")
    public ResponseEntity<User> updateUserProfile(@RequestBody ProfileDTO profile) throws NotFoundException {
        User updatedUser = service.updateUserProfile(profile);
        return new ResponseEntity<User>(updatedUser, HttpStatus.CREATED);
    }

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable long id) throws NotFoundException {
		service.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/search")
	public ResponseEntity<List<User>> searchUsers(@RequestBody User userDto) throws NotFoundException {
		List<User> users = service.searchUsers(userDto);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}


}
