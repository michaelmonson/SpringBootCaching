package com.michaelmonson.springcache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.michaelmonson.springcache.domain.Student;

@Service
public class StudentService {

  @Cacheable("student")
  public Student getStudentByID(String id) {
    try {
      System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
      Thread.sleep(1000 * 5);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Provides utility methods for generating fake strings, such as names, phone
    // numbers, addresses. Generate random strings with given patterns
    Faker faker = new Faker();
    Address address = faker.address();
    String name = faker.name().fullName();
    // String fakeAddress = address.toString();
    String fakeAddress = address.streetAddress() + ",  " + address.city() + ",  " + address.stateAbbr() + "  "
        + address.zipCode();
    String phone = faker.phoneNumber().phoneNumber();

    return new Student(id, name, fakeAddress, phone, "Y");
  }

}
