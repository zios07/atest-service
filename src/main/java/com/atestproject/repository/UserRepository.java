package com.atestproject.repository;

import com.atestproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByAccountId(Long accountID);
	User findByAccountUsername(String username);

	
}	
