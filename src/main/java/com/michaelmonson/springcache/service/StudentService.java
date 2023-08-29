package com.michaelmonson.springcache.service;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.michaelmonson.springcache.domain.ContactInfo;
import com.michaelmonson.springcache.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
    	System.out.println("  --> Going to sleep for 2 Secs.. to simulate backend call.");
      	Thread.sleep(1000 * 2);

    } catch (InterruptedException e) {
		e.printStackTrace();
    }

    // Provides utility methods for generating fake strings, such as names and numbers
    Faker faker = new Faker();
    Name studentName = faker.name();
    Address address = faker.address();
    String nameFirst = address.firstName();
	String nameLast = address.lastName();
	String nameMiddle = new Faker().name().firstName(); //although the 'fullName' will often return a middle name, there isn't a method to grab the middle name separately.
	String fullName = nameFirst + " " + nameMiddle + " " + nameLast;
    String activeStudent =  Math.random() > 0.5 ? "Y" : "N";

    ContactInfo contactInfo = new ContactInfo(UUID.randomUUID().toString(), studentId,
            address.streetAddress(), address.city(), address.stateAbbr(), address.zipCode(),
            faker.phoneNumber().phoneNumber(), faker.internet().emailAddress());

    return new Student(studentId, fullName, nameLast, nameFirst, nameMiddle,
		studentName.title(), activeStudent, contactInfo);
	}


	@CacheEvict(value = "student", key = "#studentId")
	public void deleteStudent(Long studentId) {
		//no code here?
		System.out.println("  --> Student #" + studentId + " has been deleted from memory cache.");
	}


	public List<Student> getStudents() {

    	List<Object> cacheObjects = cacheService.getAllEntriesFromStudentCache("student");

		return cacheObjects.stream().map( object -> (Student)object ).toList();
  	}

}
