package com.bursary.repository.entities.converter;

import com.bursary.repository.entities.Qualification;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.io.IOException;

@WritingConverter
public class QualificationWriteConverter implements Converter<Qualification, String> {
    /**
         * @param qualification
     * @return
     */
    @Override
    public String convert(Qualification qualification) {
        try {
            return new ObjectMapper().writeValueAsString(qualification);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}


