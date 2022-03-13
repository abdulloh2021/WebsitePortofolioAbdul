package com.domain.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.domain.model.Education;

import com.domain.service.EducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping("/setting-education")
    public String settingEducation(Model model) {
        List<Education> listEducation = educationService.getAllEducation();
        model.addAttribute("dataListEducation", listEducation);
        return "education";
    }

    @PostMapping("/setting-education-add-register")
    public String educationRegister(@ModelAttribute Education education, HttpSession session) {
        System.out.println(education);
        educationService.addEducation(education);
        session.setAttribute("msg", "Education added successfully");
        return "redirect:/setting-education";
    }

    // edit via pindah page
    @GetMapping("/setting-education-edit-{id}")
    public String editEducation(@PathVariable int id, Model model) {
        Education educationData = educationService.getEducationById(id);
        model.addAttribute("educationData", educationData);
        return "education-edit";
    }

    @PostMapping("/setting-education-edit-update")
    public String updateEducation(@ModelAttribute Education education, HttpSession session) {
        educationService.addEducation(education);
        session.setAttribute("msg", "Education updated successfully");
        return "redirect:/setting-education";
    }

    @GetMapping("/setting-education-delete-{id}")
    public String deleteEducation(@PathVariable int id, HttpSession session) {
        educationService.deleteEducation(id);
        session.setAttribute("msg", "Education deleted successfully");
        return "redirect:/setting-education";
    }

    // edit via model
    @PostMapping("/setting-education-add-edit")
    public String editRegister(@ModelAttribute Education education, HttpSession session) {
        System.out.println(education);
        educationService.addEducation(education);
        session.setAttribute("msg", "Education edited successfully");
        return "redirect:/setting-education";
    }
}
