package com.example.cgpa.model;

public class Subject {
    private double gradePoint;
    private int credit;

    public Subject(double gradePoint, int credit) {
        this.gradePoint = gradePoint;
        this.credit = credit;
    }

    public double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(double gradePoint) {
        this.gradePoint = gradePoint;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}