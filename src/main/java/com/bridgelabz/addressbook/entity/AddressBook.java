package com.bridgelabz.addressbook.entity;

import com.bridgelabz.addressbook.dto.AddressBookDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    /*public AddressBook(long id, AddressBookDTO addressBookDTO){
        this.id = id;
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.contactNo = addressBookDTO.getContactNo();
        this.city = addressBookDTO.getCity();
    }*/
    public AddressBook(AddressBookDTO addressBookDTO){
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.contactNo = addressBookDTO.getContactNo();
        this.city = addressBookDTO.getCity();
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
