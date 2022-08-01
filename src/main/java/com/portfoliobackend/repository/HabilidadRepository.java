package com.portfoliobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfoliobackend.entity.Habilidad;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {

}
