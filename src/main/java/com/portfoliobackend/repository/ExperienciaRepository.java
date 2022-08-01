package com.portfoliobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfoliobackend.entity.Experiencia;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

}
