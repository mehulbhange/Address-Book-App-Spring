package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBook;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AddressBookServiceImpl implements IAddressBookService{

    //List<AddressBook> addressBookList = new ArrayList<>();
    @Autowired
    private AddressBookRepository addressBookRepo;

    /*This method is used to get all the records from db table*/
    @Override
    public ResponseEntity<List<AddressBook>> getAddressBookData() {
        return new ResponseEntity<>(addressBookRepo.findAll(),HttpStatus.OK);
    }
    /*This method takes one argument id and return the record with the particular id*/
    @Override
    public ResponseEntity<AddressBook> getAddressBookDataById(long personId) {
        AddressBook addressBook = addressBookRepo.findById(personId).orElseThrow(() -> new AddressBookException("Contact not found with id : "+personId));
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }
    /*This method takes a address book DTO as argument
    * and store it in db
    * */
    @Override
    public ResponseEntity<AddressBook> createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        addressBookRepo.save(addressBook);
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }
    /*This method takes two arguments id and AddressBookDTO
     * and update the record in db if present
     * */
    @Override
    public ResponseEntity<AddressBook> updateAddressBookData(long personId, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookRepo.findById(personId).orElseThrow(() -> new AddressBookException("Contact not found with id : "+personId));
        if (addressBook != null){
            addressBook.setFirstName(addressBookDTO.getFirstName());
            addressBook.setLastName(addressBookDTO.getLastName());
            addressBook.setContactNo(addressBookDTO.getContactNo());
            addressBook.setEmail(addressBook.getEmail());
            addressBook.setCity(addressBookDTO.getCity());
            addressBook.setState(addressBookDTO.getState());
            addressBook.setZip(addressBookDTO.getZip());
            addressBookRepo.save(addressBook);
        }
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }
    /*This method takes single argument id and deletes the particular record in db*/
    @Override
    public ResponseEntity<String> deleteAddressBookData(long personId) {
        addressBookRepo.deleteById(personId);
        return new ResponseEntity<>("Deleted address book data for id : "+personId, HttpStatus.OK);
    }
    /*This method takes a single argument email and return the particular record from db if present*/
    @Override
    public ResponseEntity<AddressBook> getAddressBookDataByEmail(String email) {
        AddressBook addressBook = addressBookRepo.findByEmail(email);
        if (addressBook != null)
            return new ResponseEntity<>(addressBook, HttpStatus.OK);
        return new ResponseEntity<>(addressBook, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<AddressBook>> getAddressBookDataByCity(String city) {
        List<AddressBook> addBookList = addressBookRepo.findByCity(city);
        if (addBookList.size() ==0 ){
            return new ResponseEntity<>(addBookList, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addBookList, HttpStatus.OK);
    }


}
