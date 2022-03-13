package com.domain.repository;

import com.domain.model.Training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepo extends JpaRepository<Training, Integer> {

}
