package com.domain.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.domain.model.Portofolio;
import com.domain.service.PortofolioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PortofolioController {
    @Autowired
    private PortofolioService portofolioService;

    @GetMapping("/setting-portofolio")
    public String settingPortofolio(Model model) {
        List<Portofolio> listPortofolio = portofolioService.getAllPortofolio();

        model.addAttribute("dataListPortofolio", listPortofolio);
        return "portofolio";
    }

    @PostMapping("/setting-portofolio-add-register")
    public String portofolioRegister(@ModelAttribute Portofolio portofolio, HttpSession session) {
        System.out.println(portofolio);
        portofolioService.addPortofolio(portofolio);
        session.setAttribute("msg", "Portofolio added successfully");
        return "redirect:/setting-portofolio";
    }

    // edit via pindah page
    @GetMapping("/setting-portofolio-edit-{id}")
    public String editPortofolio(@PathVariable int id, Model model) {
        Portofolio portofolioData = portofolioService.getPortofolioById(id);
        model.addAttribute("portofolioData", portofolioData);
        return "portofolio-edit";
    }

    // view via pindah page
    @GetMapping("/portofolio-view-{id}")
    public String viewPortofolio(@PathVariable int id, Model model) {
        Portofolio portofolioData = portofolioService.getPortofolioById(id);
        model.addAttribute("portofolioData", portofolioData);
        return "portofolio-view";
    }

    @PostMapping("/setting-portofolio-edit-update")
    public String updatePortofolio(@ModelAttribute Portofolio portofolio, HttpSession session) {
        portofolioService.addPortofolio(portofolio);
        session.setAttribute("msg", "Portofolio updated successfully");
        return "redirect:/setting-portofolio";
    }

    @GetMapping("/setting-portofolio-delete-{id}")
    public String deletePortofolio(@PathVariable int id, HttpSession session) {
        portofolioService.deletePortofolio(id);
        session.setAttribute("msg", "Portofolio deleted successfully");
        return "redirect:/setting-portofolio";
    }

    // edit via model
    @PostMapping("/setting-portofolio-add-edit")
    public String editRegister(@ModelAttribute Portofolio portofolio, HttpSession session) {
        System.out.println(portofolio);
        portofolioService.addPortofolio(portofolio);
        session.setAttribute("msg", "Portofolio edited successfully");
        return "redirect:/setting-portofolio";
    }
}
