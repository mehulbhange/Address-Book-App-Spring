package com.bridgelabz.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressbookApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AddressbookApplication.class, args);
        log.info("Address book application started");
        log.info("Address book application started in "+context.getEnvironment().getProperty("environment")+" Environment");

    }

}
