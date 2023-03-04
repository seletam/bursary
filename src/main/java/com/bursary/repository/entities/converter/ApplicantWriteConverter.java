package com.bursary.repository.entities.converter;

import com.bursary.repository.entities.Applicant;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.io.IOException;

@WritingConverter
public class ApplicantWriteConverter implements Converter<Applicant, String> {
    /**
         * @param applicant
     * @return
     */
    @Override
    public String convert(Applicant applicant) {
        try {
            return new ObjectMapper().writeValueAsString(applicant);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}


