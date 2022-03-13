package com.domain.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.domain.model.Experience;
import com.domain.service.ExperienceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/setting-experience")
    public String settingExperience(Model model) {
        List<Experience> listExperience = experienceService.getAllExperience();
        model.addAttribute("dataListExperience", listExperience);
        return "experience";
    }

    @PostMapping("/setting-experience-add-register")
    public String experienceRegister(@ModelAttribute Experience experience, HttpSession session) {
        System.out.println(experience);
        experienceService.addExperience(experience);
        session.setAttribute("msg", "Experience added successfully");
        return "redirect:/setting-experience";
    }

    // edit via pindah page
    @GetMapping("/setting-experience-edit-{id}")
    public String editExperience(@PathVariable int id, Model model) {
        Experience experienceData = experienceService.getExperienceById(id);
        model.addAttribute("experienceData", experienceData);
        return "experience-edit";
    }

    @PostMapping("/setting-experience-edit-update")
    public String updateExperience(@ModelAttribute Experience experience, HttpSession session) {
        experienceService.addExperience(experience);
        session.setAttribute("msg", "Experience updated successfully");
        return "redirect:/setting-experience";
    }

    @GetMapping("/setting-experience-delete-{id}")
    public String deleteExperience(@PathVariable int id, HttpSession session) {
        experienceService.deleteExperience(id);
        session.setAttribute("msg", "Experience deleted successfully");
        return "redirect:/setting-experience";
    }

    // edit via model
    @PostMapping("/setting-experience-add-edit")
    public String editRegister(@ModelAttribute Experience experience, HttpSession session) {
        System.out.println(experience);
        experienceService.addExperience(experience);
        session.setAttribute("msg", "Experience edited successfully");
        return "redirect:/setting-experience";
    }
}
