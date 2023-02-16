package com.bursary.utils;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionFactoryFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

//@Configuration
//public class CassandraConfig {
//
//    @Value("${spring.cassandra.local-datacenter}")
//    private String dataCenter;
//    @Value("${spring.cassandra.keyspace-name}")
//    private String keySpaceName;
//    @Value("${spring.cassandra.port}")
//    private int port;
//    @Value("${spring.cassandra.contact-points}")
//    private String contactPoints;
//
//    @Value("${spring.cassandra.schema-action}")
//    private SchemaAction schemaAction;
//
//    @Bean
//    public CqlSessionFactoryBean session() {
//        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
//        session.setContactPoints(contactPoints);
//        session.setKeyspaceName(keySpaceName);
//        session.setLocalDatacenter(dataCenter);
//        session.setSchemaAction(schemaAction);
//        session.setPort(port);
//        return session;
//    }
//
//    @Bean
//    public SessionFactoryFactoryBean sessionFactory(CqlSession session, CassandraConverter converter) {
//        SessionFactoryFactoryBean sessionFactory = new SessionFactoryFactoryBean();
//        sessionFactory.setSession(session);
//        sessionFactory.setConverter(converter);
//        sessionFactory.setSchemaAction(SchemaAction.CREATE_IF_NOT_EXISTS);
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public CassandraMappingContext mappingContext(CqlSession cqlSession) {
//
//        CassandraMappingContext mappingContext = new CassandraMappingContext();
//        mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cqlSession));
//
//        return mappingContext;
//    }
//
//    @Bean
//    public CassandraConverter converter(CassandraMappingContext mappingContext) {
//        return new MappingCassandraConverter(mappingContext);
//    }
//
//    @Bean
//    public CassandraOperations cassandraTemplate(SessionFactory sessionFactory, CassandraConverter converter) {
//        return new CassandraTemplate(sessionFactory, converter);
//    }
//}
