package com.bursary.repository.entities.converter;

import com.bursary.repository.entities.Qualification;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.util.StringUtils;

import java.io.IOException;

@ReadingConverter
public class QualificationReadConverter implements Converter<String, Qualification> {
    /**
     * @param source
     * @return
     */
    @Override
    public Qualification convert(String source) {
        if (StringUtils.hasText(source)) {
            try {
                return new ObjectMapper().readValue(source, Qualification.class);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        return null;
    }
}
