package com.bursary.entities;

import java.util.ArrayList;
import java.util.List;

public class Shortlist {
    static class Applicant {
        private String name;
        private double gpa;

        public Applicant(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public double getGpa() {
            return gpa;
        }
    }

    public static List<String> shortlist(List<Applicant> applicants, double threshold) {
        List<String> shortlisted = new ArrayList<>();
        for (Applicant applicant : applicants) {
            if (applicant.getGpa() >= threshold) {
                shortlisted.add(applicant.getName());
            }
        }
        return shortlisted;
    }
}
