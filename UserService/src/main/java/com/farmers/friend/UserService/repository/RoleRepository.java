package com.farmers.friend.UserService.repository;

import com.farmers.friend.UserService.models.AppRole;
import com.farmers.friend.UserService.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleName(AppRole appRole);
}
