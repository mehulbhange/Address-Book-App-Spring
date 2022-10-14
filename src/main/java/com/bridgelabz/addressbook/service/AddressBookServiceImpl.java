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

    List<AddressBook> addressBookList = new ArrayList<>();

    @Override
    public ResponseEntity<List<AddressBook>> getAddressBookData() {
        return new ResponseEntity<>(addressBookList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressBook> getAddressBookDataById(int personId) {
        AddressBook addressBook = null;
        for (AddressBook addBook : addressBookList){
            if (addBook.getId() == personId){
                addressBook = addBook;
            }
        }
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressBook> createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookList.size()+1 , addressBookDTO);
        addressBookList.add(addressBook);
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressBook> updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = null;
        for (AddressBook addBook : addressBookList){
            if (addBook.getId() == personId){
                addressBookList.remove(addBook);
                addressBook = new AddressBook(personId,addressBookDTO);
                addressBookList.add(addressBook);
            }
        }
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAddressBookData(int personId) {
        for (AddressBook addBook : addressBookList){
            if (addBook.getId() == personId){
                addressBookList.remove(addBook);
                return new ResponseEntity<>("Deleted address book data for id : "+personId, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Address book data not found for id : "+personId, HttpStatus.NOT_FOUND);
    }


}
