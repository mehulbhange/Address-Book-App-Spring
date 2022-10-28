package com.bridgelabz.addressbook.entity;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String email;
    private String city;
    private String state;
    private String zip;

    public AddressBook(AddressBookDTO addressBookDTO){
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.contactNo = addressBookDTO.getContactNo();
        this.city = addressBookDTO.getCity();
        this.email = addressBookDTO.getEmail();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();
    }

}
