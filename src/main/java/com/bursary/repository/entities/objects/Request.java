package com.bursary.repository.entities.objects;

import com.bursary.repository.entities.Applicant;
import com.bursary.services.state.ApplicationStatus;

public record Request(Applicant applicant, ApplicationStatus type) {
}