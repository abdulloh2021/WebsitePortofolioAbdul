package com.domain.repository;

import com.domain.model.About;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepo extends JpaRepository<About, Integer> {

}
