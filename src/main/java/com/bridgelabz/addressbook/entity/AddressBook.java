package com.bridgelabz.addressbook.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddressBook {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String city;

    public AddressBook() {
    }

    public AddressBook(long id, String firstName, String lastName, String contactNo, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
