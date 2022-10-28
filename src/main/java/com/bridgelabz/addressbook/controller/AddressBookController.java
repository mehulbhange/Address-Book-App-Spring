package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.entity.AddressBook;
import com.bridgelabz.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;
    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<List<AddressBook>> getAddressBookData() {
        return addressBookService.getAddressBookData();
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<AddressBook> getAddressBookData(@PathVariable("personId") int personId) {
        return addressBookService.getAddressBookDataById(personId);
    }

    @PostMapping("/create")
    public ResponseEntity<AddressBook> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.createAddressBookData(addressBookDTO);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<AddressBook> updateAddressBookData(@PathVariable("personId") int personId,
                                                        @Valid @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.updateAddressBookData(personId,addressBookDTO);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable("personId") int personId) {
        return addressBookService.deleteAddressBookData(personId);
    }
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<AddressBook> getAddressBookByEmail(@PathVariable("email") String email){
        return addressBookService.getAddressBookDataByEmail(email);
    }

    @GetMapping("/getByCity/{city}")
    public ResponseEntity<List<AddressBook>> getAddressBookByCity(@PathVariable("city") String city){
        return addressBookService.getAddressBookDataByCity(city);
    }
}
