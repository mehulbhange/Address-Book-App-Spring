package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    @NotEmpty(message = "first name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First name Invalid")
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Last name Invalid")
    private String lastName;
    @NotEmpty(message = "Contact number cannot be empty")
    @Size(min = 10,max = 10, message = "Contact number must be 10 digit p")
    private String contactNo;
    @Email(message = "Invalid email ")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotEmpty(message = "City cannot be empty")
    private String city;
    @NotEmpty(message = "State cannot be empty")
    private String state;
    @Pattern(regexp = "^[0-9]{6}$")
    private String zip;

}
