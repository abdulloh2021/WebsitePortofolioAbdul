package com.domain.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.domain.model.About;

import com.domain.service.AboutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AboutController {
    @Autowired
    private AboutService aboutService;

    @GetMapping("/setting-about")
    public String settingAbout(Model model) {
        List<About> listAbout = aboutService.getAllAbout();
        model.addAttribute("dataListAbout", listAbout);
        return "about";
    }

    @PostMapping("/setting-about-add-register")
    public String aboutRegister(@ModelAttribute About about, HttpSession session) {
        System.out.println(about);
        aboutService.addAbout(about);
        session.setAttribute("msg", "About added successfully");
        return "redirect:/setting-about";
    }

    // edit via pindah page
    @GetMapping("/setting-about-edit-{id}")
    public String editAbout(@PathVariable int id, Model model) {
        About aboutData = aboutService.getAboutById(id);
        model.addAttribute("aboutData", aboutData);
        return "about-edit";
    }

    @PostMapping("/setting-about-edit-update")
    public String updateAbout(@ModelAttribute About about, HttpSession session) {
        aboutService.addAbout(about);
        session.setAttribute("msg", "About updated successfully");
        return "redirect:/setting-about";
    }

    @GetMapping("/setting-about-delete-{id}")
    public String deleteAbout(@PathVariable int id, HttpSession session) {
        aboutService.deleteAbout(id);
        session.setAttribute("msg", "About deleted successfully");
        return "redirect:/setting-about";
    }

    // edit via model
    @PostMapping("/setting-about-add-edit")
    public String editRegister(@ModelAttribute About about, HttpSession session) {
        System.out.println(about);
        aboutService.addAbout(about);
        session.setAttribute("msg", "About edited successfully");
        return "redirect:/setting-about";
    }
}
