package com.atestproject.repository;

import com.atestproject.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleCode(String roleCode);
}
