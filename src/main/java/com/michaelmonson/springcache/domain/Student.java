
package com.michaelmonson.springcache.domain;

public class Student {
    
    private Long studentId;
    private String fullName;
    private String nameLast;
    private String nameFirst;
    private String nameMiddle;
    private String honorific;
    private String active;

    private ContactInfo contactInfo;


    //Full Constructor:
    public Student(Long studentId, String fullName, String nameLast, String nameFirst, String nameMiddle,
                   String honorific, String active, ContactInfo contactInfo) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.nameLast = nameLast;
        this.nameFirst = nameFirst;
        this.nameMiddle = nameMiddle;
        this.honorific = honorific;
        this.active = active;

        this.contactInfo = contactInfo;

    }

//Setters and getters  (TODO: Consider switching to lombok library for automatic generation of property methods)

    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNameLast() {
        return nameLast;
    }
    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getNameFirst() {
        return nameFirst;
    }
    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameMiddle() {
        return nameMiddle;
    }
    public void setNameMiddle(String nameMiddle) {
        this.nameMiddle = nameMiddle;
    }

    public String getHonorific() {
        return honorific;
    }
    public void setHonorific(String honorific) {
        this.honorific = honorific;
    }

    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
    }

    //Contact Information for the student:
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
