package com.domain.controller;

import java.util.List;

import com.domain.model.About;
import com.domain.model.Education;
import com.domain.model.Experience;
import com.domain.model.Portofolio;
import com.domain.model.Profile;
import com.domain.model.Training;
import com.domain.service.AboutService;
import com.domain.service.EducationService;
import com.domain.service.ExperienceService;
import com.domain.service.PortofolioService;
import com.domain.service.ProfileService;
import com.domain.service.TrainingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @Autowired
    private AboutService aboutService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private PortofolioService portofolioService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private TrainingService trainingService;

    @GetMapping("/")
    public String testIndex(Model model) {
        List<About> listAbout = aboutService.getAllAbout();
        model.addAttribute("dataListAbout", listAbout);
        List<Education> listEducation = educationService.getAllEducation();
        model.addAttribute("dataListEducation", listEducation);
        List<Experience> listExperience = experienceService.getAllExperience();
        model.addAttribute("dataListExperience", listExperience);
        List<Portofolio> listPortofolio = portofolioService.getAllPortofolio();
        model.addAttribute("dataListPortofolio", listPortofolio);
        List<Profile> listProfile = profileService.getAllProfile();
        model.addAttribute("dataListProfile", listProfile);
        List<Training> listTraining = trainingService.getAllTraining();
        model.addAttribute("dataListTraining", listTraining);
        return "index";
    }

    @GetMapping("/dashboard")
    public String testMenu() {
        return "main";
    }
}
