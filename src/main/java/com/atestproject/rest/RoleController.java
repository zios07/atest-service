package com.atestproject.rest;

import com.atestproject.domain.Role;
import com.atestproject.exception.ServiceException;
import com.atestproject.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RoleController {

	@Autowired
	private IRoleService service;

	@GetMapping
	public List<Role> findAll() {
		return service.findAll();
	}

	@RequestMapping
	public Role findRoleByUsername(@RequestParam String username) throws ServiceException {
		return service.findRoleByUsername(username);
	}

}
