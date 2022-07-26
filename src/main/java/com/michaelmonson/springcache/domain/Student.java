
package com.michaelmonson.springcache.domain;

public class Student {
    
    private String id;
    private String name;
    private String address;
    private String phone;
    private String clz;

    public Student(String id, String name, String address, String phone, String clz) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.clz = clz;
    }

    //Setters and getters

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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }    
 
    public String getClz() {
        return clz;
    }
    public void setClz(String clz) {
        this.clz = clz;
    }
   
}
