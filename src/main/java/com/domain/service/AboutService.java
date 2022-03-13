package com.domain.service;

import java.util.List;
import java.util.Optional;

import com.domain.model.About;
import com.domain.repository.AboutRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutService {
    @Autowired
    private AboutRepo aboutRepo;

    public void addAbout(About about) {
        aboutRepo.save(about);
    }

    public void editAbout(About about) {
        aboutRepo.save(about);
    }

    public List<About> getAllAbout() {
        return aboutRepo.findAll();
    }

    public About getAboutById(int id) {
        Optional<About> about = aboutRepo.findById(id);
        if (about.isPresent()) {
            return about.get();
        }

        return null;
    }

    public void deleteAbout(int id) {
        aboutRepo.deleteById(id);
    }
}
