package com.example.cgpa.service;

import com.example.cgpa.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CgpaService {
    public double calculateCgpa(List<Subject> subjects) {
        double totalPoints = 0;
        int totalCredits = 0;
        for (Subject s : subjects) {
            totalPoints += s.getGradePoint() * s.getCredit();
            totalCredits += s.getCredit();
        }
        return totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }
}