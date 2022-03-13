package com.domain.service;

import java.util.List;
import java.util.Optional;

import com.domain.model.Portofolio;
import com.domain.repository.PortofolioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortofolioService {
    @Autowired
    private PortofolioRepo portofolioRepo;

    public void addPortofolio(Portofolio portofolio) {
        portofolioRepo.save(portofolio);
    }

    public void editPortofolio(Portofolio portofolio) {
        portofolioRepo.save(portofolio);
    }

    public List<Portofolio> getAllPortofolio() {
        return portofolioRepo.findAll();
    }

    public Portofolio getPortofolioById(int id) {
        Optional<Portofolio> portofolio = portofolioRepo.findById(id);
        if (portofolio.isPresent()) {
            return portofolio.get();
        }

        return null;
    }

    public void deletePortofolio(int id) {
        portofolioRepo.deleteById(id);
    }
}
