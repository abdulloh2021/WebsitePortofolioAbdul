package com.domain.repository;

import com.domain.model.Portofolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortofolioRepo extends JpaRepository<Portofolio, Integer> {

}
