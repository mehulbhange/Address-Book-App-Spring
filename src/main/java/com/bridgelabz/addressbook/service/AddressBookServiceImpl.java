package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AddressBookServiceImpl implements IAddressBookService{

    List<AddressBook> addressBookList = new ArrayList<>();
    @Autowired
    private AddressBookRepository addressBookRepo;

    @Override
    public ResponseEntity<List<AddressBook>> getAddressBookData() {
        return new ResponseEntity<>(addressBookRepo.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressBook> getAddressBookDataById(long personId) {
        AddressBook addressBook = addressBookRepo.findById(personId).orElse(null);
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressBook> createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        addressBookRepo.save(addressBook);
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressBook> updateAddressBookData(long personId, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookRepo.findById(personId).orElse(null);
        if (addressBook != null){
            addressBook.setFirstName(addressBookDTO.getFirstName());
            addressBook.setLastName(addressBookDTO.getLastName());
            addressBook.setContactNo(addressBookDTO.getContactNo());
            addressBook.setCity(addressBook.getCity());
            addressBookRepo.save(addressBook);
        }
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAddressBookData(long personId) {
        addressBookRepo.deleteById(personId);
        return new ResponseEntity<>("Deleted address book data for id : "+personId, HttpStatus.OK);
    }


}
