package com.domain.service;

import java.util.List;
import java.util.Optional;

import com.domain.model.Education;
import com.domain.repository.EducationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {
    @Autowired
    private EducationRepo educationRepo;

    public void addEducation(Education education) {
        educationRepo.save(education);
    }

    public void editEducation(Education education) {
        educationRepo.save(education);
    }

    public List<Education> getAllEducation() {
        return educationRepo.findAll();
    }

    public Education getEducationById(int id) {
        Optional<Education> education = educationRepo.findById(id);
        if (education.isPresent()) {
            return education.get();
        }

        return null;
    }

    public void deleteEducation(int id) {
        educationRepo.deleteById(id);
    }
}
