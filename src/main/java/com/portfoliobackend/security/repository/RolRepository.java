package com.portfoliobackend.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfoliobackend.security.entity.Rol;
import com.portfoliobackend.security.entity.enums.ERol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByName(ERol name);
}
