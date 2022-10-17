package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Size(min = 10,max = 10)
    private String contactNo;
    @NotEmpty(message = "City cannot be empty")
    private String city;


}
