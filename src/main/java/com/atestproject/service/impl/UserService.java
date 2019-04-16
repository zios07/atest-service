package com.atestproject.service.impl;

import com.atestproject.domain.Role;
import com.atestproject.domain.User;
import com.atestproject.exception.NotFoundException;
import com.atestproject.repository.UserRepository;
import com.atestproject.service.IRoleService;
import com.atestproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {
        if (repo.count() == 0) {
            user.setRole(roleService.getRoleAdmin());
        } else {
            if (user.getRole() == null) {
                Role role = roleService.getRoleUser();
                user.setRole(role);
            }
        }

        if (user.getAccount() != null) {
            user.getAccount().setPassword(passwordEncoder.encode(user.getAccount().getPassword()));
        }
        return repo.save(user);
    }

    @Override
    public User findUser(long id) throws NotFoundException {
        if (!repo.existsById(id))
            throw new NotFoundException("USER.NOT.FOUND", "No user found with id: " + id);
        return repo.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = repo.findAll();
        users.stream().filter(user -> Objects.nonNull(user.getAccount()))
                .collect(Collectors.toList())
                .forEach(user -> {
                    user.getAccount().setPassword(null);
                });
        return users;
    }

    @Override
    public void deleteUser(long id) throws NotFoundException {
        if (!repo.existsById(id))
            throw new NotFoundException("USER.NOT.FOUND", "No user found with id: " + id);
        repo.deleteById(id);
    }

    @Override
    public List<User> searchUsers(User userDto) throws NotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User updateUser(User user) throws NotFoundException {
        if (!repo.existsById(user.getId()))
            throw new NotFoundException("USER.NOT.FOUND", "No user found with id: " + user.getId());
        return repo.save(user);
    }

    @Override
    public User findUserByUsername(String username) throws NotFoundException {
        User user = repo.findByAccountUsername(username);
        if (user == null)
            throw new NotFoundException("USER.NOT.FOUND", "No user found with username: " + username);
        return user;
    }

    @Override
    public User getConnectedUser() throws NotFoundException {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.findUserByUsername(username);

    }
}
