package com.portfoliobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfoliobackend.entity.Educacion;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {

}
