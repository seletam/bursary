package com.bursary.entities.objects;

import com.bursary.entities.Applicant;
import com.bursary.state.ApplicationStatus;

public record Request(Applicant applicant, ApplicationStatus type) {
}