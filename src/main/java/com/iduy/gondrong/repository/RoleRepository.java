package com.iduy.gondrong.repository;

import com.iduy.gondrong.models.ERole;
import com.iduy.gondrong.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

