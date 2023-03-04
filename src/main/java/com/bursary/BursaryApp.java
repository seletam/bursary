package com.bursary;

import com.bursary.entities.Applicant;
import com.bursary.entities.Application;
import com.bursary.entities.Status;
import com.bursary.entities.Study;
import com.bursary.entities.objects.GENDER;
import com.bursary.services.ApplicationContext;
import com.bursary.state.ApplicationStatus;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Locale;
import java.util.Random;

@EnableCaching
@EnableCassandraRepositories
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@RequiredArgsConstructor
public class BursaryApp implements CommandLineRunner {

	private final ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(BursaryApp.class, args);
	}

	@Override
	public void run(String... args) {
		var faker = new Faker(Locale.getDefault(), new Random());
		var study = Study.studyBuilder()
				.name(faker.university().name())
				.build();
//
		var applicant = Applicant.applicantBuilder()
				.dob(faker.date().birthday())
				.email(faker.name().firstName() + "." + faker.name().lastName() + "@gmail.com")
				.gender(GENDER.MALE)
				.firstName(faker.name().firstName())
				.lastName(faker.name().lastName())
				.referenceNo(faker.crypto().sha256())
				.middleName(faker.name().nameWithMiddle())
				.id(Uuids.timeBased())
//				.study(study)
				.build();

		var status = Status.StatusBuilder()
				.status(ApplicationStatus.CREATED)
				.approvedBy(faker.name().fullName() + " " + faker.name().lastName())
				.build();

		var application = Application.ApplicationBuilder()
//				.gpa(78)
				.applicant(applicant)
				.status(status)
				.build();
//
		var exec = applicationContext.processApplicationState(application);
		System.out.println("exec = " + exec);
	}
}
