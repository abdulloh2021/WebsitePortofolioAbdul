package com.domain.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.domain.model.Profile;
import com.domain.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/setting-profile")
    public String settingProfile(Model model) {
        List<Profile> listProfile = profileService.getAllProfile();
        model.addAttribute("dataListProfile", listProfile);
        return "profile";
    }

    @PostMapping("/setting-profile-add-register")
    public String profileRegister(@ModelAttribute Profile profile, HttpSession session) {
        System.out.println(profile);
        profileService.addProfile(profile);
        session.setAttribute("msg", "profile added successfully");
        return "redirect:/setting-profile";
    }

    // edit via pindah page
    @GetMapping("/setting-profile-edit-{id}")
    public String editProfile(@PathVariable int id, Model model) {
        Profile profileData = profileService.getProfileById(id);
        model.addAttribute("profileData", profileData);
        return "profile-edit";
    }

    @PostMapping("/setting-profile-edit-update")
    public String updatProfile(@ModelAttribute Profile profile, HttpSession session) {
        profileService.addProfile(profile);
        session.setAttribute("msg", "profile updated successfully");
        return "redirect:/setting-profile";
    }

    @GetMapping("/setting-profile-delete-{id}")
    public String deleteProfile(@PathVariable int id, HttpSession session) {
        profileService.deleteProfile(id);
        session.setAttribute("msg", "profile deleted successfully");
        return "redirect:/setting-profile";
    }

    // edit via model
    @PostMapping("/setting-profile-add-edit")
    public String editRegister(@ModelAttribute Profile profile, HttpSession session) {
        System.out.println(profile);
        profileService.addProfile(profile);
        session.setAttribute("msg", "profile edited successfully");
        return "redirect:/setting-profile";
    }
}
