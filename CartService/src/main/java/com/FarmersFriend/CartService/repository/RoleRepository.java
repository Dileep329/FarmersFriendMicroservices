package com.FarmersFriend.CartService.repository;

import com.FarmersFriend.CartService.models.AppRole;
import com.FarmersFriend.CartService.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleName(AppRole appRole);
}
