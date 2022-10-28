package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook,Long> {
    AddressBook findByEmail(String email);
    List<AddressBook> findByCity(String city);
}
