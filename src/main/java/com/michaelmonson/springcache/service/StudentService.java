package com.michaelmonson.springcache.service;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.michaelmonson.springcache.domain.ContactInfo;
import com.michaelmonson.springcache.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

	private final CacheService cacheService;

	@Autowired
		public StudentService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Cacheable("student")
	public Student getStudentByID(Long studentId) {
    try {
    	System.out.println("Going to sleep for 2 Secs.. to simulate backend call.");
      	Thread.sleep(1000 * 2);

    } catch (InterruptedException e) {
		e.printStackTrace();
    }

    // Provides utility methods for generating fake strings, such as names and numbers
    Faker faker = new Faker();
    Name studentName = faker.name();
    Address address = faker.address();
    String middleName = new Faker().name().firstName(); //although I can return a name with a middle name, I can't grab the middle name separately.  So creating a new name will work for that
    String activeStudent =  Math.random() > 0.5 ? "Y" : "N";

    ContactInfo contactInfo = new ContactInfo(UUID.randomUUID().toString(), studentId,
            address.streetAddress(), address.city(), address.stateAbbr(), address.zipCode(),
            faker.phoneNumber().phoneNumber(), faker.internet().emailAddress());

    return new Student(studentId, studentName.fullName(), studentName.lastName(), studentName.firstName(), middleName,
		studentName.title(), activeStudent, contactInfo);
	}


	public List<Student> getStudents() {

    	List<Object> cacheObjects = cacheService.getAllEntriesFromStudentCache("student");

		return cacheObjects.stream().map( object -> (Student)object ).toList();
  	}

}
