
package com.michaelmonson.springcache.domain;

public class Student {
    
    private String id;
    private String name;
    private String address;
    private String city;
    private String stateCode;
    private String zipCode;
    private String phone;
    private String active;

    public Student(String id, String name, String address, String city, String stateCode, String zipCode, String phone, String active) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.stateCode = stateCode;
        this.zipCode = zipCode;
        this.phone = phone;
        this.active = active;
    }

    //Setters and getters  (TODO: Consider switching to lombok library for automatic generation of property methods)

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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
 
    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
    }


   
}
