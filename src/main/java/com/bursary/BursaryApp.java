package com.bursary;

import com.bursary.common.constant.ADDRESS_TYPE;
import com.bursary.common.constant.GENDER;
import com.bursary.repository.entities.*;
import com.bursary.services.ApplicantService;
import com.bursary.services.BursaryApplicationContext;
import com.bursary.services.state.ApplicationStatus;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.cassandra.config.EnableCassandraAuditing;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.*;

@EnableCaching
@EnableCassandraAuditing
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
//				.gender(GENDER.MALE)
				.firstName(faker.name().firstName())
				.lastName(faker.name().lastName())
				.referenceNo(faker.crypto().sha256())
				.middleName(faker.name().nameWithMiddle())
				.study(study)
				.addresses(Address.builder().address_type(ADDRESS_TYPE.POSTAL).build())
				.active(faker.number().numberBetween(0, 1))
				.gender(Arrays.stream(GENDER.values()).findAny().get())
				.id(Uuids.timeBased())
				.build();

		var status = Status.StatusBuilder()
				.status(ApplicationStatus.CREATED)
				.build();

		var status1 = Status.StatusBuilder()
				.status(ApplicationStatus.OFFER_ISSUED)
				.build();

		var status2 = Status.StatusBuilder()
				.status(ApplicationStatus.ACCEPTED)
				.build();

		Map<UUID, Applicant> applicantMap = new HashMap<>();
		applicantMap.put(Uuids.timeBased(), applicant);

		var application = Application.ApplicationBuilder()
				.id(Uuids.NAMESPACE_OID)
				.gpa(78.0)
//				.applicant(applicant)
				.status(status)
				.build();

		var application1 = Application.ApplicationBuilder()
				.id(Uuids.NAMESPACE_X500)
				.gpa(56.0)
//				.applicant(applicant)
				.status(status1)
				.build();

		var application2 = Application.ApplicationBuilder()
				.id(Uuids.timeBased())
				.gpa(61.0)
//				.applicant(applicant)
				.status(status2)
				.build();
//
//		var exec = bursaryApplicationContext.processApplicationState(application);
//		var exec1 = bursaryApplicationContext.processApplicationState(application1);
//		var exec2 = bursaryApplicationContext.processApplicationState(application2);

//		System.out.println("exec = " + exec);
//		System.out.println("exec1 = " + exec1);
//		System.out.println("exec2 = " + exec2);

		applicantService.saveApplicant(applicant);

	}
}
