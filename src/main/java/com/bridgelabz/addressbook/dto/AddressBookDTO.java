package com.bridgelabz.addressbook.dto;

public class AddressBookDTO {
    private String firstName;
    private String lastName;
    private String contactNo;
    private String city;

    public AddressBookDTO() {
    }

    public AddressBookDTO(String firstName, String lastName, String contactNo, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.city = city;
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
