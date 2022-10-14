package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AddressBookServiceImpl implements IAddressBookService{

    @Override
    public ResponseEntity<List<AddressBook>> getAddressBookData() {
        List<AddressBook> addressBookList = new ArrayList<>();
        addressBookList.add(new AddressBook(101,"Mehul","Bhange","9090909090","Akole"));
        addressBookList.add(new AddressBook(102,"Abc","Xyz","9090909090","Pune"));
        return new ResponseEntity<>(addressBookList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressBook> getAddressBookDataById(int personId) {
        AddressBook addressBook = new AddressBook(personId,"Mehul","Bhange","9090909090","Akole");
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressBook> createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(101, addressBookDTO);
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressBook> updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(personId, addressBookDTO);
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAddressBookData(int personId) {
        return new ResponseEntity<>("Deleted address book data for id : "+personId, HttpStatus.OK);
    }


}
