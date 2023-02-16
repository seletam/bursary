package com.bursary.state;

import com.bursary.entities.Applicant;

import java.util.List;

public interface ApplicationState  {
    public Applicant review(Applicant t);
}

