package com.example.cgpa.controller;

import com.example.cgpa.model.Subject;
import com.example.cgpa.service.CgpaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CgpaController {

    private final CgpaService cgpaService;

    public CgpaController(CgpaService cgpaService) {
        this.cgpaService = cgpaService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateCgpa(@RequestParam("gradePoint") List<Double> gradePoints,
                                @RequestParam("credit") List<Integer> credits,
                                Model model) {
        List<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < gradePoints.size(); i++) {
            subjects.add(new Subject(gradePoints.get(i), credits.get(i)));
        }
        double cgpa = cgpaService.calculateCgpa(subjects);
        model.addAttribute("cgpa", String.format("%.2f", cgpa));
        return "result";
    }
}