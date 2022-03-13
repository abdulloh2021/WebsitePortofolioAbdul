package com.domain.service;

import java.util.List;
import java.util.Optional;

import com.domain.model.Training;
import com.domain.repository.TrainingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {
    @Autowired
    private TrainingRepo trainingRepo;

    public void addTraining(Training training) {
        trainingRepo.save(training);
    }

    public void editTraining(Training training) {
        trainingRepo.save(training);
    }

    public List<Training> getAllTraining() {
        return trainingRepo.findAll();
    }

    public Training getTrainingById(int id) {
        Optional<Training> training = trainingRepo.findById(id);
        if (training.isPresent()) {
            return training.get();
        }

        return null;
    }

    public void deleteTraining(int id) {
        trainingRepo.deleteById(id);
    }
}
