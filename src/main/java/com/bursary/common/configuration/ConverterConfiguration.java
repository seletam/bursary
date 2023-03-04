package com.bursary.common.configuration;

import com.bursary.repository.entities.converter.ApplicantReadConverter;
import com.bursary.repository.entities.converter.ApplicantWriteConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import com.bursary.repository.entities.converter.QualificationReadConverter;
import com.bursary.repository.entities.converter.QualificationWriteConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConverterConfiguration extends AbstractCassandraConfiguration {

    @Value(value = "${spring.cassandra.keyspace-name}")
    private String keySpaceName;

    @Bean
    public CassandraCustomConversions customConversions() {

        List<Converter<?, ?>> converters = new ArrayList<>();

//        converters.add(new ApplicantReadConverter());
//        converters.add(new ApplicantWriteConverter());
        converters.add(new QualificationReadConverter());
        converters.add(new QualificationWriteConverter());

        return new CassandraCustomConversions(converters);
    }

    /**
     * @return
     */
    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }
}
