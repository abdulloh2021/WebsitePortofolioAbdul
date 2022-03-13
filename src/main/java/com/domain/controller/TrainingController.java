package com.domain.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.domain.model.Training;
import com.domain.service.TrainingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    @GetMapping("/setting-training")
    public String settingTraining(Model model) {
        List<Training> listTraining = trainingService.getAllTraining();
        model.addAttribute("dataListTraining", listTraining);
        return "training";
    }

    @PostMapping("/setting-training-add-register")
    public String trainingRegister(@ModelAttribute Training training, HttpSession session) {
        System.out.println(training);
        trainingService.addTraining(training);
        session.setAttribute("msg", "Training added successfully");
        return "redirect:/setting-training";
    }

    // edit via pindah page
    @GetMapping("/setting-training-edit-{id}")
    public String editTraining(@PathVariable int id, Model model) {
        Training trainingData = trainingService.getTrainingById(id);
        model.addAttribute("trainingData", trainingData);
        return "training-edit";
    }

    @PostMapping("/setting-training-edit-update")
    public String updateTraining(@ModelAttribute Training training, HttpSession session) {
        trainingService.addTraining(training);
        session.setAttribute("msg", "Training updated successfully");
        return "redirect:/setting-training";
    }

    @GetMapping("/setting-training-delete-{id}")
    public String deleteTraining(@PathVariable int id, HttpSession session) {
        trainingService.deleteTraining(id);
        session.setAttribute("msg", "Training deleted successfully");
        return "redirect:/setting-training";
    }

    // edit via model
    @PostMapping("/setting-training-add-edit")
    public String editRegister(@ModelAttribute Training training, HttpSession session) {
        System.out.println(training);
        trainingService.addTraining(training);
        session.setAttribute("msg", "Training edited successfully");
        return "redirect:/setting-training";
    }
}
