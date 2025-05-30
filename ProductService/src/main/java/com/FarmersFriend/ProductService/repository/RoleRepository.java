package com.FarmersFriend.ProductService.repository;


import com.FarmersFriend.ProductService.models.AppRole;
import com.FarmersFriend.ProductService.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleName(AppRole appRole);
}
