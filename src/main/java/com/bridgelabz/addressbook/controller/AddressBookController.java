package com.bridgelabz.addressbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getAddressBookData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<String> getAddressBookData(@PathVariable("personId") int personId) {
        return new ResponseEntity<String> ("Get Call Successfull for id: "+personId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addAddressBookData() {
        return new ResponseEntity<String> ("Created address book Data ", HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<String> updateAddressBookData(@PathVariable("personId") int personId) {
        return new ResponseEntity<String> ("Updated address book Data for: "+personId, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable("personId") int personId) {
        return new ResponseEntity<String> ("Deleted address book data for Id : "+personId, HttpStatus.OK);
    }
}
