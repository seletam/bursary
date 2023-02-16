package com.bursary.services;

import java.util.ArrayList;
import java.util.List;

public final class BursaryApplicantService {

    private List<BursaryApplicant> applicants;

    public BursaryApplicantService() {
        this.applicants = new ArrayList<>();
    }

    public void addApplicant(BursaryApplicant applicant) {
        this.applicants.add(applicant);
    }

    public List<BursaryApplicant> getApplicants() {
        return this.applicants;
    }

    public void approveApplicant(BursaryApplicant applicant) {
        applicant.setStatus("approved");
    }

    public void rejectApplicant(BursaryApplicant applicant) {
        applicant.setStatus("rejected");
    }

    public List<BursaryApplicant> getApprovedApplicants() {
        List<BursaryApplicant> approvedApplicants = new ArrayList<>();
        for (BursaryApplicant applicant : this.applicants) {
            if (applicant.getStatus().equals("approved")) {
                approvedApplicants.add(applicant);
            }
        }
        return approvedApplicants;
    }

    public List<BursaryApplicant> getRejectedApplicants() {
        List<BursaryApplicant> rejectedApplicants = new ArrayList<>();
        for (BursaryApplicant applicant : this.applicants) {
            if (applicant.getStatus().equals("rejected")) {
                rejectedApplicants.add(applicant);
            }
        }
        return rejectedApplicants;
    }
}