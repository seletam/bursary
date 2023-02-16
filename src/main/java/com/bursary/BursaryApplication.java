package com.bursary;

import com.bursary.entities.Applicant;
import com.bursary.entities.objects.GENDER;
import com.bursary.state.ApplicationStateFactory;
import com.bursary.state.ApplicationStateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@EnableCassandraRepositories
@SpringBootApplication
public class BursaryApplication implements CommandLineRunner {

	private final ApplicationStateFactory applicationStateFactory;

	@Autowired
	public BursaryApplication(ApplicationStateFactory applicationStateFactory) {
		this.applicationStateFactory = applicationStateFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(BursaryApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Applicant applicant = Applicant.builder()
				.dob(new Date())
				.email("Seletam@gmail.com")
				.gender(GENDER.MALE).firstName("Seleta")
				.lastName("Mootwane")
				.referenceNo(UUID.randomUUID().toString())
				.middleName("Keane")
				.build();

		applicationStateFactory.getInstance(ApplicationStateType.CREATION, applicant);
	}

	public Integer bubbleSearch(int[] arr, int k) {

		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr[k - 1];
	}



	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
}
