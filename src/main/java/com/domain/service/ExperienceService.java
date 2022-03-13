package com.domain.service;

import java.util.List;
import java.util.Optional;

import com.domain.model.Experience;
import com.domain.repository.ExperienceRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepo experienceRepo;

    public void addExperience(Experience experience) {
        experienceRepo.save(experience);
    }

    public void editExperience(Experience experience) {
        experienceRepo.save(experience);
    }

    public List<Experience> getAllExperience() {
        return experienceRepo.findAll();
    }

    public Experience getExperienceById(int id) {
        Optional<Experience> experience = experienceRepo.findById(id);
        if (experience.isPresent()) {
            return experience.get();
        }
        return null;
    }

    public void deleteExperience(int id) {
        experienceRepo.deleteById(id);
    }
}
