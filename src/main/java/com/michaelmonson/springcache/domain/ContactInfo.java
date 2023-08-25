
package com.michaelmonson.springcache.domain;

public class ContactInfo {

    private String id;
    private Long studentId; //linked to Student record
    private String streetAddress;
    private String city;
    private String stateCode;
    private String zipCode;
    private String phone;
    private String email;


    public ContactInfo() {
        //Default constructor
    }

    public ContactInfo(String id, Long studentId, String streetAddress, String city, String stateCode, String zipCode,
                       String phone, String email) {
        super();
        this.id = id;
        this.studentId = studentId;
        this.streetAddress = streetAddress;
        this.city = city;
        this.stateCode = stateCode;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
    }

    //Setters and getters  (TODO: Consider switching to lombok library for automatic generation of property methods)

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
