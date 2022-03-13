package com.domain.service;

import java.util.List;
import java.util.Optional;

import com.domain.model.Profile;
import com.domain.repository.ProfileRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    public void addProfile(Profile profile) {
        profileRepo.save(profile);
    }

    public void editProfile(Profile profile) {
        profileRepo.save(profile);
    }

    public List<Profile> getAllProfile() {
        return profileRepo.findAll();
    }

    public Profile getProfileById(int id) {
        Optional<Profile> profile = profileRepo.findById(id);
        if (profile.isPresent()) {
            return profile.get();
        }
        return null;
    }

    public void deleteProfile(int id) {
        profileRepo.deleteById(id);
    }
}
