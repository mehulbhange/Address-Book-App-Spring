package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
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
    public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
        String msg = "Address book data created";
        ResponseDTO respDTO = new ResponseDTO( msg, addressBookDTO);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("personId") int personId,
                                                        @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO respDTO = new ResponseDTO("updated adressBook data", addressBookDTO);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable("personId") int personId) {
        return new ResponseEntity<String> ("Deleted address book data for Id : "+personId, HttpStatus.OK);
    }
}
