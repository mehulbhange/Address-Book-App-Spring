package com.bridgelabz.addressbook.service;

public interface EmailService {
    // method to send a simple email
    String sendSimpleMail(String recipient, String subject, String body);
}
